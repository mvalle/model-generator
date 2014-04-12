package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;

import org.javatuples.Pair;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;

public class ConfigIndexTester extends FileTester {
	
	MetaModelIndex mmIndex;
	@Before
	public void classSetUp() throws IOException {	
		location = dataDir + "test.config";
		
		mmIndex = MetaModelParser.parse(mmDir+"orgchart.ecore");
	}
	private Configuration newIndex() throws IOException {
		Configuration c =  ConfigParser.parse(location);
		c.setMetaModel(mmIndex);
		return c;
	}
	
	@Test
	public void test_constructor() throws IOException {
		Configuration index = ConfigParser.parse(location);
		
		assertNotNull(index);
	}

	@Test
	public void test_null_getters() throws IOException {
		Configuration index = newIndex();
		
		try {
			index.get("");
			assertTrue(false);
		} catch (Exception e) {
			assertEquals(e.getClass(), IllegalStateException.class);
		}
	}

	@Test
	public void test_getters() throws IOException {
		Configuration index = newIndex();
		
		long actual = index.get("Person");
		assertNotNull(actual);		
	}


	@Test
	public void test_dump() throws IOException {
		Configuration index = newIndex();
		
		LinkedList<Pair<String, Long>> actual = index.dump();
		assertNotNull(actual);
		assertTrue(actual.size() > 0);
	}
	
	
	
}
