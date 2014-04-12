package uk.ac.york.cs.mv525.modelgen.generate;

import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
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

	public Object add(EObject iObject, EAttribute mAttribute) {

		if (!iObject.eIsSet(mAttribute)) {
			
			switch (mAttribute.getEType().getName()) {
			case "EString":			
				iObject.eSet(mAttribute, getString(mAttribute));
				break;
			case "Long":
			case "ELong":
				iObject.eSet(mAttribute, getLong());
				break;
			default:
				// TODO : Generate more EDataTypes				
				System.out.println("Unknown EDataType " + mAttribute.getEType().getName());				
				System.out.println(mAttribute.getName());
			}
			
		}

		return iObject.eGet(mAttribute);
	}

	private Object getLong() {
		return rand.nextLong();
	}

	private String getString(EStructuralFeature mAttribute) {
		if (config != null) {
			String c = config.getString(mAttribute);
			if (c != null) {
				return c;
			}
		}
		
		return generateRandomString(2+(int)(rand.nextGaussian()*8));
	}

	private String generateRandomString(int i) {
		System.out.println("Generate string");
		System.out.println("  target: "+i);
		String s = "";
		while(i-- > 0) {
			char c = (char)(rand.nextInt(126-32) + 32);
			if (c<32 || c>126) {
				System.out.println("  ! oversised char: "+c);
			}
			s = s+c;
		}
		System.out.println("  actual: "+s.length());
		return s;
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

		if (upper == 1) {
			// if multiplicity of 1, do one
			linkOne(iObjectContainer, mReference);

		} else {

			@SuppressWarnings("unchecked")
			EList<EObject> iReferenceContainer = (EList<EObject>) iObjectContainer
					.eGet(mReference);
			
			if (upper > iReferenceContainer.size()) {

				// Add minimum references
				while (lower > iReferenceContainer.size()
						&& upper < iReferenceContainer.size()) {
					link(iReferenceContainer, mReference);
				}

				// Add config defined references
				long configMin = config.getMinimumReferences(mReference);
				while (configMin > iReferenceContainer.size()
						&& upper < iReferenceContainer.size()) {
					link(iReferenceContainer, mReference);
				}
				
				// Add random references
				int c = (int) (upper * rand.nextGaussian());
				while (c-- > 0) {
					link(iReferenceContainer, mReference);
				}
			}
			/* Having filled the EList, you might consider doing this next
			 *   iObjectContainer.eSet(mReference, iReferenceContainer); 
			 * but would clear the list, obviously.
			 */
		}
		
		return iObjectContainer.eGet(mReference);
	}

	private void linkOne(EObject iObjectContainer, EReference mReference) {
		EObject iObject = strategy.retrieaveObject((EClass) mReference
				.getEType());

		iObjectContainer.eSet(mReference, iObject);
		
	}

	private void link(EList<EObject> iReferenceContainer, EReference mReference) {		
		if (mReference.isContainment()) {		
			EObject iObject = strategy.retrieaveUncontainedObject((EClass) mReference
				.getEType());	
			iReferenceContainer.add(iObject);		
		} else {
			EObject iObject = strategy.retrieaveObject((EClass) mReference
				.getEType());			
			iReferenceContainer.add(iObject);			
		}		
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
