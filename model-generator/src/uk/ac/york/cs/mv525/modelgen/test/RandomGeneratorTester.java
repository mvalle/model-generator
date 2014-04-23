package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen.producer.RandomProducer;
import uk.ac.york.cs.mv525.modelgen.strategy.AlwaysCreate;
import uk.ac.york.cs.mv525.modelgen.test.FileTester;

public class RandomGeneratorTester extends FileTester {

	MetaModelIndex index;
	ModelInstance model;

	Configuration cIndex;
	String configLocation = dataDir + "test.config";
	
	@Before
	public void setUp() throws Exception {
		
		location = mmDir + "orgchart.ecore";

		index = MetaModelParser.parse(location);
		
		model = new ModelInstance(dataDir + "output.model");

		cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(index);
	}
	
	@Test
	public void test_create_class() {
		
		RandomProducer rg  = new RandomProducer(model, index, cIndex);
		EObject randObj = rg.create((EClass) index.get("Person"));
		
		assertNotNull(randObj);
	}
	
	@Test
	public void test_create_attribute() {
		
		RandomProducer rg  = new RandomProducer(model, index, cIndex);
		EClass mClass = (EClass) index.get("Person");
		EStructuralFeature mName = mClass.getEStructuralFeature("name");
		
		EObject person = rg.create(mClass);
		Object name = rg.add(person, (EAttribute)mName);		
		assertNotNull(name);
		
		Object actual = person.eGet(mName);		
		assertSame(name, actual);
	}
	
	@Test
	public void test_link() {
		RandomProducer rg  = new RandomProducer(model, index, cIndex);
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




















