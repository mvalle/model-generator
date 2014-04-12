package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.EolIndex;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.EolParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;

public class EolParserTester extends FileTester {
	
	String modelLocation = dataDir+"output.model";
	String metaModelLocation = mmDir+"orgchart.ecore";
	MetaModelIndex index;
	
	@Before
	public void setUp() throws IOException {

		location = dataDir + "test.eol";
		
		index = MetaModelParser.parse(metaModelLocation);
		
	}
	
	@Test
	public void testNull() {
		String location = null;
		EolParser parser = new EolParser(null, null);

		try {
			parser.parse(location);
			assertTrue("Parser failed to throw exception with null inputs.", false);
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void test_basic() throws IOException, EolRuntimeException {

		ModelInstance model = new ModelInstance(location);
		
		EolParser parser = new EolParser(model.getResource(), index.getEPackage());

		parser.parse(location);
		
		
	}
	
	@Test
	public void test_parse() throws IOException, EolRuntimeException {

		ModelInstance model = new ModelInstance(location);
		
		EolParser parser = new EolParser(model.getResource(), index.getEPackage());

		EolIndex index = parser.parse(location);
		
		EolOperation o = index.get("Person", "name");
		
		assertNotNull(o);
		
		
	}
	

}
