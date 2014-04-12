package uk.ac.york.cs.mv525.modelgen.generate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;

public abstract class Generator {

	public abstract EObject create(EClass mClass);	

	public abstract Object add(EObject iObject, EAttribute mAttribute);
	
	public abstract Object link(EObject iObjectContainer, EReference mReference);

	public abstract boolean before();
	
	public abstract boolean after();
	
	public abstract void setStrategy(Strategy s);

}
