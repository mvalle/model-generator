package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.data.Configuration;
import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.generate.CombinedGenerator;
import uk.ac.york.cs.mv525.modelgen2.generate.EolGenerator;
import uk.ac.york.cs.mv525.modelgen2.generate.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen2.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen2.strategy.DefaultOrchastration;

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
				
		RandomGenerator rand = new RandomGenerator(model, mmIndex);
		EolGenerator eol = new EolGenerator(programLocation, model, mmIndex);
		
		CombinedGenerator generator = new CombinedGenerator(rand);
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
				
		RandomGenerator rand = new RandomGenerator(model, mmIndex);
		EolGenerator eol = new EolGenerator(programLocation, model, mmIndex);
		
		CombinedGenerator generator = new CombinedGenerator(rand);
		generator.addGenerator(eol);
		
		DefaultOrchastration defaultOrchastration = new DefaultOrchastration();
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addGenerator(generator);
		defaultOrchastration.addModel(model);
				
		defaultOrchastration.create();
		
		model.save();
		
	}
}
