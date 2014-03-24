/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Embedded String Pool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool#getStrings <em>Strings</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getEmbeddedStringPool()
 * @model
 * @generated
 */
public interface EmbeddedStringPool extends StringPool {
	/**
	 * Returns the value of the '<em><b>Strings</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strings</em>' reference list.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#getEmbeddedStringPool_Strings()
	 * @model type="uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry" required="true"
	 * @generated
	 */
	EList getStrings();

} // EmbeddedStringPool
