package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.generate.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen.strategy.AlwaysCreate;

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
		
		RandomGenerator rg  = new RandomGenerator(model, index);
		EObject randObj = rg.create((EClass) index.get("Person"));
		
		assertNotNull(randObj);
	}
	
	@Test
	public void test_create_attribute() {
		
		RandomGenerator rg  = new RandomGenerator(model, index);
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
		RandomGenerator rg  = new RandomGenerator(model, index);
		rg.setStrategy(new AlwaysCreate(rg));
		EClass mClass = (EClass) index.get("Person");
		EStructuralFeature mManages = mClass.getEStructuralFeature("manages");
		
		EObject person = rg.create(mClass);
		Object manager = rg.link(person, (EReference) mManages);		
		assertNotNull(manager);
		
		Object actual = person.eGet(mManages);		
		assertSame(manager, actual);
	}

}




















