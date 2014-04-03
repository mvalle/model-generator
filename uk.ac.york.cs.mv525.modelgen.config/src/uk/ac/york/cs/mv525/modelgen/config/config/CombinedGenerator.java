/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Combined Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator#getFallback <em>Fallback</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator#getGenerators <em>Generators</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getCombinedGenerator()
 * @model
 * @generated
 */
public interface CombinedGenerator extends Generator {
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
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getCombinedGenerator_Fallback()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Generator getFallback();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator#getFallback <em>Fallback</em>}' containment reference.
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
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getCombinedGenerator_Generators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Generator> getGenerators();

} // CombinedGenerator
