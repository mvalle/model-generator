package uk.ac.york.cs.mv525.modelgen.producer;

import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;

public class RandomProducer extends Producer {

	EFactory iClassFactory;
	ModelInstance model;
	Configuration config;
	Strategy strategy;
	MetaModelIndex mIndex;

	Random rand = new Random(0);

	public RandomProducer(ModelInstance modelInstance,
			MetaModelIndex metaModel, Configuration config) {
		iClassFactory = metaModel.getEPackage().getEFactoryInstance();
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

			EObject iObject = iClassFactory.create(concreteClass);
			model.add(iObject);

			return iObject;		
		} else {
		
			EObject iObject = iClassFactory.create(mClass);
			model.add(iObject);

			return iObject;			
		}
	}

	public Object add(EObject iObject, EAttribute mAttribute) {

		if (!iObject.eIsSet(mAttribute) && mAttribute.isChangeable()) {
			
			
			switch (mAttribute.getEType().getName()) {
			case "EString":			
				iObject.eSet(mAttribute, getString(mAttribute));
				break;
			case "Long":
			case "ELong":
				iObject.eSet(mAttribute, getLong());
				break;
			case "EInt":
				iObject.eSet(mAttribute,  getInt());
				break;
			case "EBoolean":
				iObject.eSet(mAttribute, getBoolean());
				break;
			default:
				// TODO : Produce more EDataTypes				
				System.out.print("Unknown EDataType " + mAttribute.getEType().getName());				
				System.out.println(mAttribute.getName());
			}
			
		}

		return iObject.eGet(mAttribute);
	}

	private Boolean getBoolean() {
		return rand.nextBoolean();
	}

	private Integer getInt() {
		return rand.nextInt();
	}

	private Long getLong() {
		return rand.nextLong();
	}

	private String getString(EStructuralFeature mAttribute) {
		if (config != null) {
			String c = config.getString(mAttribute);
			if (c != null) {
				return c;
			}
		}
		
		return produceRandomString(2+(int)(getDouble()*8));
	}

	private Double getDouble() {
		double original = rand.nextGaussian();
		double scaled = original * 0.5;
		Double shifted = scaled + 0.5;
		return shifted;		
	}
	
	private String produceRandomString(int i) {
		//System.out.println("Generate string");
		//System.out.println("  target: "+i);
		String s = "";
		while(i-- > 0) {
			char c = (char)(rand.nextInt(126-32) + 32);
			if (c<32 || c>126) {
				//System.out.println("  ! oversised char: "+c);
			}
			s = s+c;
		}
		//System.out.println("  actual: "+s.length());
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
		if (upper == -1) {
			upper = Long.MAX_VALUE;
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
					
					//System.out.println("l "+lower);
					
					link(iReferenceContainer, mReference);
				}

				// Add config defined references
				long configMin = config.getMinimumReferences(mReference);
				while (configMin > iReferenceContainer.size()
						&& upper < iReferenceContainer.size()) {
					
					//System.out.println("c "+configMin);
					
					link(iReferenceContainer, mReference);
				}
				
				// Add random references
				long max = config.getMaximumReferences(mReference);
				if (max == -1) { 
					max = config.getMinimumCount((EClass)mReference.getEType());
				}
				
				
				int c = (int) (max * getDouble());
				while (c-- > 0 && iReferenceContainer.size() <= upper) {
					
					//System.out.println("m "+c);
					
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
			// It's possible the no uncontained objects are retrieved
			if(iObject != null) {
				iReferenceContainer.add(iObject);
			}
		} else {
			EObject iObject = strategy.retrieaveObject((EClass) mReference
				.getEType());
			// It's possible no objects are retrieved
			if (iObject != null) {
				iReferenceContainer.add(iObject);
			}
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
