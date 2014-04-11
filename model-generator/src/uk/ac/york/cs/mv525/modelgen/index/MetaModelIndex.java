package uk.ac.york.cs.mv525.modelgen.index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class MetaModelIndex implements Index {

	HashMap<String, ArrayList<EClass>> index;	
	EPackage ePackage;
	
	public MetaModelIndex() {
		index = new HashMap<>();
	}	
	
	public void insert(String name,  EClass mClass) {
		
		ArrayList<EClass> l;
		
		if ( index.containsKey(name) ) {			
			l = index.get(name);			
		} else {
			l = new ArrayList<>();
			index.put(name, l);
		}

		if (mClass.getName().equals(name)) {
			l.add(0, mClass); // ensure superclasses are ....
		} else {
			l.add(mClass);
		}
		
	}
	
	public void add(EClass mClass) {
		insert(mClass.getName(), mClass);
		
		for(EClass mSuperClass : mClass.getESuperTypes()) {
			insert(mSuperClass.getName(), mClass);
		}
	}
	
	/*
	public void add(String name, EObject object) {
		temp_index.put(name, object);		
	}
	*/
	
	public EObject get(String name) {
		
		if (index.containsKey(name)) {
			ArrayList<EClass> l = index.get(name);
			if (l.size() > 0) {
				return l.get(0);
			}
		}
		
		return null;
	}
	
	public Collection<EClass> dump() {		
		// only top level elements
		ArrayList<EClass> o = new ArrayList<>();
		
		for(ArrayList<EClass> c : index.values()) {
			if (c.size() > 0) {
				o.add(c.get(0));
			}
		}
				
		return o;
	}

	public void setEPackage(EPackage pack) {
		ePackage = pack;
	}

	public EPackage getEPackage() {
		return ePackage;
	}

	public boolean exists(String name) {
		
		if (index.containsKey(name)) {
			return index.get(name).size() >= 0;
		}
		
		return false;
	}

	public long getCount() {
		return index.size();
	}

	public boolean exists(String mClass, String mAttr) {
		if (exists(mClass)) {
			EClass mc = (EClass) get(mClass);
			return mc.getEStructuralFeature(mAttr) != null;
		}
		return false;
	}

	public EClass getConcreteClass(EClass mClass) {
		
		for(EClass e : index.get(mClass.getName())) {
			
			if ( !e.isAbstract() && !e.isInterface()) {
				return e;
			}
			
		}
		
		return null;
	}
}
































