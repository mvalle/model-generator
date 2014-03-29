/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Always Create Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy#getGenerator <em>Generator</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getAlwaysCreateStrategy()
 * @model
 * @generated
 */
public interface AlwaysCreateStrategy extends Strategy {
	/**
	 * Returns the value of the '<em><b>Generator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generator</em>' reference.
	 * @see #setGenerator(Generator)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getAlwaysCreateStrategy_Generator()
	 * @model required="true"
	 * @generated
	 */
	Generator getGenerator();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy#getGenerator <em>Generator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generator</em>' reference.
	 * @see #getGenerator()
	 * @generated
	 */
	void setGenerator(Generator value);

} // AlwaysCreateStrategy
