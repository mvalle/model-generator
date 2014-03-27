/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package uk.ac.york.cs.mv525.modelgen.config.config.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import uk.ac.york.cs.mv525.modelgen.config.config.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage
 * @generated
 */
public class ConfigSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigSwitch() {
		if (modelPackage == null) {
			modelPackage = ConfigPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ConfigPackage.MODEL_ELEMENT_OVERRIDE: {
				ModelElementOverride modelElementOverride = (ModelElementOverride)theEObject;
				T result = caseModelElementOverride(modelElementOverride);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.MODEL_CONFIGURATION: {
				ModelConfiguration modelConfiguration = (ModelConfiguration)theEObject;
				T result = caseModelConfiguration(modelConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.MODEL_ELEMENT_EXCLUSION: {
				ModelElementExclusion modelElementExclusion = (ModelElementExclusion)theEObject;
				T result = caseModelElementExclusion(modelElementExclusion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.STRING_POOL: {
				StringPool stringPool = (StringPool)theEObject;
				T result = caseStringPool(stringPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.FILE_STRING_POOL: {
				FileStringPool fileStringPool = (FileStringPool)theEObject;
				T result = caseFileStringPool(fileStringPool);
				if (result == null) result = caseStringPool(fileStringPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EMBEDDED_STRING_POOL: {
				EmbeddedStringPool embeddedStringPool = (EmbeddedStringPool)theEObject;
				T result = caseEmbeddedStringPool(embeddedStringPool);
				if (result == null) result = caseStringPool(embeddedStringPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.STRING_POOL_ENTRY: {
				StringPoolEntry stringPoolEntry = (StringPoolEntry)theEObject;
				T result = caseStringPoolEntry(stringPoolEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.REFERENCE_OVERRIDE: {
				ReferenceOverride referenceOverride = (ReferenceOverride)theEObject;
				T result = caseReferenceOverride(referenceOverride);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.MODEL_GENERATION: {
				ModelGeneration modelGeneration = (ModelGeneration)theEObject;
				T result = caseModelGeneration(modelGeneration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.GENERATOR: {
				Generator generator = (Generator)theEObject;
				T result = caseGenerator(generator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.EOL_GENERATOR: {
				EolGenerator eolGenerator = (EolGenerator)theEObject;
				T result = caseEolGenerator(eolGenerator);
				if (result == null) result = caseGenerator(eolGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.RANDOM_GENERATOR: {
				RandomGenerator randomGenerator = (RandomGenerator)theEObject;
				T result = caseRandomGenerator(randomGenerator);
				if (result == null) result = caseGenerator(randomGenerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.STRATEGY: {
				Strategy strategy = (Strategy)theEObject;
				T result = caseStrategy(strategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ALWAYS_CREATE_STRATEGY: {
				AlwaysCreateStrategy alwaysCreateStrategy = (AlwaysCreateStrategy)theEObject;
				T result = caseAlwaysCreateStrategy(alwaysCreateStrategy);
				if (result == null) result = caseStrategy(alwaysCreateStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ALWAYS_RETRIEVE_STRATEGY: {
				AlwaysRetrieveStrategy alwaysRetrieveStrategy = (AlwaysRetrieveStrategy)theEObject;
				T result = caseAlwaysRetrieveStrategy(alwaysRetrieveStrategy);
				if (result == null) result = caseStrategy(alwaysRetrieveStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ALWAYS_RETRIEVE_OR_CREATE_STRATEGY: {
				AlwaysRetrieveOrCreateStrategy alwaysRetrieveOrCreateStrategy = (AlwaysRetrieveOrCreateStrategy)theEObject;
				T result = caseAlwaysRetrieveOrCreateStrategy(alwaysRetrieveOrCreateStrategy);
				if (result == null) result = caseStrategy(alwaysRetrieveOrCreateStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element Override</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element Override</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementOverride(ModelElementOverride object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelConfiguration(ModelConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element Exclusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementExclusion(ModelElementExclusion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringPool(StringPool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File String Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File String Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileStringPool(FileStringPool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Embedded String Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Embedded String Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmbeddedStringPool(EmbeddedStringPool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Pool Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Pool Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringPoolEntry(StringPoolEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Override</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Override</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceOverride(ReferenceOverride object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Generation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Generation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelGeneration(ModelGeneration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenerator(Generator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eol Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eol Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEolGenerator(EolGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomGenerator(RandomGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrategy(Strategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Always Create Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Always Create Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlwaysCreateStrategy(AlwaysCreateStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Always Retrieve Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Always Retrieve Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlwaysRetrieveStrategy(AlwaysRetrieveStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Always Retrieve Or Create Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Always Retrieve Or Create Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlwaysRetrieveOrCreateStrategy(AlwaysRetrieveOrCreateStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ConfigSwitch
