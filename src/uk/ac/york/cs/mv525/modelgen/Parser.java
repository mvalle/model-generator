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

public class Parser extends ResourceOperator {

	private EPackage ePackage;
	public ArrayList<EClass> eClasses;
	public ArrayList<EReference> eReferences;
	private Resource metaModel;

	public Parser(String metamodelLocation) throws IOException {
		metaModel = readMetaModel(metamodelLocation);

		eClasses = new ArrayList<EClass>();
		eReferences = new ArrayList<EReference>();
	}

	public void parse() throws Exception {
		

		// Read metamodel
		// Scan for classes
		// Scan for references
		
		findEPackage();

		for (EObject eobj : metaModel.getContents()) {
			walkETree(eobj);
		}

		printEClasses();
		printEReferences();
	}
	
	public EPackage getEPackage() {
		return ePackage;
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
	
}
