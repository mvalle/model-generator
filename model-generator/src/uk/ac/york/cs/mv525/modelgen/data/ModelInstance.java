package uk.ac.york.cs.mv525.modelgen.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ModelInstance {

	public ModelInstance() {
		super();
	}
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
		
		// First add the object to the actual resource
		resource.getContents().add(iObject);
		
		// Second, index the object with it's class
		insert(iObject, iObject.eClass());
		
		// Finally, index the object with all it's parent classes
		for(EClass mSuperClass:  iObject.eClass().getEAllSuperTypes()) {
			System.out.println("Indexing "+iObject.eClass().getName()+"\t as "+mSuperClass.getName());
			insert(iObject, mSuperClass);
		}
	}
	
	protected void insert(EObject iObject, EClass mClass) {
		if(iIndex.containsKey(mClass.getName())) {
			ArrayList<EObject> o = iIndex.get(mClass.getName());
			o.add(iObject);
			
		} else {
			ArrayList<EObject> o = new ArrayList<EObject>();
			o.add(iObject);
			iIndex.put(mClass.getName(), o);
		}
	}
		
	public EObject get(String name) {
		ArrayList<EObject> o = iIndex.get(name);
		if (o != null) {
			return o.get(0);
		}
		
		return null;
	}
	
	public List<EObject> getObjects(String name) {
		ArrayList<EObject> o = iIndex.get(name);		
		return o;
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

	public ArrayList<EObject> dump() {
		
		ArrayList<EObject> output = new ArrayList<>();
		
		// Include objects once;
		for(Entry<String, ArrayList<EObject>> entry : iIndex.entrySet()) {
			for(EObject indexedObject : entry.getValue()) {
				if (indexedObject.eClass().getName().equals(entry.getKey())) {
					output.add(indexedObject);
				} else {
					//System.out.println( entry.getKey() + ": Not including " + indexedObject );
				}
				
			}
		}
		
		return output;		
	}
}