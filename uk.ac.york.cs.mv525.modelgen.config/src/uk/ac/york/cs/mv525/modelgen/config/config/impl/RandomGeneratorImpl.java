/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.config.config.Strategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.RandomGeneratorImpl#getStrategy <em>Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomGeneratorImpl extends EObjectImpl implements RandomGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomGeneratorImpl() {
		super();
	}

	EFactory iClassGenerator;
	ModelInstance model;
	Configuration config;
	Strategy strategy;
	

	public RandomGeneratorImpl(ModelInstance modelInstance, MetaModelIndex metaModel) {
		super();
		iClassGenerator = metaModel.getEPackage().getEFactoryInstance();
		model = modelInstance;
	}
	
	public RandomGeneratorImpl(ModelInstance modelInstance, MetaModelIndex metaModel, Configuration config) {
		super();
		iClassGenerator = metaModel.getEPackage().getEFactoryInstance();
		model = modelInstance;
		this.config = config;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.RANDOM_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject create(EClass mClass) {

		EObject iObject = iClassGenerator.create(mClass);
		model.add(iObject);
		return iObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object link(EObject iObjectContainer, EReference mReference) {
		/* +------------------+     +---------------------+---------+
		 * | iObjectContainer |---->| iReferenceContainer | iObject |
		 * +------------------+     +---------------------+---------+
		 */
		@SuppressWarnings("unchecked")
		EList<EObject> iReferenceContainer = (EList<EObject>) iObjectContainer
				.eGet(mReference);
			
		EObject iObject = getStrategy().retrieveObject((EClass)mReference.getEType());
		
		iReferenceContainer.add(iObject);
			
		return iObjectContainer.eGet(mReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean before() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean after() {
		return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.RANDOM_GENERATOR__STRATEGY:
				if (resolve) return getStrategy();
				return basicGetStrategy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.RANDOM_GENERATOR__STRATEGY:
				setStrategy((Strategy)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigPackage.RANDOM_GENERATOR__STRATEGY:
				setStrategy((Strategy)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigPackage.RANDOM_GENERATOR__STRATEGY:
				return strategy != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Strategy getStrategy() {
		return strategy;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy basicGetStrategy() {
		return strategy;
	}

	@Override
	public void setStrategy(Strategy value) {
		this.strategy = value;		
	}

} //RandomGeneratorImpl
