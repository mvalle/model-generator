package uk.ac.york.cs.mv525.modelgen.parse;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;

public class MetaModelParser{

	@Deprecated
	public MetaModelParser() {
		
	}
	
	public static MetaModelIndex parse(String location) throws IOException {
		Resource resource;
				
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("*", new XMIResourceFactoryImpl());
			
		resource = resourceSet.createResource(
			URI.createFileURI(location));
		
		resource.load(null);
		
	
		MetaModelIndex mmIndex = new MetaModelIndex();
		
		mmIndex.setEPackage( (EPackage) resource.getContents().get(0));
		
		
		populateIndex(mmIndex, resource.getContents());
				
		return mmIndex;

	}
	
	private static void populateIndex(MetaModelIndex mmIndex, EList<EObject> mObjs) {
		// TODO : Investigate whether .equals("EClass") is necessary or useful;
		for(EObject mObj : mObjs) {
			if(mObj.eClass().getName().equals("EClass")) {

				EClass mClass = (EClass)mObj;
				mmIndex.add(mClass);
				//mmIndex.add(mClass.getName(), mClass);
				
			}
			populateIndex(mmIndex, mObj.eContents());
		}
		
	}
	
	

}



