/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "config";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://config/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "config";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigPackage eINSTANCE = uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementOverrideImpl <em>Model Element Override</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementOverrideImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getModelElementOverride()
	 * @generated
	 */
	int MODEL_ELEMENT_OVERRIDE = 0;

	/**
	 * The feature id for the '<em><b>Minimum Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OVERRIDE__NAME = 1;

	/**
	 * The feature id for the '<em><b>String Pools</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OVERRIDE__STRING_POOLS = 2;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OVERRIDE__REFERENCES = 3;

	/**
	 * The number of structural features of the '<em>Model Element Override</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OVERRIDE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl <em>Model Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getModelConfiguration()
	 * @generated
	 */
	int MODEL_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Model Element Overrides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES = 0;

	/**
	 * The feature id for the '<em><b>Total Minimum Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Model Elemet Exclusions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS = 2;

	/**
	 * The feature id for the '<em><b>Deterministic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONFIGURATION__DETERMINISTIC = 3;

	/**
	 * The feature id for the '<em><b>Default String Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONFIGURATION__DEFAULT_STRING_POOL = 4;

	/**
	 * The feature id for the '<em><b>Meta Model Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONFIGURATION__META_MODEL_LOCATION = 5;

	/**
	 * The feature id for the '<em><b>Output Model Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONFIGURATION__OUTPUT_MODEL_LOCATION = 6;

	/**
	 * The feature id for the '<em><b>Generator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONFIGURATION__GENERATOR = 7;

	/**
	 * The number of structural features of the '<em>Model Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONFIGURATION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementExclusionImpl <em>Model Element Exclusion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementExclusionImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getModelElementExclusion()
	 * @generated
	 */
	int MODEL_ELEMENT_EXCLUSION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_EXCLUSION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Model Element Exclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_EXCLUSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.StringPool <em>String Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.StringPool
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getStringPool()
	 * @generated
	 */
	int STRING_POOL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_POOL__NAME = 0;

	/**
	 * The number of structural features of the '<em>String Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_POOL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.FileStringPoolImpl <em>File String Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.FileStringPoolImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getFileStringPool()
	 * @generated
	 */
	int FILE_STRING_POOL = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STRING_POOL__NAME = STRING_POOL__NAME;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STRING_POOL__LOCATION = STRING_POOL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File String Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STRING_POOL_FEATURE_COUNT = STRING_POOL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EmbeddedStringPoolImpl <em>Embedded String Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.EmbeddedStringPoolImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getEmbeddedStringPool()
	 * @generated
	 */
	int EMBEDDED_STRING_POOL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_STRING_POOL__NAME = STRING_POOL__NAME;

	/**
	 * The feature id for the '<em><b>Strings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_STRING_POOL__STRINGS = STRING_POOL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_STRING_POOL__ENTRIES = STRING_POOL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Embedded String Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_STRING_POOL_FEATURE_COUNT = STRING_POOL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.StringPoolEntryImpl <em>String Pool Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.StringPoolEntryImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getStringPoolEntry()
	 * @generated
	 */
	int STRING_POOL_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_POOL_ENTRY__STRING = 0;

	/**
	 * The number of structural features of the '<em>String Pool Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_POOL_ENTRY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ReferenceOverrideImpl <em>Reference Override</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ReferenceOverrideImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getReferenceOverride()
	 * @generated
	 */
	int REFERENCE_OVERRIDE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OVERRIDE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Minimum Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OVERRIDE__MINIMUM_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Maximum Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OVERRIDE__MAXIMUM_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Reference Override</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OVERRIDE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.Generator <em>Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.Generator
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getGenerator()
	 * @generated
	 */
	int GENERATOR = 8;

	/**
	 * The feature id for the '<em><b>Strategy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR__STRATEGY = 0;

	/**
	 * The number of structural features of the '<em>Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.RandomGeneratorImpl <em>Random Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.RandomGeneratorImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getRandomGenerator()
	 * @generated
	 */
	int RANDOM_GENERATOR = 9;

	/**
	 * The feature id for the '<em><b>Strategy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR__STRATEGY = GENERATOR__STRATEGY;

	/**
	 * The number of structural features of the '<em>Random Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR_FEATURE_COUNT = GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.Strategy <em>Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.Strategy
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getStrategy()
	 * @generated
	 */
	int STRATEGY = 10;

	/**
	 * The number of structural features of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysCreateStrategyImpl <em>Always Create Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysCreateStrategyImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getAlwaysCreateStrategy()
	 * @generated
	 */
	int ALWAYS_CREATE_STRATEGY = 11;

	/**
	 * The feature id for the '<em><b>Generator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_CREATE_STRATEGY__GENERATOR = STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Always Create Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_CREATE_STRATEGY_FEATURE_COUNT = STRATEGY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveStrategyImpl <em>Always Retrieve Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveStrategyImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getAlwaysRetrieveStrategy()
	 * @generated
	 */
	int ALWAYS_RETRIEVE_STRATEGY = 12;

	/**
	 * The number of structural features of the '<em>Always Retrieve Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_RETRIEVE_STRATEGY_FEATURE_COUNT = STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveOrCreateStrategyImpl <em>Always Retrieve Or Create Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveOrCreateStrategyImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getAlwaysRetrieveOrCreateStrategy()
	 * @generated
	 */
	int ALWAYS_RETRIEVE_OR_CREATE_STRATEGY = 13;

	/**
	 * The feature id for the '<em><b>Retriver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER = STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR = STRATEGY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Always Retrieve Or Create Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_RETRIEVE_OR_CREATE_STRATEGY_FEATURE_COUNT = STRATEGY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EolGeneratorImpl <em>Eol Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.EolGeneratorImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getEolGenerator()
	 * @generated
	 */
	int EOL_GENERATOR = 14;

	/**
	 * The feature id for the '<em><b>Strategy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOL_GENERATOR__STRATEGY = GENERATOR__STRATEGY;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOL_GENERATOR__LOCATION = GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Eol Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOL_GENERATOR_FEATURE_COUNT = GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.CombinedGeneratorImpl <em>Combined Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.CombinedGeneratorImpl
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getCombinedGenerator()
	 * @generated
	 */
	int COMBINED_GENERATOR = 15;

	/**
	 * The feature id for the '<em><b>Strategy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_GENERATOR__STRATEGY = GENERATOR__STRATEGY;

	/**
	 * The feature id for the '<em><b>Fallback</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_GENERATOR__FALLBACK = GENERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Generators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_GENERATOR__GENERATORS = GENERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Combined Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_GENERATOR_FEATURE_COUNT = GENERATOR_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride <em>Model Element Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Override</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride
	 * @generated
	 */
	EClass getModelElementOverride();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getMinimumCount <em>Minimum Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Count</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getMinimumCount()
	 * @see #getModelElementOverride()
	 * @generated
	 */
	EAttribute getModelElementOverride_MinimumCount();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getName()
	 * @see #getModelElementOverride()
	 * @generated
	 */
	EAttribute getModelElementOverride_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getStringPools <em>String Pools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>String Pools</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getStringPools()
	 * @see #getModelElementOverride()
	 * @generated
	 */
	EReference getModelElementOverride_StringPools();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride#getReferences()
	 * @see #getModelElementOverride()
	 * @generated
	 */
	EReference getModelElementOverride_References();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration <em>Model Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Configuration</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration
	 * @generated
	 */
	EClass getModelConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getModelElementOverrides <em>Model Element Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Element Overrides</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getModelElementOverrides()
	 * @see #getModelConfiguration()
	 * @generated
	 */
	EReference getModelConfiguration_ModelElementOverrides();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getTotalMinimumCount <em>Total Minimum Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Minimum Count</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getTotalMinimumCount()
	 * @see #getModelConfiguration()
	 * @generated
	 */
	EAttribute getModelConfiguration_TotalMinimumCount();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getModelElemetExclusions <em>Model Elemet Exclusions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elemet Exclusions</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getModelElemetExclusions()
	 * @see #getModelConfiguration()
	 * @generated
	 */
	EReference getModelConfiguration_ModelElemetExclusions();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#isDeterministic <em>Deterministic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deterministic</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#isDeterministic()
	 * @see #getModelConfiguration()
	 * @generated
	 */
	EAttribute getModelConfiguration_Deterministic();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getDefaultStringPool <em>Default String Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default String Pool</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getDefaultStringPool()
	 * @see #getModelConfiguration()
	 * @generated
	 */
	EReference getModelConfiguration_DefaultStringPool();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getMetaModelLocation <em>Meta Model Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Model Location</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getMetaModelLocation()
	 * @see #getModelConfiguration()
	 * @generated
	 */
	EAttribute getModelConfiguration_MetaModelLocation();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getOutputModelLocation <em>Output Model Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Model Location</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getOutputModelLocation()
	 * @see #getModelConfiguration()
	 * @generated
	 */
	EAttribute getModelConfiguration_OutputModelLocation();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getGenerator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Generator</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration#getGenerator()
	 * @see #getModelConfiguration()
	 * @generated
	 */
	EReference getModelConfiguration_Generator();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion <em>Model Element Exclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Exclusion</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion
	 * @generated
	 */
	EClass getModelElementExclusion();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion#getName()
	 * @see #getModelElementExclusion()
	 * @generated
	 */
	EAttribute getModelElementExclusion_Name();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.StringPool <em>String Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Pool</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.StringPool
	 * @generated
	 */
	EClass getStringPool();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.StringPool#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.StringPool#getName()
	 * @see #getStringPool()
	 * @generated
	 */
	EAttribute getStringPool_Name();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.FileStringPool <em>File String Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File String Pool</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.FileStringPool
	 * @generated
	 */
	EClass getFileStringPool();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.FileStringPool#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.FileStringPool#getLocation()
	 * @see #getFileStringPool()
	 * @generated
	 */
	EAttribute getFileStringPool_Location();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool <em>Embedded String Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Embedded String Pool</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool
	 * @generated
	 */
	EClass getEmbeddedStringPool();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool#getStrings <em>Strings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Strings</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool#getStrings()
	 * @see #getEmbeddedStringPool()
	 * @generated
	 */
	EReference getEmbeddedStringPool_Strings();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool#getEntries()
	 * @see #getEmbeddedStringPool()
	 * @generated
	 */
	EReference getEmbeddedStringPool_Entries();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry <em>String Pool Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Pool Entry</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry
	 * @generated
	 */
	EClass getStringPoolEntry();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry#getString()
	 * @see #getStringPoolEntry()
	 * @generated
	 */
	EAttribute getStringPoolEntry_String();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride <em>Reference Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Override</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride
	 * @generated
	 */
	EClass getReferenceOverride();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride#getName()
	 * @see #getReferenceOverride()
	 * @generated
	 */
	EAttribute getReferenceOverride_Name();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride#getMinimumCount <em>Minimum Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Count</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride#getMinimumCount()
	 * @see #getReferenceOverride()
	 * @generated
	 */
	EAttribute getReferenceOverride_MinimumCount();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride#getMaximumCount <em>Maximum Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Count</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride#getMaximumCount()
	 * @see #getReferenceOverride()
	 * @generated
	 */
	EAttribute getReferenceOverride_MaximumCount();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.Generator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.Generator
	 * @generated
	 */
	EClass getGenerator();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.cs.mv525.modelgen.config.config.Generator#getStrategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Strategy</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.Generator#getStrategy()
	 * @see #getGenerator()
	 * @generated
	 */
	EReference getGenerator_Strategy();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator <em>Random Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Generator</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator
	 * @generated
	 */
	EClass getRandomGenerator();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.Strategy
	 * @generated
	 */
	EClass getStrategy();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy <em>Always Create Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Always Create Strategy</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy
	 * @generated
	 */
	EClass getAlwaysCreateStrategy();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy#getGenerator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generator</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy#getGenerator()
	 * @see #getAlwaysCreateStrategy()
	 * @generated
	 */
	EReference getAlwaysCreateStrategy_Generator();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveStrategy <em>Always Retrieve Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Always Retrieve Strategy</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveStrategy
	 * @generated
	 */
	EClass getAlwaysRetrieveStrategy();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy <em>Always Retrieve Or Create Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Always Retrieve Or Create Strategy</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy
	 * @generated
	 */
	EClass getAlwaysRetrieveOrCreateStrategy();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy#getRetriver <em>Retriver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Retriver</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy#getRetriver()
	 * @see #getAlwaysRetrieveOrCreateStrategy()
	 * @generated
	 */
	EReference getAlwaysRetrieveOrCreateStrategy_Retriver();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy#getCreator <em>Creator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Creator</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy#getCreator()
	 * @see #getAlwaysRetrieveOrCreateStrategy()
	 * @generated
	 */
	EReference getAlwaysRetrieveOrCreateStrategy_Creator();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator <em>Eol Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eol Generator</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator
	 * @generated
	 */
	EClass getEolGenerator();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator#getLocation()
	 * @see #getEolGenerator()
	 * @generated
	 */
	EAttribute getEolGenerator_Location();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator <em>Combined Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Combined Generator</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator
	 * @generated
	 */
	EClass getCombinedGenerator();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator#getFallback <em>Fallback</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fallback</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator#getFallback()
	 * @see #getCombinedGenerator()
	 * @generated
	 */
	EReference getCombinedGenerator_Fallback();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator#getGenerators <em>Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generators</em>'.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator#getGenerators()
	 * @see #getCombinedGenerator()
	 * @generated
	 */
	EReference getCombinedGenerator_Generators();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigFactory getConfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementOverrideImpl <em>Model Element Override</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementOverrideImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getModelElementOverride()
		 * @generated
		 */
		EClass MODEL_ELEMENT_OVERRIDE = eINSTANCE.getModelElementOverride();

		/**
		 * The meta object literal for the '<em><b>Minimum Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT = eINSTANCE.getModelElementOverride_MinimumCount();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_OVERRIDE__NAME = eINSTANCE.getModelElementOverride_Name();

		/**
		 * The meta object literal for the '<em><b>String Pools</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_OVERRIDE__STRING_POOLS = eINSTANCE.getModelElementOverride_StringPools();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_OVERRIDE__REFERENCES = eINSTANCE.getModelElementOverride_References();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl <em>Model Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getModelConfiguration()
		 * @generated
		 */
		EClass MODEL_CONFIGURATION = eINSTANCE.getModelConfiguration();

		/**
		 * The meta object literal for the '<em><b>Model Element Overrides</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES = eINSTANCE.getModelConfiguration_ModelElementOverrides();

		/**
		 * The meta object literal for the '<em><b>Total Minimum Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT = eINSTANCE.getModelConfiguration_TotalMinimumCount();

		/**
		 * The meta object literal for the '<em><b>Model Elemet Exclusions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS = eINSTANCE.getModelConfiguration_ModelElemetExclusions();

		/**
		 * The meta object literal for the '<em><b>Deterministic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CONFIGURATION__DETERMINISTIC = eINSTANCE.getModelConfiguration_Deterministic();

		/**
		 * The meta object literal for the '<em><b>Default String Pool</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONFIGURATION__DEFAULT_STRING_POOL = eINSTANCE.getModelConfiguration_DefaultStringPool();

		/**
		 * The meta object literal for the '<em><b>Meta Model Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CONFIGURATION__META_MODEL_LOCATION = eINSTANCE.getModelConfiguration_MetaModelLocation();

		/**
		 * The meta object literal for the '<em><b>Output Model Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CONFIGURATION__OUTPUT_MODEL_LOCATION = eINSTANCE.getModelConfiguration_OutputModelLocation();

		/**
		 * The meta object literal for the '<em><b>Generator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONFIGURATION__GENERATOR = eINSTANCE.getModelConfiguration_Generator();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementExclusionImpl <em>Model Element Exclusion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelElementExclusionImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getModelElementExclusion()
		 * @generated
		 */
		EClass MODEL_ELEMENT_EXCLUSION = eINSTANCE.getModelElementExclusion();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_EXCLUSION__NAME = eINSTANCE.getModelElementExclusion_Name();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.StringPool <em>String Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.StringPool
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getStringPool()
		 * @generated
		 */
		EClass STRING_POOL = eINSTANCE.getStringPool();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_POOL__NAME = eINSTANCE.getStringPool_Name();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.FileStringPoolImpl <em>File String Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.FileStringPoolImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getFileStringPool()
		 * @generated
		 */
		EClass FILE_STRING_POOL = eINSTANCE.getFileStringPool();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_STRING_POOL__LOCATION = eINSTANCE.getFileStringPool_Location();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EmbeddedStringPoolImpl <em>Embedded String Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.EmbeddedStringPoolImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getEmbeddedStringPool()
		 * @generated
		 */
		EClass EMBEDDED_STRING_POOL = eINSTANCE.getEmbeddedStringPool();

		/**
		 * The meta object literal for the '<em><b>Strings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMBEDDED_STRING_POOL__STRINGS = eINSTANCE.getEmbeddedStringPool_Strings();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMBEDDED_STRING_POOL__ENTRIES = eINSTANCE.getEmbeddedStringPool_Entries();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.StringPoolEntryImpl <em>String Pool Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.StringPoolEntryImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getStringPoolEntry()
		 * @generated
		 */
		EClass STRING_POOL_ENTRY = eINSTANCE.getStringPoolEntry();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_POOL_ENTRY__STRING = eINSTANCE.getStringPoolEntry_String();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.ReferenceOverrideImpl <em>Reference Override</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ReferenceOverrideImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getReferenceOverride()
		 * @generated
		 */
		EClass REFERENCE_OVERRIDE = eINSTANCE.getReferenceOverride();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_OVERRIDE__NAME = eINSTANCE.getReferenceOverride_Name();

		/**
		 * The meta object literal for the '<em><b>Minimum Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_OVERRIDE__MINIMUM_COUNT = eINSTANCE.getReferenceOverride_MinimumCount();

		/**
		 * The meta object literal for the '<em><b>Maximum Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_OVERRIDE__MAXIMUM_COUNT = eINSTANCE.getReferenceOverride_MaximumCount();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.Generator <em>Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.Generator
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getGenerator()
		 * @generated
		 */
		EClass GENERATOR = eINSTANCE.getGenerator();

		/**
		 * The meta object literal for the '<em><b>Strategy</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR__STRATEGY = eINSTANCE.getGenerator_Strategy();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.RandomGeneratorImpl <em>Random Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.RandomGeneratorImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getRandomGenerator()
		 * @generated
		 */
		EClass RANDOM_GENERATOR = eINSTANCE.getRandomGenerator();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.Strategy <em>Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.Strategy
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getStrategy()
		 * @generated
		 */
		EClass STRATEGY = eINSTANCE.getStrategy();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysCreateStrategyImpl <em>Always Create Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysCreateStrategyImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getAlwaysCreateStrategy()
		 * @generated
		 */
		EClass ALWAYS_CREATE_STRATEGY = eINSTANCE.getAlwaysCreateStrategy();

		/**
		 * The meta object literal for the '<em><b>Generator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALWAYS_CREATE_STRATEGY__GENERATOR = eINSTANCE.getAlwaysCreateStrategy_Generator();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveStrategyImpl <em>Always Retrieve Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveStrategyImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getAlwaysRetrieveStrategy()
		 * @generated
		 */
		EClass ALWAYS_RETRIEVE_STRATEGY = eINSTANCE.getAlwaysRetrieveStrategy();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveOrCreateStrategyImpl <em>Always Retrieve Or Create Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysRetrieveOrCreateStrategyImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getAlwaysRetrieveOrCreateStrategy()
		 * @generated
		 */
		EClass ALWAYS_RETRIEVE_OR_CREATE_STRATEGY = eINSTANCE.getAlwaysRetrieveOrCreateStrategy();

		/**
		 * The meta object literal for the '<em><b>Retriver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER = eINSTANCE.getAlwaysRetrieveOrCreateStrategy_Retriver();

		/**
		 * The meta object literal for the '<em><b>Creator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR = eINSTANCE.getAlwaysRetrieveOrCreateStrategy_Creator();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.EolGeneratorImpl <em>Eol Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.EolGeneratorImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getEolGenerator()
		 * @generated
		 */
		EClass EOL_GENERATOR = eINSTANCE.getEolGenerator();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOL_GENERATOR__LOCATION = eINSTANCE.getEolGenerator_Location();

		/**
		 * The meta object literal for the '{@link uk.ac.york.cs.mv525.modelgen.config.config.impl.CombinedGeneratorImpl <em>Combined Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.CombinedGeneratorImpl
		 * @see uk.ac.york.cs.mv525.modelgen.config.config.impl.ConfigPackageImpl#getCombinedGenerator()
		 * @generated
		 */
		EClass COMBINED_GENERATOR = eINSTANCE.getCombinedGenerator();

		/**
		 * The meta object literal for the '<em><b>Fallback</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMBINED_GENERATOR__FALLBACK = eINSTANCE.getCombinedGenerator_Fallback();

		/**
		 * The meta object literal for the '<em><b>Generators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMBINED_GENERATOR__GENERATORS = eINSTANCE.getCombinedGenerator_Generators();

	}

} //ConfigPackage
