package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

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

public class DefaultOrchestrationTester extends FileTester {

	String programLocation = dataDir +"test.eol";
	String metaModelLocation = mmDir+"orgchart.ecore";
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
				
		RandomProducer rand = new RandomProducer(model, mmIndex, cIndex);
		rand.setStrategy(new AlwaysCreate(rand));
		EolProducer eol = new EolProducer(programLocation, model, cIndex);
		eol.setStrategy(new AlwaysCreate(eol));
		
		CombinedProducer generator = new CombinedProducer(rand);
		generator.addProducer(eol);
		
		ModelGenerator defaultOrchastration = new ModelGenerator(model);
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addProducer(generator);
		
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
				
		RandomProducer rand = new RandomProducer(model, mmIndex, cIndex);
        rand.setStrategy(new AlwaysCreate(rand));
		EolProducer eol = new EolProducer(programLocation, model, cIndex);
		eol.setStrategy(new AlwaysCreate(eol));
		
		CombinedProducer generator = new CombinedProducer(rand);
		//generator.setFallback();
		generator.addProducer(eol);
		
		ModelGenerator defaultOrchastration = new ModelGenerator(model);
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addProducer(generator);
				
		defaultOrchastration.create();
		
		model.save();
		
	}
	
	
}
