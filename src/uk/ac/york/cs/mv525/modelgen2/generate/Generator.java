package uk.ac.york.cs.mv525.modelgen2.generate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public interface Generator {

	public void setResourceSet(Resource resourceSet);
	// TODO: Might want to change EObject for something more specific
	public EObject generate(EObject mObject);
}
