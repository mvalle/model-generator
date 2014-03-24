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
import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;

public class RandomGenerator implements Generator {

	EFactory iClassGenerator;
	ModelInstance model;
	Configuration config;
Strategy strategy;
	
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
	public void setStrategy(Strategy s) {
		strategy = s;
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
			String c = config.getString(mAttribute);
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
			
		EObject iObject = strategy.retrieaveObject((EClass)mReference.getEType());
		
		iReferenceContainer.add(iObject);
			
		return iObjectContainer.eGet(mReference);
	}
}
