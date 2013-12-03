package uk.ac.york.cs.mv525.modelgen.index;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.EolOperation;

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
	private HashMap<String, EolOperation> mOperations;
	private int getCounter = 0;
	private int targetCount = -1;
	
	public Container(EClass mClass) {
		this.mClass = mClass;
		iObjects = new ArrayList<EObject>();
		mOperations = new HashMap<String, EolOperation>();
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
	
	public boolean satisfied() {
		return iObjects.size() >= targetCount;
	}
	
	public void setTarget(int i) {
		targetCount = i;
	}
	
	public int getTarget() {
		return targetCount;
	}
	
	public Iterable<EObject> iterable() {
		return iObjects;
	}
	
	public String getName() {
		
		int i = mClass.getClassifierID();
		
		EStructuralFeature s = mClass.getEStructuralFeature("name");
		
		return mClass.getName();
	}
	
	public EClass getEClass() {
		return mClass;
	}
	
	@Override
	public int hashCode() {
		return mClass.getClassifierID();
	}
	@Override
	public String toString() {
		return String.format(mClass.getName(), iObjects.size());
	}

	public void addOperation(String mOpName, EolOperation op) {
		mOperations.put(mOpName, op);		
	}
	
	
	/**
	 * Gets the Create operation for the EClass.
	 * @return Create operation or null
	 */
	public EolOperation getCreate() {
		return mOperations.get("create"); // TODO externalis string
	}
	
	/**
	 * Gets the Create operation for the EClass's EAttribute, attributeName.
	 * @param attributeName
	 * @return Create operation for attribute or null.
	 */
	public EolOperation getCreate(String attributeName) {
		return mOperations.get("create"+attributeName);
	}
}
