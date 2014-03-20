package uk.ac.york.cs.mv525.modelgen.generate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;

public interface Generator {

	public EObject create(EClass mClass);	

	public Object add(EObject iObject, EStructuralFeature mAttribute);
	
	public Object link(EObject iObjectContainer, EReference mReference);

	public void setStrategy(Strategy s);
}
