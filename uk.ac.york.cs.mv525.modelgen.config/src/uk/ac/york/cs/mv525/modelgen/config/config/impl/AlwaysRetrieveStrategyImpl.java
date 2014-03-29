/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.impl;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveStrategy;
import uk.ac.york.cs.mv525.modelgen.config.config.ConfigPackage;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Always Retrieve Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AlwaysRetrieveStrategyImpl extends EObjectImpl implements AlwaysRetrieveStrategy {
	
	private ModelInstance model;
	HashMap<String, Integer> state = new HashMap<>();
	
	public AlwaysRetrieveStrategyImpl(ModelInstance m) {
		model = m;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlwaysRetrieveStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.ALWAYS_RETRIEVE_STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject retrieveObject(EClass mType) {
		Integer i = state.get(mType.getName());
		if(i == null) {
			i = Integer.valueOf(0);
			state.put(mType.getName(), i);
		}
		List<EObject> os = model.getObjects(mType.getName());
		
		return os.get(i++%os.size());
	}

} //AlwaysRetrieveStrategyImpl
