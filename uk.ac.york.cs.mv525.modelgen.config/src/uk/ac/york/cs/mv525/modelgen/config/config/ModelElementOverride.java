/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.common.util.EList;
import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Override</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getMinimumCount <em>Minimum Count</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getStringPools <em>String Pools</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelElementOverride()
 * @model
 * @generated
 */
public interface ModelElementOverride extends EObject {
	/**
	 * Returns the value of the '<em><b>Minimum Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Count</em>' attribute.
	 * @see #setMinimumCount(long)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelElementOverride_MinimumCount()
	 * @model
	 * @generated
	 */
	long getMinimumCount();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getMinimumCount <em>Minimum Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Count</em>' attribute.
	 * @see #getMinimumCount()
	 * @generated
	 */
	void setMinimumCount(long value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelElementOverride_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>String Pools</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Pools</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Pools</em>' containment reference.
	 * @see #setStringPools(StringPool)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelElementOverride_StringPools()
	 * @model containment="true"
	 * @generated
	 */
	StringPool getStringPools();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getStringPools <em>String Pools</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Pools</em>' containment reference.
	 * @see #getStringPools()
	 * @generated
	 */
	void setStringPools(StringPool value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelElementOverride_References()
	 * @model type="uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride" containment="true"
	 * @generated
	 */
	EList getReferences();

} // ModelElementOverride
