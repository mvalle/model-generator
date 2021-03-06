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

public class GenerateModels {

	
	
	
	
	@Test
	public void test_config() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";
		
		String metaModelLoc = dataDir + "metamodels/Config.ecore";
		String configLoc = dataDir + "My.config";
		
		String outputLoc = dataDir + "test_config_model.config";
		
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
	public void test_ieee1474cm() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/IEEE1471ConceptualModel.ecore";
		String configLoc = dataDir + "CM.config";
		
		String outputLoc = dataDir + "test_cm_model.cm";
		
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
	public void test_cpl() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/CPL.ecore";
		String configLoc = dataDir + "CPL.config";
		
		String outputLoc = dataDir + "test_cpl_model.cpl";
		
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
	public void test_MoDAF() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/MoDAF-AV.ecore";
		String configLoc = dataDir + "MoDAF.config";
		
		String outputLoc = dataDir + "test_modaf_model.modaf";
		
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
	public void test_Ecore() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/Ecore.ecore";
		String configLoc = dataDir + "Ecore.config";
		
		String outputLoc = dataDir + "test_ecore_model.ecore";
		
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
	public void test_BigEcore() throws IOException {
		//return;
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";

		String metaModelLoc = dataDir + "metamodels/Ecore.ecore";
		String configLoc = dataDir + "BigEcore.config";
		
		String outputLoc = dataDir + "test_big_ecore_model.ecore";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		
		
		ModelGenerator d = new ModelGenerator(model);
		d.addConfiguration(c);
		
		//d.create();
			
		//model.save();
	}
}
