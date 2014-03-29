package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysCreateStrategyImpl;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.RandomGeneratorImpl;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen.test.FileTester;

public class RandomGeneratorTester extends FileTester {

	MetaModelIndex index;
	ModelInstance model;
	
	@Before
	public void setUp() throws Exception {
		
		location = dataDir + "orgchart.ecore";

		index = MetaModelParser.parse(location);
		
		model = new ModelInstance(dataDir + "output.model");
		
	}
	
	@Test
	public void test_create_class() {
		
		RandomGenerator rg  = new RandomGeneratorImpl(model, index);
		EObject randObj = rg.create((EClass) index.get("Person"));
		
		assertNotNull(randObj);
	}
	
	@Test
	public void test_create_attribute() {
		
		RandomGenerator rg  = new RandomGeneratorImpl(model, index);
		EClass mClass = (EClass) index.get("Person");
		EStructuralFeature mName = mClass.getEStructuralFeature("name");
		
		EObject person = rg.create(mClass);
		Object name = rg.add(person, mName);		
		assertNotNull(name);
		
		Object actual = person.eGet(mName);		
		assertSame(name, actual);
	}
	
	@Test
	public void test_link() {
		RandomGenerator rg  = new RandomGeneratorImpl(model, index);
		rg.setStrategy(new AlwaysCreateStrategyImpl(rg));
		EClass mClass = (EClass) index.get("Person");
		EStructuralFeature mManages = mClass.getEStructuralFeature("manages");
		
		EObject person = rg.create(mClass);
		Object manager = rg.link(person, (EReference) mManages);		
		assertNotNull(manager);
		
		Object actual = person.eGet(mManages);		
		assertSame(manager, actual);
	}

}




















