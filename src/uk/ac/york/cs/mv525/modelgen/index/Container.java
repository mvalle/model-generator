package uk.ac.york.cs.mv525.modelgen.index;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @author magnus
 *
 * A class that contains all the eObjects of a particular EClass.
 * Allows indexing and efficient retrieval.
 * 
 * TODO: Query for objects with or without specific properties
 * TODO?: Store fully implemented objects in different list.
 */
public class Container {


	private EClass mClass;
	private ArrayList<EObject> iObjects;
	private int getCounter = 0;
	
	public Container(EClass mClass) {
		this.mClass = mClass;
		iObjects = new ArrayList<EObject>();
	}
	
	public Container(EObject iObject) {
		this.mClass = iObject.eClass();
		iObjects = new ArrayList<EObject>();
		iObjects.add(iObject);
	}
	
	public void add(EObject object) {
		if (object.eClass().getClassifierID() == mClass.getClassifierID()) {
			iObjects.add(object);
		}
		// throw invalid input exception
	}
	
	/**
	 * Gets an object from the container. Cycles through
	 * the objects, so it can always get one.
	 * @return
	 */
	public EObject get() {
		return get(getCounter);
	}
	/**
	 * Get's the i-th item in the container.
	 * If i is greater than the size of the container, then 
	 * it gets rolls to the beginning.
	 * @param i
	 * @return eObject
	 */
	public EObject get(int i) {
		if (iObjects.isEmpty()) {
			// throw list is empty exception
		}
		int len = iObjects.size();
		
		return iObjects.get(i % len);
	
	}
	
	
	public Iterable<EObject> iterable() {
		return iObjects;
	}
	
	@Override
	public int hashCode() {
		return mClass.getClassifierID();
	}
	@Override
	public String toString() {
		return "<%s: %d>".format(mClass.getName(), iObjects.size());
	}
}
