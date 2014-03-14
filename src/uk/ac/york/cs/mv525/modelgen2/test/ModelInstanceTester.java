package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;

public class ModelInstanceTester extends FileTester {

	@Before
	public void setUp() throws Exception {
		createsFile = true;
		location = dataDir + "output.model";
	}
	
	@After
	public void teadDown() {
		File f = new File(location);
		if (f.exists()) {
			f.delete();
		}
	}

	@Test
	public void test() {
		ModelInstance model = new ModelInstance(location);
		
	}

}
