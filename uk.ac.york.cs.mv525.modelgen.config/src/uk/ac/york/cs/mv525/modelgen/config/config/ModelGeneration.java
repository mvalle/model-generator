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
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration#getDefaultStrategy <em>Default Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelGeneration()
 * @model
 * @generated
 */
public interface ModelGeneration extends EObject {
	/**
	 * Returns the value of the '<em><b>Fallback</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fallback</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fallback</em>' reference.
	 * @see #setFallback(Generator)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelGeneration_Fallback()
	 * @model
	 * @generated
	 */
	Generator getFallback();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration#getFallback <em>Fallback</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fallback</em>' reference.
	 * @see #getFallback()
	 * @generated
	 */
	void setFallback(Generator value);

	/**
	 * Returns the value of the '<em><b>Generators</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.cs.mv525.modelgen.config.config.Generator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generators</em>' reference list.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelGeneration_Generators()
	 * @model
	 * @generated
	 */
	EList<Generator> getGenerators();

	/**
	 * Returns the value of the '<em><b>Default Strategy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Strategy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Strategy</em>' reference.
	 * @see #setDefaultStrategy(Strategy)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getModelGeneration_DefaultStrategy()
	 * @model
	 * @generated
	 */
	Strategy getDefaultStrategy();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration#getDefaultStrategy <em>Default Strategy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Strategy</em>' reference.
	 * @see #getDefaultStrategy()
	 * @generated
	 */
	void setDefaultStrategy(Strategy value);

	void addGenerator(Generator gen);

	boolean before();

	EObject create(EClass mClass);

	Object add(EObject iObject, EStructuralFeature feature);

	Object link(EObject iObject, EReference feature);

	boolean after();

} // ModelGeneration
