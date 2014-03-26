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

import org.eclipse.emf.ecore.impl.EObjectImpl;
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
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EmbeddedStringPoolImpl#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EmbeddedStringPoolImpl#getStrings <em>Strings</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EmbeddedStringPoolImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmbeddedStringPoolImpl extends EObjectImpl implements EmbeddedStringPool {
	
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
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EList entries;

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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EMBEDDED_STRING_POOL__NAME, oldName, name));
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
	 * @generated
	 */
	public EList getEntries() {
		if (entries == null) {
			entries = new EObjectContainmentEList(StringPoolEntry.class, this, ConfigPackage.EMBEDDED_STRING_POOL__ENTRIES);
		}
		return entries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.EMBEDDED_STRING_POOL__ENTRIES:
				return ((InternalEList)getEntries()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ConfigPackage.EMBEDDED_STRING_POOL__NAME:
				return getName();
			case ConfigPackage.EMBEDDED_STRING_POOL__STRINGS:
				return getStrings();
			case ConfigPackage.EMBEDDED_STRING_POOL__ENTRIES:
				return getEntries();
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
			case ConfigPackage.EMBEDDED_STRING_POOL__NAME:
				setName((String)newValue);
				return;
			case ConfigPackage.EMBEDDED_STRING_POOL__STRINGS:
				getStrings().clear();
				getStrings().addAll((Collection)newValue);
				return;
			case ConfigPackage.EMBEDDED_STRING_POOL__ENTRIES:
				getEntries().clear();
				getEntries().addAll((Collection)newValue);
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
			case ConfigPackage.EMBEDDED_STRING_POOL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigPackage.EMBEDDED_STRING_POOL__STRINGS:
				getStrings().clear();
				return;
			case ConfigPackage.EMBEDDED_STRING_POOL__ENTRIES:
				getEntries().clear();
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
			case ConfigPackage.EMBEDDED_STRING_POOL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigPackage.EMBEDDED_STRING_POOL__STRINGS:
				return strings != null && !strings.isEmpty();
			case ConfigPackage.EMBEDDED_STRING_POOL__ENTRIES:
				return entries != null && !entries.isEmpty();
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
		result.append(" (Name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EmbeddedStringPoolImpl
