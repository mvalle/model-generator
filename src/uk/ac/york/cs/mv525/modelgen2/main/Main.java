package uk.ac.york.cs.mv525.modelgen2.main;

import java.io.IOException;

import uk.ac.york.cs.mv525.modelgen2.generate.EolGenerator;
import uk.ac.york.cs.mv525.modelgen2.generate.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen2.strategy.DefaultStrategy;

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
		
		//RandomGenerator rand = new RandomGenerator();
		//EolGenerator eol = new EolGenerator(programLocation, model);
		
		DefaultStrategy defaultStrategy = new DefaultStrategy(metaModelLocation);
		//defaultStrategy.addGenerator(eol);
		//defaultStrategy.overrideDefaultGenerator(rand);
		
		
	}

}
