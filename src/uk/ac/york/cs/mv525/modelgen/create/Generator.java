package uk.ac.york.cs.mv525.modelgen.create;

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

import uk.ac.york.cs.mv525.modelgen.ResourceOperator;
import uk.ac.york.cs.mv525.modelgen.index.Collection;
import uk.ac.york.cs.mv525.modelgen.parse.Parser;

public class Generator extends ResourceOperator {

	private static final int scale = 3;
	private Parser parser;
	private Resource modelResource;
	private EPackage ePackage;

	private ModelInstance instance;
	
	public Generator(String metamodelLocation) throws Exception {

		parser = new Parser(metamodelLocation);

		// Create Model
		// Create 100 Classes
		// // Add attributes
		// Create 100 References
	}

	public void generate() throws Exception {
		Collection mCollection = parser.parse();
		
		instance = new ModelInstance(mCollection);
		
		ePackage = parser.getEPackage();
		
		createModel(getModelDir("testmodel.model"));

	}

	public void createModel(String model) throws Exception {
		modelResource = getResourceSet("model").createResource(
				URI.createFileURI(model));

		addClasses();
		addReferences();

		modelResource.save(null);
	}

	private void addReferences() {
		EList<EObject> modelResourceContents = modelResource.getContents();
		System.out.println("References: "+parser.eReferences.size());
		
		
		for (EReference eReference : parser.eReferences) {

			if(eReference.isContainment()) {
				// We don't want to add containment references, only regular references.
				continue;
			}
			
			// Get the name of the referenced type
			EClassifier type = eReference.getEType();
			String referencedTypeName = type.getName();

			// Get the name of the class the reference belongs to
			EClass containingEClass = eReference.getEContainingClass();
			String containingClassName = containingEClass.getName();
			
			EObject iReferencedObject = instance.get(containingEClass);
			
			EList<EObject> eObjectsReferenced = (EList<EObject>) iReferencedObject.eGet(eReference);

			Iterable<EObject> iInnerObjects = instance.iterable((EClass)type);
			
			for (EObject innerEClassInstance : iInnerObjects) {
				eObjectsReferenced.add(innerEClassInstance);
			}
		}
	}

	private void addClasses() {
		for (EClass mClass : parser.eClasses) {
			for (int i = 0; i < scale; i++) {
				
				EObject iObject = createInstance(mClass);
				
				instance.add(iObject);
				
				
				System.out.println(iObject.eClass().getName() + " = " + iObject.eClass().getClassifierID());
				
				addAttributes(iObject, mClass);				
			}
		}
	}
	
	private void addAttributes(EObject eInstance, EClass eClass) {

		for(EStructuralFeature eFeature: eClass.getEStructuralFeatures()) {
			
			System.out.println(eFeature.getName());
			
			EClassifier type = eFeature.getEType();
			
			if(type.eClass().getName()=="EClass") {
				print (" is class reference");				
				print (" " + eClass.getName() + " -> " + type.getName());
				print (" is it a containment? "+((EReference)eFeature).isContainment());
				print (" is feature set: "+eInstance.eIsSet(eFeature));
				
				EObject attributeInstance = createInstance(type);
				
				print ("  created new "+attributeInstance.eClass().getName());
				
				EList<EObject> containment = (EList<EObject>) eInstance.eGet(eFeature);			
				
				containment.add(attributeInstance);
				
				print ("  added to continon of size " + containment.size() );
				
				eInstance.eSet(eFeature, containment);
				
				print (" is feature set: "+eInstance.eIsSet(eFeature)); // WHY!?!
				
			} else if (type.eClass().getName()=="EDataType") {
				print (" is datatype");

				if(eFeature.getEType().getName()=="EString") {
					eInstance.eSet(eFeature, randomString());
					
				} else {
					print("Unknown EDataType");
				}
				
				
				
			} else {
				print ("Unknown EClassifier class: " + type.eClass().getName());
			}
					
		}		
	}

	private EObject createInstance(EClassifier eClassifier) {
		return createInstance((EClass) eClassifier);
	}

	private EObject createInstance(EClass eClass) {

		EFactory eClassGenerator = ePackage.getEFactoryInstance();
		
		EObject eClassInstance = eClassGenerator.create(eClass);
		//EObject eClassInstance2 = eClassGenerator.create(eClass2);
		
		return eClassInstance;
	}
	
	
	private String randomString() {
		return "Hello" + (new Random()).nextInt();
		
	}
	
	

}























