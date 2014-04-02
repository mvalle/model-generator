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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.Generator;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration;
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
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelGenerationImpl#getDefaultStrategy <em>Default Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelGenerationImpl extends EObjectImpl implements ModelGeneration {
	/**
	 * The cached value of the '{@link #getFallback() <em>Fallback</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFallback()
	 * @generated
	 * @ordered
	 */
	protected Generator fallback;

	/**
	 * The cached value of the '{@link #getGenerators() <em>Generators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerators()
	 * @generated
	 * @ordered
	 */
	protected EList<Generator> generators;

	/**
	 * The cached value of the '{@link #getDefaultStrategy() <em>Default Strategy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultStrategy()
	 * @generated
	 * @ordered
	 */
	protected Strategy defaultStrategy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelGenerationImpl() {
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
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.MODEL_GENERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generator getFallback() {
		if (fallback != null && fallback.eIsProxy()) {
			InternalEObject oldFallback = (InternalEObject)fallback;
			fallback = (Generator)eResolveProxy(oldFallback);
			if (fallback != oldFallback) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.MODEL_GENERATION__FALLBACK, oldFallback, fallback));
			}
		}
		return fallback;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generator basicGetFallback() {
		return fallback;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFallback(Generator newFallback) {
		Generator oldFallback = fallback;
		fallback = newFallback;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_GENERATION__FALLBACK, oldFallback, fallback));
	
		// TODO : Check overrides
		if (fallback.getStrategy() == null) {
			fallback.setStrategy(getDefaultStrategy());
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Generator> getGenerators() {
		if (generators == null) {
			generators = new EObjectResolvingEList<Generator>(Generator.class, this, ConfigPackage.MODEL_GENERATION__GENERATORS);
		}
		return generators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy getDefaultStrategy() {
		if (defaultStrategy != null && defaultStrategy.eIsProxy()) {
			InternalEObject oldDefaultStrategy = (InternalEObject)defaultStrategy;
			defaultStrategy = (Strategy)eResolveProxy(oldDefaultStrategy);
			if (defaultStrategy != oldDefaultStrategy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.MODEL_GENERATION__DEFAULT_STRATEGY, oldDefaultStrategy, defaultStrategy));
			}
		}
		return defaultStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy basicGetDefaultStrategy() {
		return defaultStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultStrategy(Strategy newDefaultStrategy) {
		Strategy oldDefaultStrategy = defaultStrategy;
		defaultStrategy = newDefaultStrategy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_GENERATION__DEFAULT_STRATEGY, oldDefaultStrategy, defaultStrategy));
	}

	public void addGenerator(Generator gen) {
		if(gen.getStrategy() == null) {
			gen.setStrategy(defaultStrategy);
		}
		
		getGenerators().add(gen);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.MODEL_GENERATION__FALLBACK:
				if (resolve) return getFallback();
				return basicGetFallback();
			case ConfigPackage.MODEL_GENERATION__GENERATORS:
				return getGenerators();
			case ConfigPackage.MODEL_GENERATION__DEFAULT_STRATEGY:
				if (resolve) return getDefaultStrategy();
				return basicGetDefaultStrategy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.MODEL_GENERATION__FALLBACK:
				setFallback((Generator)newValue);
				return;
			case ConfigPackage.MODEL_GENERATION__GENERATORS:
				getGenerators().clear();
				getGenerators().addAll((Collection<? extends Generator>)newValue);
				return;
			case ConfigPackage.MODEL_GENERATION__DEFAULT_STRATEGY:
				setDefaultStrategy((Strategy)newValue);
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
			case ConfigPackage.MODEL_GENERATION__FALLBACK:
				setFallback((Generator)null);
				return;
			case ConfigPackage.MODEL_GENERATION__GENERATORS:
				getGenerators().clear();
				return;
			case ConfigPackage.MODEL_GENERATION__DEFAULT_STRATEGY:
				setDefaultStrategy((Strategy)null);
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
			case ConfigPackage.MODEL_GENERATION__FALLBACK:
				return fallback != null;
			case ConfigPackage.MODEL_GENERATION__GENERATORS:
				return generators != null && !generators.isEmpty();
			case ConfigPackage.MODEL_GENERATION__DEFAULT_STRATEGY:
				return defaultStrategy != null;
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
		System.out.println(fallback);
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
