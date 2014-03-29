/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator;
import uk.ac.york.cs.mv525.modelgen.config.config.Strategy;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.EolIndex;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.EolParser;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eol Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EolGeneratorImpl#getStrategy <em>Strategy</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EolGeneratorImpl#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EolGeneratorImpl extends EObjectImpl implements EolGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EolGeneratorImpl() {
		super();
	}
	
	EFactory iClassGenerator;
	EolIndex opIndex;
	MetaModelIndex mIndex;
	ModelInstance iModel;
	Strategy strategy;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	public EolGeneratorImpl(String programLocation, ModelInstance modelInstance,
			MetaModelIndex metaModel) throws IOException {
		super();
		
		mIndex = metaModel;
		iModel = modelInstance;
		iClassGenerator = mIndex.getEPackage().getEFactoryInstance();

		EolParser parser = new EolParser(iModel.getResource(),
				mIndex.getEPackage());
		opIndex = parser.parse(programLocation);
		
		setLocation(programLocation);
	}
	
	public void setStrategy(Strategy s) {
		strategy = s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.EOL_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.EOL_GENERATOR__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject create(EClass mClass) {
		try {
			EObject iObject;
			if (opIndex.hasConstructor(mClass)) {
				EolOperation constructOp = opIndex.getConstructor(mClass);
				iObject = (EObject) constructOp.execute(null, Collections.emptyList(),
						opIndex.getEolContext());
				
			}
			else {
				iObject = iClassGenerator.create(mClass);

			EolOperation createOp = opIndex.get(mClass.getName());
			if (createOp != null) {
				createOp.execute(iObject, Collections.emptyList(),
						opIndex.getEolContext());
			}
			}
			iModel.add(iObject); /* Controversial */

			return iObject;

		} catch (EolRuntimeException e) {			
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object add(EObject iObject, EStructuralFeature mAttribute) {
		try {

			if (!iObject.eIsSet(mAttribute)) {

				EolOperation attributeOp = opIndex.get(iObject.eClass(),
						mAttribute);

				if (attributeOp != null) {
					attributeOp.execute(iObject, Collections.emptyList(),
							opIndex.getEolContext());
					
					//System.out. 
					if(opIndex.getEolContext().getErrorStream().checkError()) {
						System.out.println("ERROR");
						
					}
					
				}
			}

			return iObject.eGet(mAttribute);

		} catch (EolRuntimeException e) {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object link(EObject iObjectContainer, EReference mReference) {
		/*
		 * +------------------+ +---------------------+---------+ |
		 * iObjectContainer |---->| iReferenceContainer | iObject |
		 * +------------------+ +---------------------+---------+
		 */
		@SuppressWarnings("unchecked")
		EList<EObject> iReferenceContainer = (EList<EObject>) iObjectContainer
				.eGet(mReference);

		EObject iObject = getStrategy().retrieveObject((EClass) mReference
				.getEType());

		iReferenceContainer.add(iObject);

		return null; // NOTE: Not implemented while not executing any EOL.
						// For now just a copy of the RandomGenerator's
						// link.
		// return iObjectContainer.eGet(mReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean before() {
		try {
			EolOperation op = opIndex.getBefore();
			if (op != null) {
				op.execute(null, Collections.emptyList(),
						opIndex.getEolContext());
				return true;
			}
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean after() {
		try {
			EolOperation op = opIndex.getAfter();
			if (op != null) {
				op.execute(null, Collections.emptyList(),
						opIndex.getEolContext());
				return true;
			}
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.EOL_GENERATOR__STRATEGY:
				if (resolve) return getStrategy();
				return basicGetStrategy();
			case ConfigPackage.EOL_GENERATOR__LOCATION:
				return getLocation();
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
			case ConfigPackage.EOL_GENERATOR__STRATEGY:
				setStrategy((Strategy)newValue);
				return;
			case ConfigPackage.EOL_GENERATOR__LOCATION:
				setLocation((String)newValue);
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
			case ConfigPackage.EOL_GENERATOR__STRATEGY:
				setStrategy((Strategy)null);
				return;
			case ConfigPackage.EOL_GENERATOR__LOCATION:
				setLocation(LOCATION_EDEFAULT);
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
			case ConfigPackage.EOL_GENERATOR__STRATEGY:
				return strategy != null;
			case ConfigPackage.EOL_GENERATOR__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
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
		result.append(" (location: ");
		result.append(location);
		result.append(')');
		return result.toString();
	}

	@Override
	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy basicGetStrategy() {
		return strategy;
	}

} //EolGeneratorImpl
