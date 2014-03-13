package uk.ac.york.cs.mv525.modelgen2.parse;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;

public class MetaModelParser implements Parser {

	
	@Override
	public MetaModelIndex parse(String location) throws IOException {
		Resource resource;
		
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("config", new XMIResourceFactoryImpl());
		
			resourceSet.createResource(URI.createFileURI(location));
			
			resource = resourceSet.createResource(
				URI.createFileURI(location));
		
			resource.load(null);
			
		} catch (IOException e) {
			throw new IOException("Unable to find MetaModel file. MetaModel file is required.");
		}
	
		MetaModelIndex mmIndex = new MetaModelIndex();
		
		populateIndex(mmIndex, resource.getContents());
		
		return mmIndex;

	}
	
	private void populateIndex(MetaModelIndex mmIndex, EList<EObject> mObjs) {
		// TODO : Investigate wether .equals("EClass") is nessecary or usefull;
		for(EObject mObj : mObjs) {
			if(mObj.eClass().getName().equals("EClass")) {

				EClass mClass = (EClass)mObj;
				mmIndex.add(mClass.getName(), mClass);
				
			}
			populateIndex(mmIndex, mObj.eContents());
		}
		
	}
	
	

}
