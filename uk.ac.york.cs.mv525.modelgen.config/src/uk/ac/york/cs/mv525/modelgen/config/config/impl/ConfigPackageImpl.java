/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy;
import uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy;
import uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveStrategy;
import uk.ac.york.cs.mv525.modelgen.config.config.CombinedProducer;
import uk.ac.york.cs.mv525.modelgen.config.config.ConfigFactory;
import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.EolProducer;
import uk.ac.york.cs.mv525.modelgen.config.config.FileStringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.Producer;
import uk.ac.york.cs.mv525.modelgen.config.config.RandomProducer;
import uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.Strategy;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigPackageImpl extends EPackageImpl implements ConfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementOverrideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementExclusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringPoolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileStringPoolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass embeddedStringPoolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringPoolEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceOverrideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass producerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomProducerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alwaysCreateStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alwaysRetrieveStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alwaysRetrieveOrCreateStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eolProducerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass combinedProducerEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConfigPackageImpl() {
		super(eNS_URI, ConfigFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ConfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConfigPackage init() {
		if (isInited) return (ConfigPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigPackage.eNS_URI);

		// Obtain or create and register package
		ConfigPackageImpl theConfigPackage = (ConfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConfigPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theConfigPackage.createPackageContents();

		// Initialize created meta-data
		theConfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConfigPackage.eNS_URI, theConfigPackage);
		return theConfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementOverride() {
		return modelElementOverrideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElementOverride_MinimumCount() {
		return (EAttribute)modelElementOverrideEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElementOverride_Name() {
		return (EAttribute)modelElementOverrideEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementOverride_StringPools() {
		return (EReference)modelElementOverrideEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementOverride_References() {
		return (EReference)modelElementOverrideEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelConfiguration() {
		return modelConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelConfiguration_ModelElementOverrides() {
		return (EReference)modelConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelConfiguration_Deterministic() {
		return (EAttribute)modelConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelConfiguration_TotalMinimumCount() {
		return (EAttribute)modelConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelConfiguration_ModelElemetExclusions() {
		return (EReference)modelConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelConfiguration_DefaultStringPool() {
		return (EReference)modelConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelConfiguration_Producer() {
		return (EReference)modelConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementExclusion() {
		return modelElementExclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElementExclusion_Name() {
		return (EAttribute)modelElementExclusionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringPool() {
		return stringPoolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringPool_Name() {
		return (EAttribute)stringPoolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileStringPool() {
		return fileStringPoolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileStringPool_Location() {
		return (EAttribute)fileStringPoolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmbeddedStringPool() {
		return embeddedStringPoolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmbeddedStringPool_Entries() {
		return (EReference)embeddedStringPoolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringPoolEntry() {
		return stringPoolEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringPoolEntry_String() {
		return (EAttribute)stringPoolEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceOverride() {
		return referenceOverrideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceOverride_Name() {
		return (EAttribute)referenceOverrideEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceOverride_MinimumCount() {
		return (EAttribute)referenceOverrideEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceOverride_MaximumCount() {
		return (EAttribute)referenceOverrideEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProducer() {
		return producerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProducer_Strategy() {
		return (EReference)producerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomProducer() {
		return randomProducerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrategy() {
		return strategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlwaysCreateStrategy() {
		return alwaysCreateStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlwaysCreateStrategy_Generator() {
		return (EReference)alwaysCreateStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlwaysRetrieveStrategy() {
		return alwaysRetrieveStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlwaysRetrieveOrCreateStrategy() {
		return alwaysRetrieveOrCreateStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlwaysRetrieveOrCreateStrategy_Retriver() {
		return (EReference)alwaysRetrieveOrCreateStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlwaysRetrieveOrCreateStrategy_Creator() {
		return (EReference)alwaysRetrieveOrCreateStrategyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEolProducer() {
		return eolProducerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEolProducer_Location() {
		return (EAttribute)eolProducerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCombinedProducer() {
		return combinedProducerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombinedProducer_Fallback() {
		return (EReference)combinedProducerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombinedProducer_Producers() {
		return (EReference)combinedProducerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigFactory getConfigFactory() {
		return (ConfigFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modelElementOverrideEClass = createEClass(MODEL_ELEMENT_OVERRIDE);
		createEAttribute(modelElementOverrideEClass, MODEL_ELEMENT_OVERRIDE__MINIMUM_COUNT);
		createEAttribute(modelElementOverrideEClass, MODEL_ELEMENT_OVERRIDE__NAME);
		createEReference(modelElementOverrideEClass, MODEL_ELEMENT_OVERRIDE__STRING_POOLS);
		createEReference(modelElementOverrideEClass, MODEL_ELEMENT_OVERRIDE__REFERENCES);

		modelConfigurationEClass = createEClass(MODEL_CONFIGURATION);
		createEReference(modelConfigurationEClass, MODEL_CONFIGURATION__MODEL_ELEMENT_OVERRIDES);
		createEAttribute(modelConfigurationEClass, MODEL_CONFIGURATION__DETERMINISTIC);
		createEAttribute(modelConfigurationEClass, MODEL_CONFIGURATION__TOTAL_MINIMUM_COUNT);
		createEReference(modelConfigurationEClass, MODEL_CONFIGURATION__MODEL_ELEMET_EXCLUSIONS);
		createEReference(modelConfigurationEClass, MODEL_CONFIGURATION__DEFAULT_STRING_POOL);
		createEReference(modelConfigurationEClass, MODEL_CONFIGURATION__PRODUCER);

		modelElementExclusionEClass = createEClass(MODEL_ELEMENT_EXCLUSION);
		createEAttribute(modelElementExclusionEClass, MODEL_ELEMENT_EXCLUSION__NAME);

		stringPoolEClass = createEClass(STRING_POOL);
		createEAttribute(stringPoolEClass, STRING_POOL__NAME);

		fileStringPoolEClass = createEClass(FILE_STRING_POOL);
		createEAttribute(fileStringPoolEClass, FILE_STRING_POOL__LOCATION);

		embeddedStringPoolEClass = createEClass(EMBEDDED_STRING_POOL);
		createEReference(embeddedStringPoolEClass, EMBEDDED_STRING_POOL__ENTRIES);

		stringPoolEntryEClass = createEClass(STRING_POOL_ENTRY);
		createEAttribute(stringPoolEntryEClass, STRING_POOL_ENTRY__STRING);

		referenceOverrideEClass = createEClass(REFERENCE_OVERRIDE);
		createEAttribute(referenceOverrideEClass, REFERENCE_OVERRIDE__NAME);
		createEAttribute(referenceOverrideEClass, REFERENCE_OVERRIDE__MINIMUM_COUNT);
		createEAttribute(referenceOverrideEClass, REFERENCE_OVERRIDE__MAXIMUM_COUNT);

		producerEClass = createEClass(PRODUCER);
		createEReference(producerEClass, PRODUCER__STRATEGY);

		randomProducerEClass = createEClass(RANDOM_PRODUCER);

		strategyEClass = createEClass(STRATEGY);

		alwaysCreateStrategyEClass = createEClass(ALWAYS_CREATE_STRATEGY);
		createEReference(alwaysCreateStrategyEClass, ALWAYS_CREATE_STRATEGY__GENERATOR);

		alwaysRetrieveStrategyEClass = createEClass(ALWAYS_RETRIEVE_STRATEGY);

		alwaysRetrieveOrCreateStrategyEClass = createEClass(ALWAYS_RETRIEVE_OR_CREATE_STRATEGY);
		createEReference(alwaysRetrieveOrCreateStrategyEClass, ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__RETRIVER);
		createEReference(alwaysRetrieveOrCreateStrategyEClass, ALWAYS_RETRIEVE_OR_CREATE_STRATEGY__CREATOR);

		eolProducerEClass = createEClass(EOL_PRODUCER);
		createEAttribute(eolProducerEClass, EOL_PRODUCER__LOCATION);

		combinedProducerEClass = createEClass(COMBINED_PRODUCER);
		createEReference(combinedProducerEClass, COMBINED_PRODUCER__FALLBACK);
		createEReference(combinedProducerEClass, COMBINED_PRODUCER__PRODUCERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fileStringPoolEClass.getESuperTypes().add(this.getStringPool());
		embeddedStringPoolEClass.getESuperTypes().add(this.getStringPool());
		randomProducerEClass.getESuperTypes().add(this.getProducer());
		alwaysCreateStrategyEClass.getESuperTypes().add(this.getStrategy());
		alwaysRetrieveStrategyEClass.getESuperTypes().add(this.getStrategy());
		alwaysRetrieveOrCreateStrategyEClass.getESuperTypes().add(this.getStrategy());
		eolProducerEClass.getESuperTypes().add(this.getProducer());
		combinedProducerEClass.getESuperTypes().add(this.getProducer());

		// Initialize classes and features; add operations and parameters
		initEClass(modelElementOverrideEClass, ModelElementOverride.class, "ModelElementOverride", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElementOverride_MinimumCount(), ecorePackage.getELong(), "MinimumCount", null, 0, 1, ModelElementOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElementOverride_Name(), ecorePackage.getEString(), "Name", null, 0, 1, ModelElementOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElementOverride_StringPools(), this.getStringPool(), null, "StringPools", null, 0, -1, ModelElementOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElementOverride_References(), this.getReferenceOverride(), null, "References", null, 0, -1, ModelElementOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelConfigurationEClass, ModelConfiguration.class, "ModelConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelConfiguration_ModelElementOverrides(), this.getModelElementOverride(), null, "ModelElementOverrides", null, 0, -1, ModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelConfiguration_Deterministic(), ecorePackage.getEBoolean(), "Deterministic", null, 0, 1, ModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelConfiguration_TotalMinimumCount(), ecorePackage.getELong(), "TotalMinimumCount", null, 0, 1, ModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelConfiguration_ModelElemetExclusions(), this.getModelElementExclusion(), null, "ModelElemetExclusions", null, 0, -1, ModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelConfiguration_DefaultStringPool(), this.getStringPool(), null, "DefaultStringPool", null, 0, 1, ModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelConfiguration_Producer(), this.getProducer(), null, "Producer", null, 0, 1, ModelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementExclusionEClass, ModelElementExclusion.class, "ModelElementExclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElementExclusion_Name(), ecorePackage.getEString(), "Name", null, 0, 1, ModelElementExclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringPoolEClass, StringPool.class, "StringPool", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringPool_Name(), ecorePackage.getEString(), "Name", null, 1, 1, StringPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileStringPoolEClass, FileStringPool.class, "FileStringPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileStringPool_Location(), ecorePackage.getEString(), "location", null, 0, 1, FileStringPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(embeddedStringPoolEClass, EmbeddedStringPool.class, "EmbeddedStringPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEmbeddedStringPool_Entries(), this.getStringPoolEntry(), null, "Entries", null, 1, -1, EmbeddedStringPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringPoolEntryEClass, StringPoolEntry.class, "StringPoolEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringPoolEntry_String(), ecorePackage.getEString(), "string", null, 1, 1, StringPoolEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceOverrideEClass, ReferenceOverride.class, "ReferenceOverride", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceOverride_Name(), ecorePackage.getEString(), "Name", null, 0, 1, ReferenceOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceOverride_MinimumCount(), ecorePackage.getELong(), "MinimumCount", null, 0, 1, ReferenceOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceOverride_MaximumCount(), ecorePackage.getELong(), "MaximumCount", null, 0, 1, ReferenceOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(producerEClass, Producer.class, "Producer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProducer_Strategy(), this.getStrategy(), null, "strategy", null, 1, 1, Producer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomProducerEClass, RandomProducer.class, "RandomProducer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strategyEClass, Strategy.class, "Strategy", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alwaysCreateStrategyEClass, AlwaysCreateStrategy.class, "AlwaysCreateStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlwaysCreateStrategy_Generator(), this.getProducer(), null, "generator", null, 1, 1, AlwaysCreateStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alwaysRetrieveStrategyEClass, AlwaysRetrieveStrategy.class, "AlwaysRetrieveStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alwaysRetrieveOrCreateStrategyEClass, AlwaysRetrieveOrCreateStrategy.class, "AlwaysRetrieveOrCreateStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlwaysRetrieveOrCreateStrategy_Retriver(), this.getAlwaysRetrieveStrategy(), null, "retriver", null, 1, 1, AlwaysRetrieveOrCreateStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlwaysRetrieveOrCreateStrategy_Creator(), this.getAlwaysCreateStrategy(), null, "creator", null, 1, 1, AlwaysRetrieveOrCreateStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eolProducerEClass, EolProducer.class, "EolProducer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEolProducer_Location(), ecorePackage.getEString(), "location", null, 0, 1, EolProducer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(combinedProducerEClass, CombinedProducer.class, "CombinedProducer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCombinedProducer_Fallback(), this.getProducer(), null, "fallback", null, 1, 1, CombinedProducer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCombinedProducer_Producers(), this.getProducer(), null, "producers", null, 0, -1, CombinedProducer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ConfigPackageImpl
