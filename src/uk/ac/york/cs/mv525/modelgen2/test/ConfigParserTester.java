package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.data.Configuration;
import uk.ac.york.cs.mv525.modelgen2.parse.ConfigParser;

public class ConfigParserTester extends FileTester {
	
	@Before
	public void classSetUp() {	
		location = dataDir + "test.config";	
	}
	
	@Test
	public void testSimple() throws IOException {
		
		Configuration index = ConfigParser.parse(location);
		
		assertNotNull(index);
	}

}
