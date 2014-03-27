package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration;
import uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.AlwaysCreateStrategyImpl;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.EolGeneratorImpl;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelGenerationImpl;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.RandomGeneratorImpl;
import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen.orchestration.DefaultOrchastration;

public class DefaultOrchestrationTester extends FileTester {

	String programLocation = dataDir +"test.eol";
	String metaModelLocation = dataDir + "orgchart.ecore";
	String location = dataDir +"testmodels.modelx";
	String configLocation = dataDir + "test.config";
	
	@Before
	public void setUp() throws Exception {
		createsFile = true;
	}

	@After
	public void teadDown() {
		File f = new File(location);
		if (f.exists()) {
			f.delete();
		}
	}	
	
	@Test
	public void test_generation() throws IOException {
		
		MetaModelIndex mmIndex = MetaModelParser.parse(metaModelLocation);
		
		Configuration cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mmIndex);
		
		ModelInstance model = new ModelInstance(location);
				
		RandomGenerator rand = new RandomGeneratorImpl(model, mmIndex);
		rand.setStrategy(new AlwaysCreateStrategyImpl(rand));
		EolGenerator eol = new EolGeneratorImpl(programLocation, model, mmIndex);
		eol.setStrategy(new AlwaysCreateStrategyImpl(eol));
		
		ModelGeneration generator = new ModelGenerationImpl(rand);
		generator.addGenerator(eol);
		
		DefaultOrchastration defaultOrchastration = new DefaultOrchastration();
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addGenerator(generator);
		defaultOrchastration.addModel(model);
		
		long precount = model.getCount();
		defaultOrchastration.create();
		
		long postcount = model.getCount();
		
		assertNotSame(precount, postcount);		
	}
	
	@Test
	public void test_saving_to_file() throws IOException {
		
		MetaModelIndex mmIndex = MetaModelParser.parse(metaModelLocation);
		
		Configuration cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mmIndex);
		
		ModelInstance model = new ModelInstance(location);
				
		RandomGenerator rand = new RandomGeneratorImpl(model, mmIndex);
        rand.setStrategy(new AlwaysCreateStrategyImpl(rand));
		EolGenerator eol = new EolGeneratorImpl(programLocation, model, mmIndex);
		eol.setStrategy(new AlwaysCreateStrategyImpl(eol));
		
		ModelGeneration generator = new ModelGenerationImpl(rand);
		//generator.setFallback();
		generator.addGenerator(eol);
		
		DefaultOrchastration defaultOrchastration = new DefaultOrchastration();
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addGenerator(generator);
		defaultOrchastration.addModel(model);
				
		defaultOrchastration.create();
		
		model.save();
		
	}
}
