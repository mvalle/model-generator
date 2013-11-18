package uk.ac.york.cs.mv525.modelgen.create;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.mv525.modelgen.ResourceOperator;
import uk.ac.york.cs.mv525.modelgen.index.Collection;

public class ModelInstance extends ResourceOperator {

	private Collection iIndex;
	private Collection mIndex;
	
	private EPackage metamodel;

	private Resource resource;
	private EList<EObject> instance;

	
	public ModelInstance(Collection mCollection) throws Exception{
		mIndex = mCollection;
		iIndex = new Collection();
		
		metamodel = (EPackage) mIndex.get(metamodel.eClass());
		
		resource = getResourceSet("model").createResource(
				URI.createFileURI(getModelDir("testmodel.model")));
		
		instance = resource.getContents();
	}
	
	public void add(EObject iObject) {

		if (mIndex.contains(iObject.eClass())) {
		
			iIndex.add(iObject);
			instance.add(iObject);

		}
	}
	
	
}
