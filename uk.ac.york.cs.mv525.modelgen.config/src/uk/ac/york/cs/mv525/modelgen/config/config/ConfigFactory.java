/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage
 * @generated
 */
public interface ConfigFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigFactory eINSTANCE = uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Element Override</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element Override</em>'.
	 * @generated
	 */
	ModelElementOverride createModelElementOverride();

	/**
	 * Returns a new object of class '<em>Model Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Configuration</em>'.
	 * @generated
	 */
	ModelConfiguration createModelConfiguration();

	/**
	 * Returns a new object of class '<em>Model Element Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element Exclusion</em>'.
	 * @generated
	 */
	ModelElementExclusion createModelElementExclusion();

	/**
	 * Returns a new object of class '<em>File String Pool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File String Pool</em>'.
	 * @generated
	 */
	FileStringPool createFileStringPool();

	/**
	 * Returns a new object of class '<em>Embedded String Pool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Embedded String Pool</em>'.
	 * @generated
	 */
	EmbeddedStringPool createEmbeddedStringPool();

	/**
	 * Returns a new object of class '<em>String Pool Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Pool Entry</em>'.
	 * @generated
	 */
	StringPoolEntry createStringPoolEntry();

	/**
	 * Returns a new object of class '<em>Reference Override</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Override</em>'.
	 * @generated
	 */
	ReferenceOverride createReferenceOverride();

	/**
	 * Returns a new object of class '<em>Random Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Generator</em>'.
	 * @generated
	 */
	RandomGenerator createRandomGenerator();

	/**
	 * Returns a new object of class '<em>Always Create Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Always Create Strategy</em>'.
	 * @generated
	 */
	AlwaysCreateStrategy createAlwaysCreateStrategy();

	/**
	 * Returns a new object of class '<em>Always Retrieve Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Always Retrieve Strategy</em>'.
	 * @generated
	 */
	AlwaysRetrieveStrategy createAlwaysRetrieveStrategy();

	/**
	 * Returns a new object of class '<em>Always Retrieve Or Create Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Always Retrieve Or Create Strategy</em>'.
	 * @generated
	 */
	AlwaysRetrieveOrCreateStrategy createAlwaysRetrieveOrCreateStrategy();

	/**
	 * Returns a new object of class '<em>Eol Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eol Generator</em>'.
	 * @generated
	 */
	EolGenerator createEolGenerator();

	/**
	 * Returns a new object of class '<em>Combined Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Combined Generator</em>'.
	 * @generated
	 */
	CombinedGenerator createCombinedGenerator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConfigPackage getConfigPackage();

} //ConfigFactory
