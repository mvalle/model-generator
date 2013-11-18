package uk.ac.york.cs.mv525.modelgen.index;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class Collection {

	private HashMap<EClass, Container> collection;
	
	public Collection() {
		collection = new HashMap<EClass, Container>();
	}
	
	public void add(EObject iObject) {
		if(collection.containsKey(iObject.eClass()))
		{
			collection.get(iObject.eClass()).add(iObject);
		}
		else 
		{
			collection.put(iObject.eClass(), new Container(iObject));
		}
	}
	
	public EObject get(EClass mClass) {
		return collection.get(mClass).get();
	}
	
	public EObject get(EObject iObject) {
		return collection.get(iObject.eClass()).get();
	}
	
}
