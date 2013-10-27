package uk.ac.york.cs.mv525.modelgen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Generator extends ResourceOperator {

	private int scale = 100;
	private Parser parser;
	private Resource modelResource;
	
	public Generator(String metamodelLocation) throws Exception {

		parser = new Parser(metamodelLocation);

		// Create Model
		// Create 100 Classes
		// // Add attributes
		// Create 100 References
		
	}
	
	public void generate() throws Exception {
		parser.parse();
		
		createModel(parser.getEPackage(), getModelDir("testmodel.model"));
		
	}
	
	public void createModel(EPackage ePackage, String model) throws Exception {
		modelResource = getResourceSet("model").createResource(URI.createFileURI(model));
		
		EList<EObject> modelResourceContents = modelResource.getContents();
		
		for(EClass eClass : parser.eClasses) {
			EObject eClassInstance = ePackage.getEFactoryInstance().create(eClass);
			
			modelResourceContents.add(eClassInstance);
				
		}
		
		modelResource.save(null);
		
	}
	
	public Resource createModels(EPackage ePackage, String modelname) throws Exception {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(modelname));
		//
		EClass person = (EClass) ePackage.getEClassifier("Person");
		EClass company = (EClass) ePackage.getEClassifier("Company");
		
		EObject someCompany = ePackage.getEFactoryInstance().create(company);
		EObject john = ePackage.getEFactoryInstance().create(person);
		EObject tom = ePackage.getEFactoryInstance().create(person);
		
		System.err.println(resource);
		
		resource.getContents().add(someCompany);
		
		EReference employeesReference = (EReference) company.getEStructuralFeature("employees");
		
		EList<EObject> employees = (EList<EObject>) someCompany.eGet(employeesReference);
		employees.add(john);
		employees.add(tom);
		
		EAttribute nameAttribute = (EAttribute) person.getEStructuralFeature("name");
		tom.eSet(nameAttribute, "Tom");
		john.eSet(nameAttribute, "John");
		
		EReference managesReference = (EReference) person.getEStructuralFeature("manages");
		EList<EObject> manages = (EList<EObject>) tom.eGet(managesReference);
		manages.add(john);
		
		return resource;
	}

	//
}














































