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

import uk.ac.york.cs.mv525.modelgen.ModelGenerator;
import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen.producer.CombinedProducer;
import uk.ac.york.cs.mv525.modelgen.producer.EolProducer;
import uk.ac.york.cs.mv525.modelgen.producer.RandomProducer;
import uk.ac.york.cs.mv525.modelgen.strategy.AlwaysCreate;

public class EolGeneratorBeforeAndAfterTester extends FileTester {

	MetaModelIndex mIndex;
	ModelInstance model;
	

	String configLocation = dataDir + "test.config";
	String metaModelLocation = mmDir+"orgchart.ecore";
	
	@Before
	public void setUp() throws Exception {
		location = dataDir + "test_before.eol";
		mIndex = MetaModelParser.parse(mmDir+"orgchart.ecore");
		
		model = new ModelInstance(dataDir+"test.model");
	}
	
	@After
	public void teadDown() throws IOException {
		File f = new File(dataDir+"test.model");
		if (f.exists()) {
			MetaModelIndex mmIndex = MetaModelParser.parse(metaModelLocation);
			
			Configuration cIndex = ConfigParser.parse(configLocation);
			cIndex.setMetaModel(mmIndex);
			
			f.delete();
		}
	}

	@Test
	public void test_parse_Before() throws IOException {
		location = dataDir + "test_before.eol";

		Configuration cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mIndex);
		
		EolProducer eg  = new EolProducer(location, model, cIndex);
		eg.setStrategy(new AlwaysCreate(eg));
		assertTrue(eg.before());
	}
	
	@Test
	public void test_parse_After() throws IOException {
		location = dataDir + "test_after.eol";

		Configuration cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mIndex);
		
		EolProducer eg  = new EolProducer(location, model, cIndex);
		eg.setStrategy(new AlwaysCreate(eg));
		assertTrue(eg.after());
	}

	@Test
	public void test_Before() throws IOException {
		location = dataDir + "test_before.eol";

		Configuration cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mIndex);

		RandomProducer rand = new RandomProducer(model, mIndex, cIndex);
		AlwaysCreate a = new AlwaysCreate(rand);
		rand.setStrategy(a);
		
		EolProducer eg = new EolProducer(location, model, cIndex);
		AlwaysCreate b = new AlwaysCreate(eg);		
		eg.setStrategy(b);
		
		CombinedProducer generator = new CombinedProducer(rand);
		generator.addProducer(eg);
		

		ModelGenerator defaultOrchastration = new ModelGenerator(model);
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addProducer(generator);

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

		RandomProducer rand = new RandomProducer(model, mIndex, cIndex);
		rand.setStrategy(new AlwaysCreate(rand));
		EolProducer eg  = new EolProducer(location, model, cIndex);
		eg.setStrategy(new AlwaysCreate(eg));

		CombinedProducer generator = new CombinedProducer(rand);
		generator.addProducer(eg);
		

		ModelGenerator defaultOrchastration = new ModelGenerator(model);
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addProducer(generator);

		defaultOrchastration.create();

		EClass mClass = (EClass) mIndex.get("Person");
		EStructuralFeature mName = mClass.getEStructuralFeature("name");
		for(EObject p : model.getObjects("Person")) {
			String f = (String) p.eGet(mName);
			System.out.println(f);
		}
		
		for(EObject p : model.getObjects("Person")) {
			String f = (String) p.eGet(mName);
			assertEquals("Called from After operation", f);
		}
	}

}
