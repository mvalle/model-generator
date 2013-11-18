package uk.ac.york.cs.mv525.modelgen.index;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;


/**
 * @author magnus
 *
 * Class that contains EObjects and retrieves them by EClass.
 */
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
		return get(iObject.eClass());
	}
	
	public boolean contains(EClass mClass) {
		return collection.containsKey(mClass);
	}
	public boolean contains(EObject iObject) {
		return contains(iObject.eClass());
	}
}
