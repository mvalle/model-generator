package uk.ac.york.cs.mv525.modelgen2.index;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;

public class ModelIndex implements Index {

	HashMap<String, EObject> index;
	
	@Override
	public void add(String name, EObject object) {
		index.put(name, object);
	}

	@Override
	public EObject get(String name) {
		return index.get(name);
	}
	
	public Collection<EObject> dump() {
		return index.values();
		
	}

}
