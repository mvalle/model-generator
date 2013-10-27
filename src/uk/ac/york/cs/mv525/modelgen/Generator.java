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
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Generator extends ResourceOperator {

	private static final int scale = 10;
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
		modelResource = getResourceSet("model").createResource(
				URI.createFileURI(model));

		addClasses(ePackage);
		addReferences();

		modelResource.save(null);
	}

	private void addReferences() {
		EList<EObject> modelResourceContents = modelResource.getContents();
		for (EReference eReference : parser.eReferences) {

			// Get the name of the referenced type
			EClassifier type = eReference.getEType();
			String referencedTypeName = type.getName();

			// Get the name of the class the reference belongs to
			EClass containingEClass = eReference.getEContainingClass();
			String containingClassName = containingEClass.getName();

			// Find a class like that
			for (EObject eClassInstance : modelResourceContents) {

				if (eClassInstance.eClass().getName() == containingClassName) {
					EList<EObject> eObjectsReferenced = (EList<EObject>) eClassInstance.eGet(eReference);

					for (EObject innerEClassInstance : modelResourceContents) {
						if (innerEClassInstance.eClass().getName() == referencedTypeName) {
							eObjectsReferenced.add(innerEClassInstance);
						}
					}
				}
			}

		}
	}

	private EList<EObject> addClasses(EPackage ePackage) {
		EList<EObject> modelResourceContents = modelResource.getContents();

		for (EClass eClass : parser.eClasses) {
			EFactory eClassGenerator = ePackage.getEFactoryInstance();
			for (int i = 0; i < scale; i++) {
				EObject eClassInstance = eClassGenerator.create(eClass);
				modelResourceContents.add(eClassInstance);
			}
		}
		return modelResourceContents;
	}

}
