package uk.ac.york.cs.mv525.modelgen.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ModelInstance {

	HashMap<String, ArrayList<EObject>> iIndex; // Index of the model elements
	
	private Resource resource;
	
	public ModelInstance(String location) {
		String suffix;
		{
			String[] s = location.split("\\.");
			assert(s.length >=2);
			suffix = s[s.length-1];
		}

		ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                        .put(suffix, new XMIResourceFactoryImpl());
        
		resource = resourceSet.createResource(
					URI.createFileURI(location));
		
		iIndex = new HashMap<>();	
	}
	
	public void add(EObject iObject) {
		if(iIndex.containsKey(iObject.eClass().getName())) {
			ArrayList<EObject> o = iIndex.get(iObject.eClass().getName());
			o.add(iObject);
			
		} else {
			ArrayList<EObject> o = new ArrayList<EObject>();
			o.add(iObject);
			iIndex.put(iObject.eClass().getName(), o);
		}
		
		resource.getContents().add(iObject);
	}
		
	public EObject get(String name) {
		ArrayList<EObject> o = iIndex.get(name);
		if (o != null) {
			return o.get(0);
		}
		
		return null;
	}
	

	public Resource getResource() {
		return resource;
	}

	public long getCount() {
		long count = 0;
		for(ArrayList<EObject> l : iIndex.values()) {
			count += l.size();
		}
		
		long size = resource.getContents().size();
		assert(size == count);
		
		return count;
	}

	public void save() throws IOException {
		resource.save(null);
	}
}