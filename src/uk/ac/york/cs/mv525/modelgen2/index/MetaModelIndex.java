package uk.ac.york.cs.mv525.modelgen2.index;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class MetaModelIndex implements Index {

	HashMap<String, EObject> index;
	EPackage ePackage;
	
	public MetaModelIndex() {
		index = new HashMap<>();
	}	
	
	public void add(String name, EObject object) {
		index.put(name, object);
	}
		
	public EObject get(String name) {
		return index.get(name);
	}
	
	public Collection<EObject> dump() {
		return index.values();		
	}

	public void setEPackage(EPackage pack) {
		ePackage = pack;
	}

	public EPackage getEPackage() {
		return ePackage;
	}

	public boolean exists(String name) {
		return index.containsKey(name);
	}

	public long getCount() {
		return index.size();
	}
}