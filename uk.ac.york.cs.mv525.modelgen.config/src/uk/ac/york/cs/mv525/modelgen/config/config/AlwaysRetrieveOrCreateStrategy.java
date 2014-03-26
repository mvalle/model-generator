/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Always Retrieve Or Create Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy#getRetriver <em>Retriver</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy#getCreator <em>Creator</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getAlwaysRetrieveOrCreateStrategy()
 * @model
 * @generated
 */
public interface AlwaysRetrieveOrCreateStrategy extends Strategy {
	/**
	 * Returns the value of the '<em><b>Retriver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retriver</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retriver</em>' containment reference.
	 * @see #setRetriver(AlwaysRetrieveStrategy)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getAlwaysRetrieveOrCreateStrategy_Retriver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AlwaysRetrieveStrategy getRetriver();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy#getRetriver <em>Retriver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retriver</em>' containment reference.
	 * @see #getRetriver()
	 * @generated
	 */
	void setRetriver(AlwaysRetrieveStrategy value);

	/**
	 * Returns the value of the '<em><b>Creator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creator</em>' containment reference.
	 * @see #setCreator(AlwaysCreateStrategy)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getAlwaysRetrieveOrCreateStrategy_Creator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AlwaysCreateStrategy getCreator();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy#getCreator <em>Creator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creator</em>' containment reference.
	 * @see #getCreator()
	 * @generated
	 */
	void setCreator(AlwaysCreateStrategy value);

} // AlwaysRetrieveOrCreateStrategy
