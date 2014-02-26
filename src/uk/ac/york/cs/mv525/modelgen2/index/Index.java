package uk.ac.york.cs.mv525.modelgen2.index;

import org.eclipse.emf.ecore.EObject;

public interface Index {

	public void add(String name, EObject object);
	public EObject get(String name);
}
