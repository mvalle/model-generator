package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.orchestration.Orchastrator;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;

public class Evaluation {

	@Test
	public void test_SmallUnstructured() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/Ecore.ecore";
		String configLoc = dataDir + "evaluations/SmallUnstructured.config";
		
		String outputLoc = dataDir + "evaluations/small_unstructured.ecore";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		
		
		Orchastrator d = new Orchastrator(model);
		d.addConfiguration(c);
		
		d.create();
			
		model.save();
	}
	
	@Test
	public void test_SmallStructured() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/Ecore.ecore";
		String configLoc = dataDir + "evaluations/SmallStructured.config";
		
		String outputLoc = dataDir + "evaluations/small_structured.ecore";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		
		
		Orchastrator d = new Orchastrator(model);
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
		
		
		Orchastrator d = new Orchastrator(model);
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
		
		
		Orchastrator d = new Orchastrator(model);
		d.addConfiguration(c);
		
		d.create();
			
		model.save();
	}
}
