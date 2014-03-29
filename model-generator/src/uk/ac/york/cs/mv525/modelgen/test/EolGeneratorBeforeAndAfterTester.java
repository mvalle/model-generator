package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy;
import uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator;
import uk.ac.york.cs.mv525.modelgen.config.config.Generator;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration;
import uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen.config.config.Strategy;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysCreateStrategyImpl;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.EolGeneratorImpl;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelGenerationImpl;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.RandomGeneratorImpl;
import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.orchestration.DefaultOrchastration;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;

public class EolGeneratorBeforeAndAfterTester extends FileTester {

	MetaModelIndex mIndex;
	ModelInstance model;
	

	String configLocation = dataDir + "test.config";
	
	@Before
	public void setUp() throws Exception {
		location = dataDir + "test_before.eol";
		mIndex = MetaModelParser.parse(dataDir+"orgchart.ecore");
		
		model = new ModelInstance(dataDir+"test.model");
	}
	
	@After
	public void teadDown() {
		File f = new File(dataDir+"test.model");
		if (f.exists()) {
			f.delete();
		}
	}

	@Test
	public void test_parse_Before() throws IOException {
		location = dataDir + "test_before.eol";
		
		EolGenerator eg  = new EolGeneratorImpl(location, model, mIndex);
		eg.setStrategy(new AlwaysCreateStrategyImpl(eg));
		assertTrue(eg.before());
	}
	
	@Test
	public void test_parse_After() throws IOException {
		location = dataDir + "test_after.eol";
		
		EolGenerator eg  = new EolGeneratorImpl(location, model, mIndex);
		eg.setStrategy(new AlwaysCreateStrategyImpl(eg));
		assertTrue(eg.after());
	}

	@Test
	public void test_Before() throws IOException {
		location = dataDir + "test_before.eol";

		Configuration cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mIndex);

		RandomGenerator rand = new RandomGeneratorImpl(model, mIndex);
		AlwaysCreateStrategyImpl a = new AlwaysCreateStrategyImpl(rand);
		rand.setStrategy(a);
		
		EolGenerator eg  = new EolGeneratorImpl(location, model, mIndex);
		AlwaysCreateStrategyImpl b =new AlwaysCreateStrategyImpl(eg);		
		eg.setStrategy(b);
		
		ModelGeneration generator = new ModelGenerationImpl(rand);
		generator.addGenerator(eg);
		

		DefaultOrchastration defaultOrchastration = new DefaultOrchastration();
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addGenerator(generator);
		defaultOrchastration.addModel(model);		
		

		defaultOrchastration.create();

		EClass mClass = (EClass) mIndex.get("Person");
		EStructuralFeature mName = mClass.getEStructuralFeature("name");
				
		for(EObject p : model.getObjects("Person")) {
			String f = (String) p.eGet(mName);
			assertEquals(f, "Called from Before operation");
		}
	}
	
	@Test
	public void test_After() throws IOException {
		location = dataDir + "test_after.eol";

		Configuration cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mIndex);

		RandomGenerator rand = new RandomGeneratorImpl(model, mIndex);
		rand.setStrategy(new AlwaysCreateStrategyImpl(rand));
		EolGenerator eg  = new EolGeneratorImpl(location, model, mIndex);
		eg.setStrategy(new AlwaysCreateStrategyImpl(eg));

		ModelGeneration generator = new ModelGenerationImpl(rand);
		generator.addGenerator(eg);
		

		DefaultOrchastration defaultOrchastration = new DefaultOrchastration();
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addGenerator(generator);
		defaultOrchastration.addModel(model);		

		defaultOrchastration.create();

		EClass mClass = (EClass) mIndex.get("Person");
		EStructuralFeature mName = mClass.getEStructuralFeature("name");
		
		for(EObject p : model.getObjects("Person")) {
			String f = (String) p.eGet(mName);
			assertEquals(f, "Called from After operation");
		}
	}

}
