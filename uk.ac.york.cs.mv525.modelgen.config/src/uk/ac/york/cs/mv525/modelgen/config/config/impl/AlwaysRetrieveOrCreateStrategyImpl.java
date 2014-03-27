/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy;
import uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy;
import uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveStrategy;
import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.Strategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Always Retrieve Or Create Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveOrCreateStrategyImpl#getRetriver <em>Retriver</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveOrCreateStrategyImpl#getCreator <em>Creator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlwaysRetrieveOrCreateStrategyImpl extends EObjectImpl implements AlwaysRetrieveOrCreateStrategy {
	/**
	 * The cached value of the '{@link #getRetriver() <em>Retriver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetriver()
	 * @generated
	 * @ordered
	 */
	protected AlwaysRetrieveStrategy retriver;

	/**
	 * The cached value of the '{@link #getCreator() <em>Creator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected AlwaysCreateStrategy creator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlwaysRetrieveOrCreateStrategyImpl() {
		super();
	}
	
	public AlwaysRetrieveOrCreateStrategyImpl(Strategy creator, Strategy retriever) {
		super();
		//setCreator(creator);
		//setRetriver(retriever);
		this.creator = (AlwaysCreateStrategy) creator;
		this.retriver = (AlwaysRetrieveStrategy) retriever;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysRetrieveStrategy getRetriver() {
		return retriver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRetriver(AlwaysRetrieveStrategy newRetriver, NotificationChain msgs) {
		AlwaysRetrieveStrategy oldRetriver = retriver;
		retriver = newRetriver;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER, oldRetriver, newRetriver);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetriver(AlwaysRetrieveStrategy newRetriver) {
		if (newRetriver != retriver) {
			NotificationChain msgs = null;
			if (retriver != null)
				msgs = ((InternalEObject)retriver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER, null, msgs);
			if (newRetriver != null)
				msgs = ((InternalEObject)newRetriver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER, null, msgs);
			msgs = basicSetRetriver(newRetriver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER, newRetriver, newRetriver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysCreateStrategy getCreator() {
		return creator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCreator(AlwaysCreateStrategy newCreator, NotificationChain msgs) {
		AlwaysCreateStrategy oldCreator = creator;
		creator = newCreator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR, oldCreator, newCreator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreator(AlwaysCreateStrategy newCreator) {
		if (newCreator != creator) {
			NotificationChain msgs = null;
			if (creator != null)
				msgs = ((InternalEObject)creator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR, null, msgs);
			if (newCreator != null)
				msgs = ((InternalEObject)newCreator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR, null, msgs);
			msgs = basicSetCreator(newCreator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR, newCreator, newCreator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject retrieveObject(EClass mType) {
		EObject o = retriver.retrieveObject(mType);
		if (o == null) {
			o = creator.retrieveObject(mType);
		}
		return o;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER:
				return basicSetRetriver(null, msgs);
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR:
				return basicSetCreator(null, msgs);
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
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER:
				return getRetriver();
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR:
				return getCreator();
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
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER:
				setRetriver((AlwaysRetrieveStrategy)newValue);
				return;
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR:
				setCreator((AlwaysCreateStrategy)newValue);
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
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER:
				setRetriver((AlwaysRetrieveStrategy)null);
				return;
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR:
				setCreator((AlwaysCreateStrategy)null);
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
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER:
				return retriver != null;
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR:
				return creator != null;
		}
		return super.eIsSet(featureID);
	}

} //AlwaysRetrieveOrCreateStrategyImpl
