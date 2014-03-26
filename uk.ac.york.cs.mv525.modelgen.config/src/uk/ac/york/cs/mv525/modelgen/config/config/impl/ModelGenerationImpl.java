/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.Generator;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration;
import uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen.config.config.Strategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Generation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelGenerationImpl#getFallback <em>Fallback</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelGenerationImpl#getGenerators <em>Generators</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelGenerationImpl#getStrategy <em>Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelGenerationImpl extends EObjectImpl implements ModelGeneration {
	/**
	 * The cached value of the '{@link #getFallback() <em>Fallback</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFallback()
	 * @generated
	 * @ordered
	 */
	protected Generator fallback;

	/**
	 * The cached value of the '{@link #getGenerators() <em>Generators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerators()
	 * @generated
	 * @ordered
	 */
	protected EList generators;

	/**
	 * The cached value of the '{@link #getStrategy() <em>Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategy()
	 * @generated
	 * @ordered
	 */
	protected Strategy strategy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelGenerationImpl() {
		super();
	}

	public ModelGenerationImpl(Generator gen) {
		super();
		setFallback(gen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.MODEL_GENERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generator getFallback() {
		return fallback;
	}

	/**Generator
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFallback(Generator newFallback, NotificationChain msgs) {
		Generator oldFallback = fallback;
		fallback = newFallback;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_GENERATION__FALLBACK, oldFallback, newFallback);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFallback(Generator newFallback) {
		if (newFallback != fallback) {
			NotificationChain msgs = null;
			if (fallback != null)
				msgs = ((InternalEObject)fallback).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_GENERATION__FALLBACK, null, msgs);
			if (newFallback != null)
				msgs = ((InternalEObject)newFallback).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_GENERATION__FALLBACK, null, msgs);
			msgs = basicSetFallback(newFallback, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_GENERATION__FALLBACK, newFallback, newFallback));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGenerators() {
		if (generators == null) {
			generators = new EObjectContainmentEList(Generator.class, this, ConfigPackage.MODEL_GENERATION__GENERATORS);
		}
		return generators;
	}

	public void addGenerator(Generator gen) {		
		getGenerators().add(gen);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStrategy(Strategy newStrategy, NotificationChain msgs) {
		Strategy oldStrategy = strategy;
		strategy = newStrategy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_GENERATION__STRATEGY, oldStrategy, newStrategy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrategy(Strategy newStrategy) {
		if (newStrategy != strategy) {
			NotificationChain msgs = null;
			if (strategy != null)
				msgs = ((InternalEObject)strategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_GENERATION__STRATEGY, null, msgs);
			if (newStrategy != null)
				msgs = ((InternalEObject)newStrategy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_GENERATION__STRATEGY, null, msgs);
			msgs = basicSetStrategy(newStrategy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_GENERATION__STRATEGY, newStrategy, newStrategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.MODEL_GENERATION__FALLBACK:
				return basicSetFallback(null, msgs);
			case ConfigPackage.MODEL_GENERATION__GENERATORS:
				return ((InternalEList)getGenerators()).basicRemove(otherEnd, msgs);
			case ConfigPackage.MODEL_GENERATION__STRATEGY:
				return basicSetStrategy(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.MODEL_GENERATION__FALLBACK:
				return getFallback();
			case ConfigPackage.MODEL_GENERATION__GENERATORS:
				return getGenerators();
			case ConfigPackage.MODEL_GENERATION__STRATEGY:
				return getStrategy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.MODEL_GENERATION__FALLBACK:
				setFallback((Generator)newValue);
				return;
			case ConfigPackage.MODEL_GENERATION__GENERATORS:
				getGenerators().clear();
				getGenerators().addAll((Collection)newValue);
				return;
			case ConfigPackage.MODEL_GENERATION__STRATEGY:
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigPackage.MODEL_GENERATION__FALLBACK:
				setFallback((Generator)null);
				return;
			case ConfigPackage.MODEL_GENERATION__GENERATORS:
				getGenerators().clear();
				return;
			case ConfigPackage.MODEL_GENERATION__STRATEGY:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigPackage.MODEL_GENERATION__FALLBACK:
				return fallback != null;
			case ConfigPackage.MODEL_GENERATION__GENERATORS:
				return generators != null && !generators.isEmpty();
			case ConfigPackage.MODEL_GENERATION__STRATEGY:
				return strategy != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean before() {
		for(Object _generator : getGenerators()) {
			Generator generator = (Generator)_generator;					
			if (generator.before()) {
				return true;
			}
		}	
		return fallback.before();		
		
	}

	@Override
	public EObject create(EClass mClass) {
		EObject iObject = null;
		for(Object _generator : getGenerators()) {
			Generator generator = (Generator)_generator;
			iObject = generator.create(mClass);
			if (iObject != null)
			{
				return iObject;
			}
		}
	
	
		return fallback.create(mClass);
	}

	@Override
	public Object add(EObject iObject, EStructuralFeature feature) {
		for(Object _generator : getGenerators()) {
			Generator generator = (Generator)_generator;
			Object o = generator.add(iObject, feature);
			
			if (o != null) {
				return o;
			}
		}
		
		return fallback.add(iObject,  feature);		
	}

	@Override
	public Object link(EObject iObject, EReference feature) {
		for(Object _generator : getGenerators()) {
			Generator generator = (Generator)_generator;
			Object o = generator.link(iObject, feature);
			
			if (o != null) {
				return o;
			}
		}
		
		return fallback.link(iObject,  feature);
		
	}

	@Override
	public boolean after() {
		for(Object _generator : getGenerators()) {
			Generator generator = (Generator)_generator;
			if (generator.after()) {
				return true;
			}
		}		
		return fallback.after();	
		
	}

} //ModelGenerationImpl
