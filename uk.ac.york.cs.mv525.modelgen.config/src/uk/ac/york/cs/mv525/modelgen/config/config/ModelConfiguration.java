/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getModelElementOverrides <em>Model Element Overrides</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#isDeterministic <em>Deterministic</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getTotalMinimumCount <em>Total Minimum Count</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getModelElemetExclusions <em>Model Elemet Exclusions</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getDefaultStringPool <em>Default String Pool</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getProducer <em>Producer</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelConfiguration()
 * @model
 * @generated
 */
public interface ModelConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Element Overrides</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Overrides</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Overrides</em>' containment reference list.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelConfiguration_ModelElementOverrides()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementOverride> getModelElementOverrides();

	/**
	 * Returns the value of the '<em><b>Deterministic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deterministic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deterministic</em>' attribute.
	 * @see #setDeterministic(boolean)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelConfiguration_Deterministic()
	 * @model
	 * @generated
	 */
	boolean isDeterministic();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#isDeterministic <em>Deterministic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deterministic</em>' attribute.
	 * @see #isDeterministic()
	 * @generated
	 */
	void setDeterministic(boolean value);

	/**
	 * Returns the value of the '<em><b>Total Minimum Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Minimum Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Minimum Count</em>' attribute.
	 * @see #setTotalMinimumCount(long)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelConfiguration_TotalMinimumCount()
	 * @model
	 * @generated
	 */
	long getTotalMinimumCount();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getTotalMinimumCount <em>Total Minimum Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Minimum Count</em>' attribute.
	 * @see #getTotalMinimumCount()
	 * @generated
	 */
	void setTotalMinimumCount(long value);

	/**
	 * Returns the value of the '<em><b>Model Elemet Exclusions</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elemet Exclusions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Elemet Exclusions</em>' containment reference list.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelConfiguration_ModelElemetExclusions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementExclusion> getModelElemetExclusions();

	/**
	 * Returns the value of the '<em><b>Default String Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default String Pool</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default String Pool</em>' containment reference.
	 * @see #setDefaultStringPool(StringPool)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelConfiguration_DefaultStringPool()
	 * @model containment="true"
	 * @generated
	 */
	StringPool getDefaultStringPool();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getDefaultStringPool <em>Default String Pool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default String Pool</em>' containment reference.
	 * @see #getDefaultStringPool()
	 * @generated
	 */
	void setDefaultStringPool(StringPool value);

	/**
	 * Returns the value of the '<em><b>Producer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Producer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Producer</em>' containment reference.
	 * @see #setProducer(Producer)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelConfiguration_Producer()
	 * @model containment="true"
	 * @generated
	 */
	Producer getProducer();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getProducer <em>Producer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Producer</em>' containment reference.
	 * @see #getProducer()
	 * @generated
	 */
	void setProducer(Producer value);

} // ModelConfiguration
