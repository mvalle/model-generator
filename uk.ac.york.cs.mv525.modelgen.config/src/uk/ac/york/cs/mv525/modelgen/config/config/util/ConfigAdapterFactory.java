/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uk.ac.york.cs.mv525.modelgen.config.config.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import uk.ac.york.cs.mv525.modelgen.config.config.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage
 * @generated
 */
public class ConfigAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConfigPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigSwitch<Adapter> modelSwitch =
		new ConfigSwitch<Adapter>() {
			@Override
			public Adapter caseModelElementOverride(ModelElementOverride object) {
				return createModelElementOverrideAdapter();
			}
			@Override
			public Adapter caseModelConfiguration(ModelConfiguration object) {
				return createModelConfigurationAdapter();
			}
			@Override
			public Adapter caseModelElementExclusion(ModelElementExclusion object) {
				return createModelElementExclusionAdapter();
			}
			@Override
			public Adapter caseStringPool(StringPool object) {
				return createStringPoolAdapter();
			}
			@Override
			public Adapter caseFileStringPool(FileStringPool object) {
				return createFileStringPoolAdapter();
			}
			@Override
			public Adapter caseEmbeddedStringPool(EmbeddedStringPool object) {
				return createEmbeddedStringPoolAdapter();
			}
			@Override
			public Adapter caseStringPoolEntry(StringPoolEntry object) {
				return createStringPoolEntryAdapter();
			}
			@Override
			public Adapter caseReferenceOverride(ReferenceOverride object) {
				return createReferenceOverrideAdapter();
			}
			@Override
			public Adapter caseModelGeneration(ModelGeneration object) {
				return createModelGenerationAdapter();
			}
			@Override
			public Adapter caseGenerator(Generator object) {
				return createGeneratorAdapter();
			}
			@Override
			public Adapter caseEolGenerator(EolGenerator object) {
				return createEolGeneratorAdapter();
			}
			@Override
			public Adapter caseRandomGenerator(RandomGenerator object) {
				return createRandomGeneratorAdapter();
			}
			@Override
			public Adapter caseStrategy(Strategy object) {
				return createStrategyAdapter();
			}
			@Override
			public Adapter caseAlwaysCreateStrategy(AlwaysCreateStrategy object) {
				return createAlwaysCreateStrategyAdapter();
			}
			@Override
			public Adapter caseAlwaysRetrieveStrategy(AlwaysRetrieveStrategy object) {
				return createAlwaysRetrieveStrategyAdapter();
			}
			@Override
			public Adapter caseAlwaysRetrieveOrCreateStrategy(AlwaysRetrieveOrCreateStrategy object) {
				return createAlwaysRetrieveOrCreateStrategyAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride <em>Model Element Override</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride
	 * @generated
	 */
	public Adapter createModelElementOverrideAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration <em>Model Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration
	 * @generated
	 */
	public Adapter createModelConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion <em>Model Element Exclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion
	 * @generated
	 */
	public Adapter createModelElementExclusionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.StringPool <em>String Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.StringPool
	 * @generated
	 */
	public Adapter createStringPoolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.FileStringPool <em>File String Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.FileStringPool
	 * @generated
	 */
	public Adapter createFileStringPoolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool <em>Embedded String Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool
	 * @generated
	 */
	public Adapter createEmbeddedStringPoolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry <em>String Pool Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry
	 * @generated
	 */
	public Adapter createStringPoolEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride <em>Reference Override</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride
	 * @generated
	 */
	public Adapter createReferenceOverrideAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration <em>Model Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration
	 * @generated
	 */
	public Adapter createModelGenerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.Generator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.Generator
	 * @generated
	 */
	public Adapter createGeneratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator <em>Eol Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator
	 * @generated
	 */
	public Adapter createEolGeneratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator <em>Random Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator
	 * @generated
	 */
	public Adapter createRandomGeneratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.Strategy
	 * @generated
	 */
	public Adapter createStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy <em>Always Create Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy
	 * @generated
	 */
	public Adapter createAlwaysCreateStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveStrategy <em>Always Retrieve Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveStrategy
	 * @generated
	 */
	public Adapter createAlwaysRetrieveStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy <em>Always Retrieve Or Create Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy
	 * @generated
	 */
	public Adapter createAlwaysRetrieveOrCreateStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ConfigAdapterFactory
