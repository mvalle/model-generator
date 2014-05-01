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
	 * The cached value of the '{@link #getStringPools() <em>String Pools</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringPools()
	 * @generated
	 * @ordered
	 */
	protected EList<StringPool> stringPools;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceOverride> references;

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
	@Override
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
	public EList<StringPool> getStringPools() {
		if (stringPools == null) {
			stringPools = new EObjectContainmentEList<StringPool>(StringPool.class, this, ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS);
		}
		return stringPools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceOverride> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<ReferenceOverride>(ReferenceOverride.class, this, ConfigPackage.MODEL_ELEMENT_OVERRIDE__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS:
				return ((InternalEList<?>)getStringPools()).basicRemove(otherEnd, msgs);
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT:
				return getMinimumCount();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT:
				setMinimumCount((Long)newValue);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__NAME:
				setName((String)newValue);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS:
				getStringPools().clear();
				getStringPools().addAll((Collection<? extends StringPool>)newValue);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends ReferenceOverride>)newValue);
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
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT:
				setMinimumCount(MINIMUM_COUNT_EDEFAULT);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS:
				getStringPools().clear();
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT:
				return minimumCount != MINIMUM_COUNT_EDEFAULT;
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE__STRING_POOLS:
				return stringPools != null && !stringPools.isEmpty();
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
	@Override
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
