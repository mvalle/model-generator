/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Combined Producer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.CombinedProducer#getFallback <em>Fallback</em>}</li>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.CombinedProducer#getProducers <em>Producers</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getCombinedProducer()
 * @model
 * @generated
 */
public interface CombinedProducer extends Producer {
	/**
	 * Returns the value of the '<em><b>Fallback</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fallback</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fallback</em>' containment reference.
	 * @see #setFallback(Producer)
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getCombinedProducer_Fallback()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Producer getFallback();

	/**
	 * Sets the value of the '{@link uk.ac.york.cs.mv525.modelgen.config.config.CombinedProducer#getFallback <em>Fallback</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fallback</em>' containment reference.
	 * @see #getFallback()
	 * @generated
	 */
	void setFallback(Producer value);

	/**
	 * Returns the value of the '<em><b>Producers</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.cs.mv525.modelgen.config.config.Producer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Producers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Producers</em>' containment reference list.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getCombinedProducer_Producers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Producer> getProducers();

} // CombinedProducer
