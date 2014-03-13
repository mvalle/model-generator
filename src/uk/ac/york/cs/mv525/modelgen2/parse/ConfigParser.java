package uk.ac.york.cs.mv525.modelgen2.parse;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import uk.ac.york.cs.mv525.modelgen2.index.ConfigIndex;

public class ConfigParser implements Parser {

	@Override
	public ConfigIndex parse(String location) throws IOException {
		// TODO : Implement this feature
		
		Resource resource;
		
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMIResourceFactoryImpl());
		
			resource = resourceSet.createResource(
				URI.createFileURI(location));
		
			resource.load(null);
			
		} catch (IOException e) {
			throw new IOException("Unable to find MetaModel file. MetaModel file is required.");
		}
		
		ConfigIndex cIndex = new ConfigIndex();
		
		return cIndex;

	}


}
