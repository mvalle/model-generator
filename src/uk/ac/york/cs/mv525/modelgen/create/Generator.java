package uk.ac.york.cs.mv525.modelgen.create;

import java.util.HashMap;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

import uk.ac.york.cs.mv525.modelgen.ResourceOperator;
import uk.ac.york.cs.mv525.modelgen.index.Collection;
import uk.ac.york.cs.mv525.modelgen.parse.MetamodelParser;
import uk.ac.york.cs.mv525.modelgen.parse.ProgramParser;

public class Generator extends ResourceOperator {

	private static final int scale = 3;
	private MetamodelParser parser;
	private EPackage ePackage;

	private ModelInstance instance;

	private EolGenerator eolGen;
	private RandomGenerator randomGen;
	
	
	public Generator(String metamodelLocation) throws Exception {

		parser = new MetamodelParser(metamodelLocation);
		
	}

	public void generate(String programLocation) throws Exception {
		HashMap<String, EClass> mClasses = parser.parse();

		instance = new ModelInstance(mClasses);

		ePackage = parser.getEPackage();

		
		createModel(programLocation);
	}

	private void createModel(String programLocation) throws Exception {

		// TODO: Fix how parser is called
		instance.initiliseInstance("modelx", "testmodel.modelx",
				programLocation, ePackage);

		eolGen = new EolGenerator(instance);
		randomGen = new RandomGenerator(instance);
		
		eolGen.parseProgram(programLocation);
		
		addClasses();

		instance.save();
	}

	private void addClasses() throws EolRuntimeException {

		for (EClass mClass : parser.getEClasses().values()) {
			for (int i = 0; i < scale; i++) {

				EObject iObject = instance.create(mClass);

				// System.out.println(iObject.eClass().getName() + " = " +
				// iObject.eClass().getClassifierID());

				addAttributes(iObject);
			}
		}
	}

	private void addAttributes(EObject iObject) throws EolRuntimeException {

		for (EStructuralFeature mAttribute : iObject.eClass()
				.getEStructuralFeatures()) {


			EClassifier mAttributeType = mAttribute.getEType();

			if (mAttributeType instanceof EClass) {

				EReference mReference = (EReference) mAttribute;

				if (mReference.isContainment()) {

					EList<EObject> iAttributeContainer = (EList<EObject>) iObject
							.eGet(mReference);
					
					// NOTE: Create contained object
					EObject iAttributeContainedObject = eolGen.create((EClass) mAttributeType);
					
					if (iAttributeContainedObject == null) {
						iAttributeContainedObject = randomGen.create((EClass) mAttributeType);
					}
					
					iAttributeContainer.add(iAttributeContainedObject);

				} else if (!iObject.eIsSet(mAttribute)) {
					// If a reference is not a containment....
					// TODO if a reference is not a list, then skipp.

					// Get an object the reference belongs to
					EClass mOwnerClass = mReference.getEContainingClass();
					
					EObject iOwningObject = instance.get(mOwnerClass);

					if (iOwningObject == null) {
						iOwningObject = eolGen.create(mOwnerClass);
						
						if (iOwningObject == null) {
							iOwningObject = randomGen.create(mOwnerClass);
						}
					}

					// TODO : Don't just create all of them
					// Get *all* the objects that can be referenced (are of the
					// correct type)
					EClass mReferencedClass = (EClass) mReference.getEType();
					Iterable<EObject> iReferencedObjects = instance
							.iterable(mReferencedClass);

					EList<EObject> iContainingObjects = (EList<EObject>) iOwningObject
							.eGet(mReference);

					for (EObject iReferencedObject : iReferencedObjects) {
						iContainingObjects.add(iReferencedObject);
					}
				}

			} else {
				Object iAttribute = eolGen.createAttribute(iObject,
						mAttribute);

				if (iAttribute == null) {
					randomGen.createAttribute(iObject, mAttribute);
				} 

			}

		}
	}

	private String randomString() {
		return "Hello" + (new Random()).nextInt();

	}
}
