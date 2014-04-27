/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy;
import uk.ac.york.cs.mv525.modelgen.config.config.ConfigFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Always Create Strategy</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlwaysCreateStrategyTest extends TestCase {

	/**
	 * The fixture for this Always Create Strategy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlwaysCreateStrategy fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AlwaysCreateStrategyTest.class);
	}

	/**
	 * Constructs a new Always Create Strategy test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysCreateStrategyTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Always Create Strategy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AlwaysCreateStrategy fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Always Create Strategy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlwaysCreateStrategy getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigFactory.eINSTANCE.createAlwaysCreateStrategy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //AlwaysCreateStrategyTest
