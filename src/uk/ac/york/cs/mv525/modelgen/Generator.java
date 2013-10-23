package uk.ac.york.cs.mv525.modelgen;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
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

public class Generator {

	private EPackage ePackage;
	private EList<EClass> eClasses;
	private EList<EReference> eReferences;
	private Resource metaModel;
	
	public void generate()	throws Exception {
		metaModel = readMetaModel("");
		
		findEPackage();
		findEClasses();
		
	}
	
	private void findEPackage() {
		ePackage = (EPackage)metaModel.getContents().get(0);		
	}
	
	private void findEClasses() {

		for(EObject eobj: metaModel.getContents()) {
			walkETree(eobj);
		}
	}
		
	
	private  void walkETree(EObject eobjs) {

	try {
		ENamedElement enes = (ENamedElement) eobjs;
		
		if (enes.eClass().getName()=="EClass")
		{
			eClasses.add((EClass)enes);
		}
		
		for(EObject eobj: eobjs.eContents()) {

			printETree(eobj);		

		}
	}
	catch (ClassCastException ex)
	{	}
	
	
	
}
	
	private Resource readMetaModel(String location) throws IOException {
		
		Resource resource = getResourceSet().createResource(URI.createFileURI(location));
		resource.load(null);
		
		return resource;
		
	}
	
	private ResourceSet getResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.
			getResourceFactoryRegistry().
			getExtensionToFactoryMap().
			put("*", new XMIResourceFactoryImpl());
		
		return resourceSet;
	}
	
	// Read metamodel
	// Scan for classes
	// Scan for references
	// Create 100 Classes
	// // Add attributes
	// Create 100 References
	// 
}
