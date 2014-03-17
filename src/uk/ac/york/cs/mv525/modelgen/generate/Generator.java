package uk.ac.york.cs.mv525.modelgen2.generate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public interface Generator {

	public void setResourceSet(Resource resourceSet);

	public EObject create(EClass mClass);	

	public Object add(EObject iObject, EStructuralFeature mAttribute);
	
	public Object link(EObject iObjectContainer, EReference mReference);

}
