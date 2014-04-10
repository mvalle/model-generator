package uk.ac.york.cs.mv525.modelgen.generate;

import java.util.Random;

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

public class RandomGenerator extends Generator {

	EFactory iClassGenerator;
	ModelInstance model;
	Configuration config;
	Strategy strategy;
	MetaModelIndex mIndex;

	Random rand = new Random(0);

	public RandomGenerator(ModelInstance modelInstance, MetaModelIndex metaModel) {
		iClassGenerator = metaModel.getEPackage().getEFactoryInstance();
		model = modelInstance;
		mIndex = metaModel;
	}

	public RandomGenerator(ModelInstance modelInstance,
			MetaModelIndex metaModel, Configuration config) {
		iClassGenerator = metaModel.getEPackage().getEFactoryInstance();
		model = modelInstance;
		this.config = config;
		mIndex = metaModel;
	}

	@Override
	public void setStrategy(Strategy s) {
		strategy = s;
	}

	public EObject create(EClass mClass) {

		if (mClass.isAbstract() || mClass.isInterface()) {
			EClass concreteClass = mIndex.getConcreteClass(mClass);

			EObject iObject = iClassGenerator.create(concreteClass);
			model.add(iObject);

			return iObject;		
		} else {
		
			EObject iObject = iClassGenerator.create(mClass);
			model.add(iObject);

			return iObject;			
		}
	}

	public Object add(EObject iObject, EStructuralFeature mAttribute) {

		if (!iObject.eIsSet(mAttribute)) {

			if (mAttribute.getEType().getName() == "EString") {
				// iObject.eSet(mAttribute, createEString());
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

	// requires iObjectContainter.eGet(mReference) == null;
	public Object link(EObject iObjectContainer, EReference mReference) {
		/*
		 * +------------------+ +---------------------+---------+ |
		 * iObjectContainer |---->| iReferenceContainer | iObject |
		 * +------------------+ +---------------------+---------+
		 */

		long lower = mReference.getLowerBound();
		long upper = mReference.getUpperBound();
		// * == -1 // TODO
		if (upper == -1) {
			upper = config.getMinimumCount();
		}

		if (lower == upper && upper == 1) {
			// if multiplicity of 1, do one
			linkOne(iObjectContainer, mReference);

		} else {

			@SuppressWarnings("unchecked")
			EList<EObject> iReferenceContainer = (EList<EObject>) iObjectContainer
					.eGet(mReference);
			if (upper < iReferenceContainer.size()) {

				// Add minimum references
				while (lower > iReferenceContainer.size()
						&& upper < iReferenceContainer.size()) {
					link(iReferenceContainer, mReference);
				}

				long configMin = config.getMinimumReferences(mReference);
				while (configMin > iReferenceContainer.size()
						&& upper < iReferenceContainer.size()) {
					link(iReferenceContainer, mReference);
				}

				int c = (int) (upper * rand.nextGaussian());
				while (c-- > 0) {
					link(iReferenceContainer, mReference);
				}
			}
		}
		
		return iObjectContainer.eGet(mReference);
	}

	private void linkOne(EObject iObjectContainer, EReference mReference) {
		EObject iObject = strategy.retrieaveObject((EClass) mReference
				.getEType());

		iObjectContainer.eSet(mReference, iObject);
		
	}

	private void link(EList<EObject> iReferenceContainer, EReference mReference) {

		EObject iObject = strategy.retrieaveObject((EClass) mReference
				.getEType());

		iReferenceContainer.add(iObject);
	}

	@Override
	public boolean before() {
		return false;
	}

	@Override
	public boolean after() {
		return false;
	}
}
