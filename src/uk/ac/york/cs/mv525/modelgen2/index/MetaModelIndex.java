package uk.ac.york.cs.mv525.modelgen2.index;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;

public class MetaModelIndex implements Index {

	@Override
	public void add(String name, EObject object) {
		// TODO Auto-generated method stub

	}

	@Override
	public EObject get(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public LinkedList<EObject> dump() {
		return new LinkedList<EObject>();
		
	}

}
