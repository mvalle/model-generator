/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getGenerator()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Generator extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject create(EClass mClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object add(EObject iObject, EStructuralFeature mAttribute);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object link(EObject iObjectContainer, EReference mReference);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean before();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean after();

} // Generator
