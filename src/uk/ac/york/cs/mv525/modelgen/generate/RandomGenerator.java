package uk.ac.york.cs.mv525.modelgen.generate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;

public class RandomGenerator implements Generator {

	EFactory iClassGenerator;
	ModelInstance model;
	Configuration config;
	
	public RandomGenerator(ModelInstance modelInstance, MetaModelIndex metaModel) {
		iClassGenerator = metaModel.getEPackage().getEFactoryInstance();		
		model = modelInstance;
	}
	
	public RandomGenerator(ModelInstance modelInstance, MetaModelIndex metaModel, Configuration config) {
		iClassGenerator = metaModel.getEPackage().getEFactoryInstance();		
		model = modelInstance;
		this.config = config;
	}
	
	@Override
	public void setResourceSet(Resource resourceSet) {
		// TODO Auto-generated method stub

	}

	public EObject create(EClass mClass) {

		EObject iObject = iClassGenerator.create(mClass);
		model.add(iObject);
		return iObject;
	}
	

	public Object add(EObject iObject, EStructuralFeature mAttribute) {
		
		if (!iObject.eIsSet(mAttribute)) {
			
			if (mAttribute.getEType().getName() == "EString") {
				//iObject.eSet(mAttribute, createEString());
				iObject.eSet(mAttribute, getString(mAttribute));
				
				// TODO : Generate more EDataTypes
				
			} else {
				// print("Unknown EDataType");
			}
		}
		
		
		return iObject.eGet(mAttribute);
	}
	
	private String getString(EStructuralFeature mAttribute) {
		if (config != null) {
			String c = config.getString(mAttribute.getName());
			if (c != null) {
				return c;
			}
		}
		return "";
	}

	public Object link(EObject iObjectContainer, EReference mReference) {
		/* +------------------+     +---------------------+---------+
		 * | iObjectContainer |---->| iReferenceContainer | iObject |
		 * +------------------+     +---------------------+---------+
		 */
		@SuppressWarnings("unchecked")
		EList<EObject> iReferenceContainer = (EList<EObject>) iObjectContainer
				.eGet(mReference);
			
		EObject iObject = retrieveObject((EClass)mReference.getEType());
		
		iReferenceContainer.add(iObject);
			
		return iObjectContainer.eGet(mReference);
	}

	/* TODO : Consider moving into superclass */
	private EObject retrieveObject(EClass mType) {
		// TODO Based on strategy, either create or retrieve object
		return  create(mType);
	}
}
