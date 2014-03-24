/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Embedded String Pool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EmbeddedStringPoolImpl#getStrings <em>Strings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmbeddedStringPoolImpl extends StringPoolImpl implements EmbeddedStringPool {
	
	private int state = 0;
	/**
	 * The cached value of the '{@link #getStrings() <em>Strings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrings()
	 * @generated
	 * @ordered
	 */
	protected EList strings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmbeddedStringPoolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.EMBEDDED_STRING_POOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getStrings() {
		if (strings == null) {
			strings = new EObjectResolvingEList(StringPoolEntry.class, this, ConfigPackage.EMBEDDED_STRING_POOL__STRINGS);
		}
		return strings;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StringPoolEntry get() {
		if (getStrings().size() > 0) {
		return (StringPoolEntry) getStrings().get((state++)%getStrings().size());
		} else {
			return null;
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.EMBEDDED_STRING_POOL__STRINGS:
				return getStrings();
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
			case ConfigPackage.EMBEDDED_STRING_POOL__STRINGS:
				getStrings().clear();
				getStrings().addAll((Collection)newValue);
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
			case ConfigPackage.EMBEDDED_STRING_POOL__STRINGS:
				getStrings().clear();
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
			case ConfigPackage.EMBEDDED_STRING_POOL__STRINGS:
				return strings != null && !strings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EmbeddedStringPoolImpl
