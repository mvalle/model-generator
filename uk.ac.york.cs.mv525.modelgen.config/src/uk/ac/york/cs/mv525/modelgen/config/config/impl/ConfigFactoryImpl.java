/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uk.ac.york.cs.mv525.modelgen.config.config.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigFactoryImpl extends EFactoryImpl implements ConfigFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfigFactory init() {
		try {
			ConfigFactory theConfigFactory = (ConfigFactory)EPackage.Registry.INSTANCE.getEFactory("http://config/1.0"); 
			if (theConfigFactory != null) {
				return theConfigFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConfigFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE: return createModelElementOverride();
			case ConfigPackage.MODEL_CONFIGURATION: return createModelConfiguration();
			case ConfigPackage.MODEL_ELEMENT_EXCLUSION: return createModelElementExclusion();
			case ConfigPackage.FILE_STRING_POOL: return createFileStringPool();
			case ConfigPackage.EMBEDDED_STRING_POOL: return createEmbeddedStringPool();
			case ConfigPackage.STRING_POOL_ENTRY: return createStringPoolEntry();
			case ConfigPackage.REFERENCE_OVERRIDE: return createReferenceOverride();
			case ConfigPackage.MODEL_GENERATION: return createModelGeneration();
			case ConfigPackage.RANDOM_GENERATOR: return createRandomGenerator();
			case ConfigPackage.ALWAYS_CREATE_STRATEGY: return createAlwaysCreateStrategy();
			case ConfigPackage.ALWAYS_RETRIEVE_STRATEGY: return createAlwaysRetrieveStrategy();
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY: return createAlwaysRetrieveOrCreateStrategy();
			case ConfigPackage.EOL_GENERATOR: return createEolGenerator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementOverride createModelElementOverride() {
		ModelElementOverrideImpl modelElementOverride = new ModelElementOverrideImpl();
		return modelElementOverride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelConfiguration createModelConfiguration() {
		ModelConfigurationImpl modelConfiguration = new ModelConfigurationImpl();
		return modelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementExclusion createModelElementExclusion() {
		ModelElementExclusionImpl modelElementExclusion = new ModelElementExclusionImpl();
		return modelElementExclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileStringPool createFileStringPool() {
		FileStringPoolImpl fileStringPool = new FileStringPoolImpl();
		return fileStringPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbeddedStringPool createEmbeddedStringPool() {
		EmbeddedStringPoolImpl embeddedStringPool = new EmbeddedStringPoolImpl();
		return embeddedStringPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringPoolEntry createStringPoolEntry() {
		StringPoolEntryImpl stringPoolEntry = new StringPoolEntryImpl();
		return stringPoolEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceOverride createReferenceOverride() {
		ReferenceOverrideImpl referenceOverride = new ReferenceOverrideImpl();
		return referenceOverride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelGeneration createModelGeneration() {
		ModelGenerationImpl modelGeneration = new ModelGenerationImpl();
		return modelGeneration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomGenerator createRandomGenerator() {
		RandomGeneratorImpl randomGenerator = new RandomGeneratorImpl();
		return randomGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysCreateStrategy createAlwaysCreateStrategy() {
		AlwaysCreateStrategyImpl alwaysCreateStrategy = new AlwaysCreateStrategyImpl();
		return alwaysCreateStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysRetrieveStrategy createAlwaysRetrieveStrategy() {
		AlwaysRetrieveStrategyImpl alwaysRetrieveStrategy = new AlwaysRetrieveStrategyImpl();
		return alwaysRetrieveStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysRetrieveOrCreateStrategy createAlwaysRetrieveOrCreateStrategy() {
		AlwaysRetrieveOrCreateStrategyImpl alwaysRetrieveOrCreateStrategy = new AlwaysRetrieveOrCreateStrategyImpl();
		return alwaysRetrieveOrCreateStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EolGenerator createEolGenerator() {
		EolGeneratorImpl eolGenerator = new EolGeneratorImpl();
		return eolGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigPackage getConfigPackage() {
		return (ConfigPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConfigPackage getPackage() {
		return ConfigPackage.eINSTANCE;
	}

} //ConfigFactoryImpl
