/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.Generator;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl#getModelElementOverrides <em>Model Element Overrides</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl#getTotalMinimumCount <em>Total Minimum Count</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl#getModelElemetExclusions <em>Model Elemet Exclusions</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl#isDeterministic <em>Deterministic</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl#getDefaultStringPool <em>Default String Pool</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl#getMetaModelLocation <em>Meta Model Location</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl#getOutputModelLocation <em>Output Model Location</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl#getGenerator <em>Generator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelConfigurationImpl extends EObjectImpl implements ModelConfiguration {
	/**
	 * The cached value of the '{@link #getModelElementOverrides() <em>Model Element Overrides</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementOverrides()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementOverride> modelElementOverrides;

	/**
	 * The default value of the '{@link #getTotalMinimumCount() <em>Total Minimum Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalMinimumCount()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_MINIMUM_COUNT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalMinimumCount() <em>Total Minimum Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalMinimumCount()
	 * @generated
	 * @ordered
	 */
	protected long totalMinimumCount = TOTAL_MINIMUM_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElemetExclusions() <em>Model Elemet Exclusions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElemetExclusions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementExclusion> modelElemetExclusions;

	/**
	 * The default value of the '{@link #isDeterministic() <em>Deterministic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeterministic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DETERMINISTIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeterministic() <em>Deterministic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeterministic()
	 * @generated
	 * @ordered
	 */
	protected boolean deterministic = DETERMINISTIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultStringPool() <em>Default String Pool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultStringPool()
	 * @generated
	 * @ordered
	 */
	protected StringPool defaultStringPool;

	/**
	 * The default value of the '{@link #getMetaModelLocation() <em>Meta Model Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String META_MODEL_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaModelLocation() <em>Meta Model Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelLocation()
	 * @generated
	 * @ordered
	 */
	protected String metaModelLocation = META_MODEL_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputModelLocation() <em>Output Model Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputModelLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_MODEL_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputModelLocation() <em>Output Model Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputModelLocation()
	 * @generated
	 * @ordered
	 */
	protected String outputModelLocation = OUTPUT_MODEL_LOCATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGenerator() <em>Generator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerator()
	 * @generated
	 * @ordered
	 */
	protected Generator generator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.MODEL_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementOverride> getModelElementOverrides() {
		if (modelElementOverrides == null) {
			modelElementOverrides = new EObjectContainmentEList<ModelElementOverride>(ModelElementOverride.class, this, ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES);
		}
		return modelElementOverrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalMinimumCount() {
		return totalMinimumCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalMinimumCount(long newTotalMinimumCount) {
		long oldTotalMinimumCount = totalMinimumCount;
		totalMinimumCount = newTotalMinimumCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT, oldTotalMinimumCount, totalMinimumCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementExclusion> getModelElemetExclusions() {
		if (modelElemetExclusions == null) {
			modelElemetExclusions = new EObjectContainmentEList<ModelElementExclusion>(ModelElementExclusion.class, this, ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS);
		}
		return modelElemetExclusions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeterministic() {
		return deterministic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeterministic(boolean newDeterministic) {
		boolean oldDeterministic = deterministic;
		deterministic = newDeterministic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_CONFIGURATION__DETERMINISTIC, oldDeterministic, deterministic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringPool getDefaultStringPool() {
		return defaultStringPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultStringPool(StringPool newDefaultStringPool, NotificationChain msgs) {
		StringPool oldDefaultStringPool = defaultStringPool;
		defaultStringPool = newDefaultStringPool;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL, oldDefaultStringPool, newDefaultStringPool);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultStringPool(StringPool newDefaultStringPool) {
		if (newDefaultStringPool != defaultStringPool) {
			NotificationChain msgs = null;
			if (defaultStringPool != null)
				msgs = ((InternalEObject)defaultStringPool).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL, null, msgs);
			if (newDefaultStringPool != null)
				msgs = ((InternalEObject)newDefaultStringPool).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL, null, msgs);
			msgs = basicSetDefaultStringPool(newDefaultStringPool, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL, newDefaultStringPool, newDefaultStringPool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetaModelLocation() {
		return metaModelLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModelLocation(String newMetaModelLocation) {
		String oldMetaModelLocation = metaModelLocation;
		metaModelLocation = newMetaModelLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_CONFIGURATION__META_MODEL_LOCATION, oldMetaModelLocation, metaModelLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputModelLocation() {
		return outputModelLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputModelLocation(String newOutputModelLocation) {
		String oldOutputModelLocation = outputModelLocation;
		outputModelLocation = newOutputModelLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_CONFIGURATION__OUTPUT_MODEL_LOCATION, oldOutputModelLocation, outputModelLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generator getGenerator() {
		return generator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenerator(Generator newGenerator, NotificationChain msgs) {
		Generator oldGenerator = generator;
		generator = newGenerator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_CONFIGURATION__GENERATOR, oldGenerator, newGenerator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerator(Generator newGenerator) {
		if (newGenerator != generator) {
			NotificationChain msgs = null;
			if (generator != null)
				msgs = ((InternalEObject)generator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_CONFIGURATION__GENERATOR, null, msgs);
			if (newGenerator != null)
				msgs = ((InternalEObject)newGenerator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_CONFIGURATION__GENERATOR, null, msgs);
			msgs = basicSetGenerator(newGenerator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_CONFIGURATION__GENERATOR, newGenerator, newGenerator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addModelElementOverride(ModelElementOverride modelElementOverride) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addModelElementExclusion(ModelElementExclusion modelElementExclusion) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES:
				return ((InternalEList<?>)getModelElementOverrides()).basicRemove(otherEnd, msgs);
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS:
				return ((InternalEList<?>)getModelElemetExclusions()).basicRemove(otherEnd, msgs);
			case ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL:
				return basicSetDefaultStringPool(null, msgs);
			case ConfigPackage.MODEL_CONFIGURATION__GENERATOR:
				return basicSetGenerator(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES:
				return getModelElementOverrides();
			case ConfigPackage.MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT:
				return getTotalMinimumCount();
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS:
				return getModelElemetExclusions();
			case ConfigPackage.MODEL_CONFIGURATION__DETERMINISTIC:
				return isDeterministic();
			case ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL:
				return getDefaultStringPool();
			case ConfigPackage.MODEL_CONFIGURATION__META_MODEL_LOCATION:
				return getMetaModelLocation();
			case ConfigPackage.MODEL_CONFIGURATION__OUTPUT_MODEL_LOCATION:
				return getOutputModelLocation();
			case ConfigPackage.MODEL_CONFIGURATION__GENERATOR:
				return getGenerator();
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
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES:
				getModelElementOverrides().clear();
				getModelElementOverrides().addAll((Collection<? extends ModelElementOverride>)newValue);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT:
				setTotalMinimumCount((Long)newValue);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS:
				getModelElemetExclusions().clear();
				getModelElemetExclusions().addAll((Collection<? extends ModelElementExclusion>)newValue);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__DETERMINISTIC:
				setDeterministic((Boolean)newValue);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL:
				setDefaultStringPool((StringPool)newValue);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__META_MODEL_LOCATION:
				setMetaModelLocation((String)newValue);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__OUTPUT_MODEL_LOCATION:
				setOutputModelLocation((String)newValue);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__GENERATOR:
				setGenerator((Generator)newValue);
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
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES:
				getModelElementOverrides().clear();
				return;
			case ConfigPackage.MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT:
				setTotalMinimumCount(TOTAL_MINIMUM_COUNT_EDEFAULT);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS:
				getModelElemetExclusions().clear();
				return;
			case ConfigPackage.MODEL_CONFIGURATION__DETERMINISTIC:
				setDeterministic(DETERMINISTIC_EDEFAULT);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL:
				setDefaultStringPool((StringPool)null);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__META_MODEL_LOCATION:
				setMetaModelLocation(META_MODEL_LOCATION_EDEFAULT);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__OUTPUT_MODEL_LOCATION:
				setOutputModelLocation(OUTPUT_MODEL_LOCATION_EDEFAULT);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__GENERATOR:
				setGenerator((Generator)null);
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
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES:
				return modelElementOverrides != null && !modelElementOverrides.isEmpty();
			case ConfigPackage.MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT:
				return totalMinimumCount != TOTAL_MINIMUM_COUNT_EDEFAULT;
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS:
				return modelElemetExclusions != null && !modelElemetExclusions.isEmpty();
			case ConfigPackage.MODEL_CONFIGURATION__DETERMINISTIC:
				return deterministic != DETERMINISTIC_EDEFAULT;
			case ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL:
				return defaultStringPool != null;
			case ConfigPackage.MODEL_CONFIGURATION__META_MODEL_LOCATION:
				return META_MODEL_LOCATION_EDEFAULT == null ? metaModelLocation != null : !META_MODEL_LOCATION_EDEFAULT.equals(metaModelLocation);
			case ConfigPackage.MODEL_CONFIGURATION__OUTPUT_MODEL_LOCATION:
				return OUTPUT_MODEL_LOCATION_EDEFAULT == null ? outputModelLocation != null : !OUTPUT_MODEL_LOCATION_EDEFAULT.equals(outputModelLocation);
			case ConfigPackage.MODEL_CONFIGURATION__GENERATOR:
				return generator != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (TotalMinimumCount: ");
		result.append(totalMinimumCount);
		result.append(", Deterministic: ");
		result.append(deterministic);
		result.append(", MetaModelLocation: ");
		result.append(metaModelLocation);
		result.append(", OutputModelLocation: ");
		result.append(outputModelLocation);
		result.append(')');
		return result.toString();
	}

} //ModelConfigurationImpl
