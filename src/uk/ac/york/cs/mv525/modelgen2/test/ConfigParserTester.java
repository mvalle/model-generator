package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.index.ConfigIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.ConfigParser;

public class ConfigParserTester extends FileTester {
	
	@Before
	public void classSetUp() {	
		location = dataDir + "test.config";	
	}
	
	@Test
	public void testSimple() throws IOException {
		
		ConfigParser parser = new ConfigParser();
		
		ConfigIndex index = parser.parse(location);
		
		assertNotNull(index);
	}

}
