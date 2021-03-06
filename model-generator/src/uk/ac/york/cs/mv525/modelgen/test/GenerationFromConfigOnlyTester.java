package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.assertNotSame;

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
//import uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration;
//import uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelGenerationImpl;

public class GenerationFromConfigOnlyTester extends FileTester {
	
	String programLocation = dataDir +"test.eol";
	//String metaModelLocation = dataDir + "orgchart.ecore";
	String metaModelLocation = mmDir+"Config.ecore";
	//String location = dataDir +"testmodels.modelx";
	String location = dataDir +"testmodels.config";
	//String configLocation = dataDir + "default_generator.config";
	String configLocation = dataDir + "model.config";
	
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
		long precount = model.getCount();
		
		System.out.print(model);
		System.out.println(" test_generation()");
		
		ModelGenerator orch = new ModelGenerator(model);
		orch.addConfiguration(cIndex);
		//orch.addGenerator(cIndex.getGenerator());
		
		orch.create();
		
		long postcount = model.getCount();
		
		assertNotSame(precount, postcount);		
		
	}
	
	@Test
	public void test_saving_to_file() throws IOException {
		
		MetaModelIndex mmIndex = MetaModelParser.parse(metaModelLocation);
		
		Configuration cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mmIndex);
		
		ModelInstance model = new ModelInstance(location);
				
		//cIndex.create(model);
		
		model.save();
		
	}

}
