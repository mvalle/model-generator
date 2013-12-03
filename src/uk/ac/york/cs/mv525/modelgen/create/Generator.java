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

	// TODO fix
	private static final boolean override_stupid_workaround = true;
	
	private static final int scale = 3;
	private MetamodelParser parser;
	private Resource modelResource;
	private EPackage ePackage;

	private ModelInstance instance;
	
	public Generator(String metamodelLocation) throws Exception {

		parser = new MetamodelParser(metamodelLocation);

		// Create Model
		// Create 100 Classes
		// // Add attributes
		// Create 100 References
	}

	public void generate(String programLocation) throws Exception {
		HashMap<String, EClass> mClasses = parser.parse();
		
		instance = new ModelInstance(mClasses);
		
		ePackage = parser.getEPackage();

		createModel(programLocation);
	}

	public void createModel(String programLocation) throws Exception {
		

		// Use pp with bit mCollection, but with corresponding iCollection
		// Add inside instance object,
		
		// TODO: Fix how parser is called
		
		instance.initiliseInstance("modelx", "testmodel.modelx", programLocation, ePackage);
		
		addClasses();
		//addReferences();

		instance.save();
	}

	/**
	 * Creates references between objects in 'instance'.
	 * Does not create any new EObjects
	 */
	private void addReferences() {

		//print ("References: "+parser.eReferences.size());
		
		/* TODO: Add as method with variables
		for (EReference eReference : parser.eReferences) {

			if(eReference.isContainment()) {
				// We don't want to add containment references, only regular references.
				continue;
			}

			// Get an object the reference belongs to
			EClass mOwnerClass = eReference.getEContainingClass();
			EObject iOwningObject = instance.get(mOwnerClass);
			
			// Get *all* the objects that can be referenced (are of the correct type)
			EClass mReferencedClass = (EClass) eReference.getEType();
			Iterable<EObject> iReferencedObjects = instance.iterable(mReferencedClass);

			
			EList<EObject> iContainingObjects = (EList<EObject>) iOwningObject.eGet(eReference);

			for (EObject iReferencedObject : iReferencedObjects) {
				iContainingObjects.add(iReferencedObject);
			}
		}
		*/
	}

	private void addClasses() throws EolRuntimeException {
		
		
		for (EClass mClass : parser.getEClasses().values()) {
			for (int i = 0; i < scale; i++) {
				
				EObject iObject = instance.create(mClass);
				
				//System.out.println(iObject.eClass().getName() + " = " + iObject.eClass().getClassifierID());
				
				addAttributes(iObject);				
			}
		}
	}
	
	private void addAttributes(EObject iObject) throws EolRuntimeException {

		for(EStructuralFeature mAttribute: iObject.eClass().getEStructuralFeatures()) {
			
			//System.out.println(mAttribute.getName());
			
			EClassifier mAttributeType = mAttribute.getEType();

			if (mAttributeType instanceof EClass) {
				//System.out.println("EClass instanceof found");
				
				EReference mReference = (EReference)mAttribute;
				
				if(mReference.isContainment())
				{		
					//System.out.println("Containtment found.");
					
					EList<EObject> iAttributeContainer = (EList<EObject>)iObject.eGet(mReference);
					EObject iAttributeContainedObject = createInstance(mAttributeType, false);
				
				
					iAttributeContainer.add(iAttributeContainedObject);
					
				} else {

					//System.out.println("Regular reference found.");
					
					// Get an object the reference belongs to
					EClass mOwnerClass = mReference.getEContainingClass();
					EObject iOwningObject = instance.get(mOwnerClass);
					
					if(iOwningObject == null) {
						iOwningObject = instance.create(mOwnerClass);
					}
					
					// Get *all* the objects that can be referenced (are of the correct type)
					EClass mReferencedClass = (EClass) mReference.getEType();
					Iterable<EObject> iReferencedObjects = instance.iterable(mReferencedClass);

					
					EList<EObject> iContainingObjects = (EList<EObject>) iOwningObject.eGet(mReference);

					for (EObject iReferencedObject : iReferencedObjects) {
						iContainingObjects.add(iReferencedObject);
					}
				}
				
				
			} else {
				System.out.println("EDataType instanceof found");

				if(mAttribute.getEType().getName()=="EString") {
					//print ("  is feature set: "+iObject.eIsSet(mAttribute)); // WHY!?!
					iObject.eSet(mAttribute, randomString());
					//print ("  is feature set: "+iObject.eIsSet(mAttribute)); // WHY!?!
					
				} else {
					//print("Unknown EDataType");
				}
				
				
			}
			
			/*
			if(mAttributeType.eClass().getName()=="EClass") {
				*/
				// If containment
				// Else
				
				/*
				print (" is class reference");				
				print (" " + mClass.getName() + " -> " + mType.getName());
				print (" is it a containment? "+((EReference)mFeature).isContainment());
				print (" is feature set: "+iObject.eIsSet(mFeature));
				
				EObject attributeInstance = createInstance(mType);
				
				print ("  created new "+attributeInstance.eClass().getName());
				
				EList<EObject> containment = (EList<EObject>) iObject.eGet(mFeature);			
				
				containment.add(attributeInstance);
				
				print ("  added to containment of size " + containment.size() );
				
				iObject.eSet(mFeature, containment);
				
				print (" is feature set: "+iObject.eIsSet(mFeature)); // WHY!?!
				*/
				/*
			} else if (mAttributeType.eClass().getName()=="EDataType") {
				//print (" is datatype");

				
				
			} else {
				//print ("Unknown EClassifier class: " + mAttributeType.eClass().getName());
			}
					*/
		}		
	}

	private EObject createInstance(EClassifier eClassifier, boolean add_to_instance) {
		return createInstance((EClass) eClassifier, add_to_instance);
	}

	// TODO: refactor boolean out
	private EObject createInstance(EClass eClass, boolean add_to_instance) {

		EFactory iClassGenerator = ePackage.getEFactoryInstance();
		
		//EolOperation op = 
		
		EObject iObject = iClassGenerator.create(eClass);
		//EObject eClassInstance2 = eClassGenerator.create(eClass2);
		
		if(add_to_instance || override_stupid_workaround) {
			instance.add(iObject);
		}
		
		return iObject;
	}
	
	
	private String randomString() {
		return "Hello" + (new Random()).nextInt();
		
	}
}























