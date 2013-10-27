package uk.ac.york.cs.mv525.modelgen;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

public class Parser {

	private EPackage ePackage;
	private ArrayList<EClass> eClasses;
	private ArrayList<EReference> eReferences;
	private Resource metaModel;

	public Parser(String metamodelLocation) throws IOException {
		metaModel = readMetaModel(metamodelLocation);

		eClasses = new ArrayList<EClass>();
		eReferences = new ArrayList<EReference>();
	}

	public void parse() throws Exception {

		findEPackage();

		for (EObject eobj : metaModel.getContents()) {
			walkETree(eobj);
		}

		printEClasses();
		printEReferences();
	}

	private void findEPackage() {
		ePackage = (EPackage) metaModel.getContents().get(0);
	}

	private void walkETree(EObject eobjs) {

		try {
			ENamedElement enes = (ENamedElement) eobjs;

			if (enes.eClass().getName() == "EClass") {
				eClasses.add((EClass) enes);
			} else if (enes.eClass().getName() == "EReference") {
				eReferences.add((EReference) enes);
			}

			for (EObject eobj : eobjs.eContents()) {
				walkETree(eobj);
			}
		} catch (ClassCastException ex) {
		}

	}

	private void printEClasses() {

		for (EClass e : eClasses) {
			System.out.println(e.getName());
		}

	}
	private void printEReferences() {

		for (EReference e : eReferences) {
			System.out.println(e.getName());
		}

	}

	private Resource readMetaModel(String location) throws IOException {

		Resource resource = getResourceSet().createResource(
				URI.createFileURI(location));
		resource.load(null);

		return resource;

	}

	private ResourceSet getResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMIResourceFactoryImpl());

		return resourceSet;
	}
}
