package uk.ac.york.cs.mv525.modelgen.create;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.mv525.modelgen.ResourceOperator;
import uk.ac.york.cs.mv525.modelgen.index.Collection;

public class ModelInstance extends ResourceOperator {

	private Collection iIndex; // Index of the model elements
	private Collection mIndex; // Index of the meta-model elements
	
	private Resource resource;
	private EList<EObject> instance;

	
	public ModelInstance(Collection mCollection) throws Exception{
		mIndex = mCollection;
		iIndex = new Collection();
		
		resource = getResourceSet("model").createResource(
				URI.createFileURI(getModelDir("testmodel.model")));
		
		instance = resource.getContents();
	}
	
	public void add(EObject iObject) {
		iIndex.add(iObject);
		instance.add(iObject);
	}
	
	public EObject get(EClass mClass) {
		if(mIndex.contains(mClass.eClass())) {
			return iIndex.get(mClass);
		}
		// throw not in excepion
		return null;
	}
	
	public EObject get(EObject iObject) {
		return get(iObject.eClass());
	}
	
	public Iterable<EObject> iterable(EClass mClass) {
		return iIndex.iterable(mClass);
	}
	
	public Iterable<EObject> iterable(EObject iObject) {
		return iterable(iObject.eClass());
	}

	public Iterable<EObject> mAll() {
		return mIndex.all();
	}
}
