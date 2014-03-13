package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.parse.EolParser;

public class EolParserTester {

	@Test
	public void testNull() {
		String location = null;
		ModelInstance model = null;
		EolParser parser = new EolParser();

		try {
			parser.parse(location, model);
			assertTrue("Parser failed to throw exception with null inputs.", false);
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}

}
