package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.ModelGenerator;
import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;

public class Evaluation {

	
	@Test
	public void test_config() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";
		
		String metaModelLoc = dataDir + "metamodels/Config.ecore";
		String configLoc = dataDir + "evaluations/modgen.config";
		
		String outputLoc = dataDir + "xeval_config_out.config";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		
		
		ModelGenerator d = new ModelGenerator(model);
		d.addConfiguration(c);
		
		d.create();
			
		model.save();
		
	}

	@Test
	public void test_config2() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";
		
		String metaModelLoc = dataDir + "metamodels/Config.ecore";
		String configLoc = dataDir + "xeval_config_out.config";
		
		String outputLoc = dataDir + "xeval_config_result.config";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		
		
		ModelGenerator d = new ModelGenerator(model);
		d.addConfiguration(c);
		
		d.create();
			
		model.save();
		
	}
	
	@Test
	public void test_SmallUnstructured() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/Ecore.ecore";
		String configLoc = dataDir + "evaluations/VeryLargeUnstructured.config";
		
		String outputLoc = dataDir + "evaluations/very_large_unstructured.ecore";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		
		
		ModelGenerator d = new ModelGenerator(model);
		d.addConfiguration(c);
		
		d.create();
			
		model.save();
	}
	
	@Test
	public void test_SmallStructured() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/Ecore.ecore";
		String configLoc = dataDir + "evaluations/VeryLargeStructured.config";
		
		String outputLoc = dataDir + "evaluations/very_large_structured.ecore";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		
		
		ModelGenerator d = new ModelGenerator(model);
		d.addConfiguration(c);
		
		d.create();
			
		model.save();
	}
	
	@Test
	public void test_LargeUnstructured() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/Ecore.ecore";
		String configLoc = dataDir + "evaluations/LargeUnstructured.config";
		
		String outputLoc = dataDir + "evaluations/large_unstructured.ecore";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		
		
		ModelGenerator d = new ModelGenerator(model);
		d.addConfiguration(c);
		
		d.create();
			
		model.save();
	}
	
	@Test
	public void test_LargeStructured() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/Ecore.ecore";
		String configLoc = dataDir + "evaluations/LargeStructured.config";
		
		String outputLoc = dataDir + "evaluations/large_structured.ecore";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		
		
		ModelGenerator d = new ModelGenerator(model);
		d.addConfiguration(c);
		
		d.create();
			
		model.save();
	}
}
