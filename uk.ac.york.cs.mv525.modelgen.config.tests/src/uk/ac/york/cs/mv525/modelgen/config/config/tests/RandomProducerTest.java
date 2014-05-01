/**
 */
package uk.ac.york.cs.mv525.modelgen.config.config.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import uk.ac.york.cs.mv525.modelgen.config.config.ConfigFactory;
import uk.ac.york.cs.mv525.modelgen.config.config.RandomProducer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Random Producer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RandomProducerTest extends TestCase {

	/**
	 * The fixture for this Random Producer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomProducer fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RandomProducerTest.class);
	}

	/**
	 * Constructs a new Random Producer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomProducerTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Random Producer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RandomProducer fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Random Producer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomProducer getFixture() {
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
		setFixture(ConfigFactory.eINSTANCE.createRandomProducer());
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

} //RandomProducerTest
