package uk.ac.york.cs.mv525.modelgen.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @author magnus
 *
 * Class that contains EObjects and retrieves them by EClass.
 */
public class Collection {

//	private HashMap<EClass, Container> collection;
	private HashMap<Integer, Container> collection;
	
	public Collection() {
//		collection = new HashMap<EClass, Container>();
		collection = new HashMap<Integer, Container>();
	}
	
	public void add(EObject iObject) {
		if(collection.containsKey(iObject.eClass().getClassifierID()))
		{
			collection.get(iObject.eClass().getClassifierID()).add(iObject);
		}
		else 
		{
			collection.put(iObject.eClass().getClassifierID(), new Container(iObject));
		}
	}
	
	public EObject get(EClass mClass) {
		return collection.get(mClass.getClassifierID()).get();
	}
	
	public EObject get(EObject iObject) {
		return get(iObject.eClass());
	}
	
	public boolean contains(EClass mClass) {
		return collection.containsKey(mClass.getClassifierID());
	}
	public boolean contains(EObject iObject) {
		return contains(iObject.eClass());
	}
	
	public Iterable<EObject> iterable(EClass mClass) {
		return collection.get(mClass.getClassifierID()).iterable();		
	
	}
	
	public Iterable<EObject> all() {
		// cat all container arrays into one.
		// TODO: make a smooth, python-style iterator
		ArrayList<EObject> all = new ArrayList<EObject>();
		for(Container c: collection.values()) {
			all.addAll((java.util.Collection<? extends EObject>) c.iterable());
		}
		return all;
	}
}
