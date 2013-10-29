package uk.ac.york.cs.mv525.modelgen;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ResourceOperator {
		
	protected static String getModelDir() {
		String workingdir = System.getProperty("user.dir");
		String modeldir = "models";
		
		return workingdir + "/" + modeldir;
	}

	
	protected static String getModelDir(String modelName) {
		return getModelDir() + "/" + modelName;
	}
	
	protected static Resource readMetaModel(String location) throws IOException {

		Resource resource = getResourceSet().createResource(
				URI.createFileURI(location));
		resource.load(null);

		return resource;

	}
	
	protected static ResourceSet getResourceSet() {
		return getResourceSet("*");
	}
	
	protected static ResourceSet getResourceSet(String suffix) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(suffix, new XMIResourceFactoryImpl());

		return resourceSet;
	}
	
	protected static void print(String s) {
		System.out.println(s);
	}
	protected static void print(Object o) {
		System.out.println(o);
	}
}
