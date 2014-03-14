package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;

import org.javatuples.Pair;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.index.ConfigIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.ConfigParser;

public class ConfigIndexTester extends FileTester {
	
	@Before
	public void classSetUp() {	
		location = dataDir + "test.config";	
	}
	private ConfigIndex newIndex() throws IOException {
		return (new ConfigParser()).parse(location);
	}
	
	@Test
	public void test_constructor() throws IOException {
		ConfigIndex index = (new ConfigParser()).parse(location);
		
		assertNotNull(index);
	}

	@Test
	public void test_null_getters() throws IOException {
		ConfigIndex index = newIndex();
		
		try {
			index.get("");
			assertTrue(false);
		} catch (Exception e) {
			assertEquals(e.getClass(), IllegalStateException.class);
		}
	}

	@Test
	public void test_getters() throws IOException {
		ConfigIndex index = newIndex();
		
		BigInteger actual = index.get("Employee");
		assertNotNull(actual);		
	}


	@Test
	public void test_dump() throws IOException {
		ConfigIndex index = newIndex();
		
		LinkedList<Pair<String, BigInteger>> actual = index.dump();
		assertNotNull(actual);
		assertTrue(actual.size() > 0);
	}
	
	
	
}
