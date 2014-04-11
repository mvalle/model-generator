package uk.ac.york.cs.mv525.modelgen.main;

import java.io.IOException;

import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.generate.CombinedGenerator;
import uk.ac.york.cs.mv525.modelgen.generate.EolGenerator;
import uk.ac.york.cs.mv525.modelgen.generate.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.orchestration.Orchastrator;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;

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
		MetaModelIndex mmIndex = MetaModelParser.parse(metaModelLocation);
		
		/* The object that contains the representation of the configuration file */
		Configuration cIndex = ConfigParser.parse(configLocation);
		
		/* The object responsible for generating model elements. Consisting of two other sub-generators */
		RandomGenerator rand = new RandomGenerator(model, mmIndex, cIndex);
		EolGenerator eol = new EolGenerator(programLocation, model, cIndex);		
		CombinedGenerator generator = new CombinedGenerator(rand);
		generator.addGenerator(eol);
		
		/* The object responsible for overseeing the model generation process */
		Orchastrator defaultOrchastration = new Orchastrator();
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addGenerator(generator);
		defaultOrchastration.addModel(model);
		
		/* Where the magic happens */		
		defaultOrchastration.create();		
		model.save();
	}

}
