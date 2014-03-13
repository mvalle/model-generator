package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.index.ConfigIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.ConfigParser;

public class ConfigIndexTester extends FileTester {
	
	@Before
	public void classSetUp() {	
		location = dataDir + "test.config";	
	}
	
	@Test
	public void test_constructor() throws IOException {
		ConfigIndex index = (new ConfigParser()).parse(location);
		
		assertNotNull(index);
	}

	
}
