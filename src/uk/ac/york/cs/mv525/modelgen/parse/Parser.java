package uk.ac.york.cs.mv525.modelgen.parse;


import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.mv525.modelgen.ResourceOperator;
import uk.ac.york.cs.mv525.modelgen.index.Collection;

public class Parser extends ResourceOperator {

	private EPackage ePackage;
	public ArrayList<EClass> eClasses;
	public ArrayList<EReference> eReferences;
	
	private Collection mCollection;
	
	private Resource metaModel;

	public Parser(String metamodelLocation) throws IOException {
		metaModel = readMetaModel(metamodelLocation);

		eClasses = new ArrayList<EClass>();
		eReferences = new ArrayList<EReference>();
		
		mCollection = new Collection();
		
	}

	public Collection parse() throws Exception {
		

		// Read metamodel
		// Scan for classes
		// Scan for references
		
		findEPackage();

		for (EObject eobj : metaModel.getContents()) {
			walkETree(eobj);
		}

		printEClasses();
		printEReferences();
		
		return mCollection;
	}
	
	public EPackage getEPackage() {
		return ePackage;
	}
	

	private void findEPackage() {
		ePackage = (EPackage) metaModel.getContents().get(0);
		mCollection.add(ePackage);
	}
	private void walkETree(EObject eobjs) {

		mCollection.add(eobjs);
		
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
