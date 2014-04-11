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

public class GenerateModels {

	@Test
	public void test_config() throws IOException {
		String dataDir = System.getProperty("user.dir") + "/src/uk/ac/york/cs/mv525/modelgen/test/data/";
		
		String metaModelLoc = dataDir + "Config.ecore";
		String configLoc = dataDir + "My.config";
		
		String outputLoc = dataDir + "test_config_model.config";
		
		MetaModelIndex mmi = MetaModelParser.parse(metaModelLoc);
		
		Configuration c = ConfigParser.parse(configLoc);
		c.setMetaModel(mmi);
		
		ModelInstance model = new ModelInstance(outputLoc);
		//System.out.println(model);
		
		Orchastrator d = new Orchastrator(model);
		d.addConfiguration(c);
		
		d.create();
		
		//System.out.println(model);		
		model.save();
		
	}

}
