/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Override</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ReferenceOverrideImpl#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ReferenceOverrideImpl#getMinimumCount <em>Minimum Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceOverrideImpl extends EObjectImpl implements ReferenceOverride {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceOverrideImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.REFERENCE_OVERRIDE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.REFERENCE_OVERRIDE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.REFERENCE_OVERRIDE__MINIMUM_COUNT, oldMinimumCount, minimumCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.REFERENCE_OVERRIDE__NAME:
				return getName();
			case ConfigPackage.REFERENCE_OVERRIDE__MINIMUM_COUNT:
				return getMinimumCount();
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
			case ConfigPackage.REFERENCE_OVERRIDE__NAME:
				setName((String)newValue);
				return;
			case ConfigPackage.REFERENCE_OVERRIDE__MINIMUM_COUNT:
				setMinimumCount((Long)newValue);
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
			case ConfigPackage.REFERENCE_OVERRIDE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigPackage.REFERENCE_OVERRIDE__MINIMUM_COUNT:
				setMinimumCount(MINIMUM_COUNT_EDEFAULT);
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
			case ConfigPackage.REFERENCE_OVERRIDE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigPackage.REFERENCE_OVERRIDE__MINIMUM_COUNT:
				return minimumCount != MINIMUM_COUNT_EDEFAULT;
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
		result.append(" (Name: ");
		result.append(name);
		result.append(", MinimumCount: ");
		result.append(minimumCount);
		result.append(')');
		return result.toString();
	}

} //ReferenceOverrideImpl
