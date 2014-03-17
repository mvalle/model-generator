package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.generate.CombinedGenerator;
import uk.ac.york.cs.mv525.modelgen2.generate.EolGenerator;
import uk.ac.york.cs.mv525.modelgen2.generate.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen2.index.ConfigIndex;
import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen2.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen2.strategy.DefaultOrchastration;

public class DefaultOrchestrationTester {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws IOException {
		String modelDir = "/home/mv/git/model-generator/models";
		String programLocation = modelDir +"/test.eol";
		String metaModelLocation = modelDir + "/orgchart.ecore";
		String outputLocation = modelDir +"/testmodels.modelx";
		String configLocation = "/home/mv/git/model-generator/models/test.config";
		
		MetaModelParser mmParser = new MetaModelParser();
		MetaModelIndex mmIndex = mmParser.parse(metaModelLocation);
		
		ConfigParser cParser = new ConfigParser();
		ConfigIndex cIndex = cParser.parse(configLocation);
		
		ModelInstance model = new ModelInstance(outputLocation);
				
		RandomGenerator rand = new RandomGenerator(mmIndex.getEPackage().getEFactoryInstance());
		EolGenerator eol = new EolGenerator(programLocation, model, mmIndex);
		
		CombinedGenerator generator = new CombinedGenerator(rand);
		generator.addGenerator(eol);
		
		DefaultOrchastration defaultOrchastration = new DefaultOrchastration();
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addGenerator(generator);
		defaultOrchastration.addModel(model);
		
	}

}
