package uk.ac.york.cs.mv525.modelgen2.main;

import java.io.IOException;

import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.generate.CombinedGenerator;
import uk.ac.york.cs.mv525.modelgen2.generate.EolGenerator;
import uk.ac.york.cs.mv525.modelgen2.generate.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen2.data.Configuration;
import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen2.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen2.strategy.DefaultOrchastration;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String modelDir = "/home/mv/git/model-generator/models";
		String programLocation = modelDir +"/test.eol";
		String metaModelLocation = modelDir + "/orgchart.ecore";
		String outputLocation = modelDir +"/testmodels.modelx";
		String configLocation = "/home/mv/git/model-generator/models/test.config";
		
		generateModel(programLocation, metaModelLocation, outputLocation,
				configLocation);
		
		
	}

	private static void generateModel(String programLocation,
			String metaModelLocation, String outputLocation,
			String configLocation) throws IOException {
		
		/* The object that contains the instance of the model being generated */
		ModelInstance model = new ModelInstance(outputLocation);
		
		/* The object that contains the representation of the meta-model*/
		MetaModelParser mmParser = new MetaModelParser();
		MetaModelIndex mmIndex = mmParser.parse(metaModelLocation);
		
		/* The object that contains the representation of the configuration file */
		ConfigParser cParser = new ConfigParser();
		Configuration cIndex = cParser.parse(configLocation);
		
		/* The object responsible for generating model elements. Consisting of two other sub-generators */
		RandomGenerator rand = new RandomGenerator(model, mmIndex);
		EolGenerator eol = new EolGenerator(programLocation, model, mmIndex);		
		CombinedGenerator generator = new CombinedGenerator(rand);
		generator.addGenerator(eol);
		
		/* The object responsible for overseeing the model generation process */
		DefaultOrchastration defaultOrchastration = new DefaultOrchastration();
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addGenerator(generator);
		defaultOrchastration.addModel(model);
		
		/* Where the magic happens */		
		defaultOrchastration.create();		
		model.save();
	}

}
