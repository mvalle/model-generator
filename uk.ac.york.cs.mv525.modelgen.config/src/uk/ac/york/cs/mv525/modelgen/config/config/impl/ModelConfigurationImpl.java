/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import java.math.BigInteger;

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
	protected EList modelElementOverrides;

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
	protected EList modelElemetExclusions;

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
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.MODEL_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getModelElementOverrides() {
		if (modelElementOverrides == null) {
			modelElementOverrides = new EObjectContainmentEList(ModelElementOverride.class, this, ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES);
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
	public EList getModelElemetExclusions() {
		if (modelElemetExclusions == null) {
			modelElemetExclusions = new EObjectContainmentEList(ModelElementExclusion.class, this, ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS);
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES:
				return ((InternalEList)getModelElementOverrides()).basicRemove(otherEnd, msgs);
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS:
				return ((InternalEList)getModelElemetExclusions()).basicRemove(otherEnd, msgs);
			case ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL:
				return basicSetDefaultStringPool(null, msgs);
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
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES:
				return getModelElementOverrides();
			case ConfigPackage.MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT:
				return new Long(getTotalMinimumCount());
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS:
				return getModelElemetExclusions();
			case ConfigPackage.MODEL_CONFIGURATION__DETERMINISTIC:
				return isDeterministic() ? Boolean.TRUE : Boolean.FALSE;
			case ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL:
				return getDefaultStringPool();
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
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES:
				getModelElementOverrides().clear();
				getModelElementOverrides().addAll((Collection)newValue);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT:
				setTotalMinimumCount(((Long)newValue).longValue());
				return;
			case ConfigPackage.MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS:
				getModelElemetExclusions().clear();
				getModelElemetExclusions().addAll((Collection)newValue);
				return;
			case ConfigPackage.MODEL_CONFIGURATION__DETERMINISTIC:
				setDeterministic(((Boolean)newValue).booleanValue());
				return;
			case ConfigPackage.MODEL_CONFIGURATION__DEFAULT_STRING_POOL:
				setDefaultStringPool((StringPool)newValue);
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
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (TotalMinimumCount: ");
		result.append(totalMinimumCount);
		result.append(", Deterministic: ");
		result.append(deterministic);
		result.append(')');
		return result.toString();
	}

} //ModelConfigurationImpl
