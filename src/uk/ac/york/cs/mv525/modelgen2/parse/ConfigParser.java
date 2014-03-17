package uk.ac.york.cs.mv525.modelgen2.parse;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration;

import uk.ac.york.cs.mv525.modelgen2.data.Configuration;

public class ConfigParser {
	
	@Deprecated
	public ConfigParser() {
		
	}
	public static Configuration parse(String location) throws IOException {
		
		// Initialise the ConfigPackage
		ConfigPackage.eINSTANCE.eClass();
		
		Resource resource;
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("*", new XMIResourceFactoryImpl());
		
		resource = resourceSet.createResource(
			URI.createFileURI(location));

		resource.load(null);
		
		
		
		ModelConfiguration config = (ModelConfiguration) resource.getContents().get(0);
		
		Configuration cIndex = new Configuration(config);
		
		return cIndex;

	}
	


}




















