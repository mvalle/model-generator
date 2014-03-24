/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import java.util.Collection;
import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Override</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementOverrideImpl#getMinimumCount <em>Minimum Count</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementOverrideImpl#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementOverrideImpl#getStringPools <em>String Pools</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementOverrideImpl#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementOverrideImpl extends EObjectImpl implements ModelElementOverride {
	/**
	 * The default value of the '{@link #getMinimumCount() <em>Minimum Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumCount()
	 * @generated
	 * @ordered
	 */
	protected static final long MINIMUM_COUNT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMinimumCount() <em>Minimum Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumCount()
	 * @generated
	 * @ordered
	 */
	protected long minimumCount = MINIMUM_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStringPools() <em>String Pools</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringPools()
	 * @generated
	 * @ordered
	 */
	protected StringPool stringPools;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList references;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementOverrideImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.MODEL_ELEMENT_OVERRIDE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMinimumCount() {
		return minimumCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumCount(long newMinimumCount) {
		long oldMinimumCount = minimumCount;
		minimumCount = newMinimumCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT, oldMinimumCount, minimumCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_ELEMENT_OVERRIDE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringPool getStringPools() {
		return stringPools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStringPools(StringPool newStringPools, NotificationChain msgs) {
		StringPool oldStringPools = stringPools;
		stringPools = newStringPools;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS, oldStringPools, newStringPools);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringPools(StringPool newStringPools) {
		if (newStringPools != stringPools) {
			NotificationChain msgs = null;
			if (stringPools != null)
				msgs = ((InternalEObject)stringPools).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS, null, msgs);
			if (newStringPools != null)
				msgs = ((InternalEObject)newStringPools).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS, null, msgs);
			msgs = basicSetStringPools(newStringPools, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS, newStringPools, newStringPools));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList(ReferenceOverride.class, this, ConfigPackage.MODEL_ELEMENT_OVERRIDE__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS:
				return basicSetStringPools(null, msgs);
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__REFERENCES:
				return ((InternalEList)getReferences()).basicRemove(otherEnd, msgs);
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
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT:
				return new Long(getMinimumCount());
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__NAME:
				return getName();
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS:
				return getStringPools();
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__REFERENCES:
				return getReferences();
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
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT:
				setMinimumCount(((Long)newValue).longValue());
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__NAME:
				setName((String)newValue);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS:
				setStringPools((StringPool)newValue);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection)newValue);
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
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT:
				setMinimumCount(MINIMUM_COUNT_EDEFAULT);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS:
				setStringPools((StringPool)null);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__REFERENCES:
				getReferences().clear();
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
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT:
				return minimumCount != MINIMUM_COUNT_EDEFAULT;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS:
				return stringPools != null;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__REFERENCES:
				return references != null && !references.isEmpty();
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
		result.append(" (MinimumCount: ");
		result.append(minimumCount);
		result.append(", Name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ModelElementOverrideImpl
