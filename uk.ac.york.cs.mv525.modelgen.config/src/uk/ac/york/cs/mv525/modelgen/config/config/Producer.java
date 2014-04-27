/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Producer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.Producer#getStrategy <em>Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getProducer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Producer extends EObject {
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
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getProducer_Strategy()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Strategy getStrategy();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.Producer#getStrategy <em>Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strategy</em>' containment reference.
	 * @see #getStrategy()
	 * @generated
	 */
	void setStrategy(Strategy value);

} // Producer
