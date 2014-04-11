package uk.ac.york.cs.mv525.modelgen.strategy;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public interface Strategy {

	public EObject retrieaveObject(EClass mType);

	public EObject retrieaveUncontainedObject(EClass eType);

}