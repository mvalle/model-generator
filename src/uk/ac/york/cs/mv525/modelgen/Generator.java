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

public class Generator {

	private int scale = 100;
	
	public Generator(String metamodelLocation) throws IOException {

		Parser parser = new Parser(metamodelLocation);
		parser.parse();
		
	}
	
	

	// Read metamodel
	// Scan for classes
	// Scan for references
	// Create 100 Classes
	// // Add attributes
	// Create 100 References
	//
}
