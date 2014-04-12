package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileTester {
	protected String location;
	
	protected String dataDir = System.getProperty("user.dir") +
			"/src/uk/ac/york/cs/mv525/modelgen/test/data/";
	protected String mmDir = System.getProperty("user.dir") +
			"/src/uk/ac/york/cs/mv525/modelgen/test/data/metamodels/";
	
	protected boolean createsFile = false;
	@Test
	public void test_location_exists() {
		
		// Only run tests for subclasses
		if(this.getClass().equals(FileTester.class) || createsFile) return;
		
		File file = new File(location);
		
		assertTrue("File does not exist: " + location, file.exists());
	}
}
