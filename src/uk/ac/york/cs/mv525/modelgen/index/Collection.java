package uk.ac.york.cs.mv525.modelgen.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.EolOperation;

/**
 * @author magnus
 *
 * Class that contains EObjects and retrieves them by EClass.
 */
public class Collection {

//	private HashMap<EClass, Container> collection;
//	private HashMap<Integer, Container> collection;
	private HashMap<String, Container> collection;
	
	public Collection() {
//		collection = new HashMap<EClass, Container>();
//		collection = new HashMap<Integer, Container>();
		collection = new HashMap<String, Container>();
	}
	
	public void add(EObject iObject) {
		if(collection.containsKey(iObject.eClass().getName()))
		{
			collection.get(iObject.eClass().getName()).add(iObject);
		}
		else 
		{
			collection.put(iObject.eClass().getName(), new Container(iObject));
		}
	}
	
	public EObject get(EClass mClass) {
		return collection.get(mClass.getName()).get();
	}
	
	public EObject get(EObject iObject) {
		return get(iObject.eClass());
	}
	
	public boolean contains(EClass mClass) {
		return collection.containsKey(mClass.getName());
	}
	public boolean contains(EObject iObject) {
		return contains(iObject.eClass());
	}
	
	public Iterable<EObject> iterable(EClass mClass) {
		return collection.get(mClass.getName()).iterable();		
	
	}
	
	public Iterable<Container> containers() {
		return collection.values();
	}
	
	public void createIndex(EClass mClass) {
		if(!collection.containsKey(mClass.getName()))
		{		
			collection.put(mClass.getName(), new Container(mClass));
		}
	}
	
	public EolOperation getCreateOperation(EClass mClass) {
		if(collection.containsKey(mClass.getName()))
		{		
			return collection.get(mClass.getName()).getCreate();
		}
		return null;
	}

	public EolOperation getOperation(EClass mClass,
			EStructuralFeature mAttribute) {
		
		if(collection.containsKey(mClass.getName()))
		{		
			return collection.get(mClass.getName()).getCreate(mAttribute);
		}
		
		return null;
	}
	/*
	public Iterable<EObject> all() {
		// cat all container arrays into one.
		// TODO: make a smooth, python-style iterator
		ArrayList<EObject> all = new ArrayList<EObject>();
		for(Container c: collection.values()) {
			all.addAll((java.util.Collection<? extends EObject>) c.iterable());
		}
		return all;
	}
*/
	public void addOperation(String mTypeName, String mOpName, EolOperation op) {
		
		Container container = getByName(mTypeName);
		if (container == null) { return; }
		
		container.addOperation(mOpName, op);
		
	}
	
	// TODO: Figure out if it's safe to index by name
	private Container getByName(String mTypeName) {
		
		for(Container c: collection.values()) {
			System.out.println(c.getName() + "="+mTypeName);
			if(c.getName().equals(mTypeName)) {
				return c;
			}
		}
		
		return collection.get(mTypeName);
		//return null;
	}
	
	// ?
	public Iterable<EObject> getAll(String name) {
		ArrayList<EObject> l = new ArrayList<EObject>();
		
		for(Container c: collection.values()) {
			if(c.getName() == name) {
				l.add(c.getEClass());
			}
		}
		
		return l;
	}

}












