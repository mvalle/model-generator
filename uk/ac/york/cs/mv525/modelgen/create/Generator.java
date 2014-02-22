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

			// System.out.println(mAttribute.getName());

			EClassifier mAttributeType = mAttribute.getEType();

			if (mAttributeType instanceof EClass) {
				// System.out.println("EClass instanceof found");

				EReference mReference = (EReference) mAttribute;

				if (mReference.isContainment()) {
					// System.out.println("Containtment found.");

					EList<EObject> iAttributeContainer = (EList<EObject>) iObject
							.eGet(mReference);
					EObject iAttributeContainedObject = instance
							.createWithoutAdding((EClass) mAttributeType);

					iAttributeContainer.add(iAttributeContainedObject);

				} else if (!iObject.eIsSet(mAttribute)) {
					// If a reference is not a containment....
					// TODO if a reference is not a list, then skipp.

					// System.out.println("Regular reference found.");

					// Get an object the reference belongs to
					EClass mOwnerClass = mReference.getEContainingClass();
					EObject iOwningObject = instance.get(mOwnerClass);

					if (iOwningObject == null) {
						iOwningObject = instance.create(mOwnerClass);
					}

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
				System.out.println("EDataType instanceof found");

				if (iObject.eIsSet(mAttribute)) {
					return;
				}

				// Non Random generator
				Object iAttribute = instance.createAttribute(iObject,
						mAttribute);

				if (iAttribute != null) {
					return;
				}

				// Random Generator
				if (mAttribute.getEType().getName() == "EString") {
					iObject.eSet(mAttribute, randomString());

				} else {
					// print("Unknown EDataType");
				}
			}

		}
	}

	private String randomString() {
		return "Hello" + (new Random()).nextInt();

	}
}
