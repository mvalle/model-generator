/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Generation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration#getFallback <em>Fallback</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration#getGenerators <em>Generators</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration#getStrategy <em>Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelGeneration()
 * @model
 * @generated
 */
public interface ModelGeneration extends EObject {
	/**
	 * Returns the value of the '<em><b>Fallback</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fallback</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fallback</em>' containment reference.
	 * @see #setFallback(Generator)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelGeneration_Fallback()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Generator getFallback();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration#getFallback <em>Fallback</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fallback</em>' containment reference.
	 * @see #getFallback()
	 * @generated
	 */
	void setFallback(Generator value);

	/**
	 * Returns the value of the '<em><b>Generators</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.cs.mv525.modelgen.config.config.Generator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generators</em>' containment reference list.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelGeneration_Generators()
	 * @model type="uk.ac.york.cs.mv525.modelgen.config.config.Generator" containment="true"
	 * @generated
	 */
	EList getGenerators();

	/**
	 * Returns the value of the '<em><b>Strategy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategy</em>' containment reference.
	 * @see #setStrategy(Strategy)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelGeneration_Strategy()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Strategy getStrategy();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration#getStrategy <em>Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strategy</em>' containment reference.
	 * @see #getStrategy()
	 * @generated
	 */
	void setStrategy(Strategy value);

	void addGenerator(Generator gen);

	boolean before();

	EObject create(EClass mClass);

	Object add(EObject iObject, EStructuralFeature feature);

	Object link(EObject iObject, EReference feature);

	boolean after();

} // ModelGeneration
