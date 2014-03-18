package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.InvalidConfigurationException;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;

public class ConfigValidationTester extends FileTester {

	String invalid_excludes;
	String invalid_override;
	
	MetaModelIndex mmIndex;
	
	@Before
	public void classSetUp() throws IOException {
		location = dataDir + "orgchart.ecore";
		mmIndex =  MetaModelParser.parse(location);
		
		invalid_override = dataDir + "invalid_override.config";
		invalid_excludes = dataDir + "invalid_exclude.config";	
	}

	@Test
	public void test_invalidOverride() throws IOException {
		Configuration index = ConfigParser.parse(invalid_override);
		
		try {
			index.setMetaModel(mmIndex);
			assertTrue(false);
		} catch (Exception e) {
			assertSame(e.getClass(), InvalidConfigurationException.class);
		}
	}
	@Test
	public void test_invalidExcludes() throws IOException {
		Configuration index = ConfigParser.parse(invalid_excludes);

		try {
			index.setMetaModel(mmIndex);
			assertTrue(false);
		} catch (Exception e) {
			assertSame(e.getClass(), InvalidConfigurationException.class);
			
		}
	}

}
