package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;

public class MetaModelParserTester extends FileTester {
	
	@Before
	public void classSetUp() {	
		location = mmDir + "orgchart.ecore";	
	}
	
	@Test
	public void testSimple() throws IOException {		
		
		MetaModelIndex index = MetaModelParser.parse(location);
		
		assertNotNull(index);
	}
	
	@Test
	public void test_getEPackage() throws IOException {		
		
		MetaModelIndex index = MetaModelParser.parse(location);
		
		assertNotNull(index);
		
		EPackage pack = index.getEPackage();
		
		assertNotNull(pack);
	}
	
	@Test
	public void test_dump() throws IOException {		
		
		MetaModelIndex index = MetaModelParser.parse(location);
		
		assertNotNull(index);
		
		Collection<EClass> dump = index.dump();
		
		assertNotNull(dump);
		assertTrue(dump.size() > 0);
		
		for(EClass obj : dump) {
			assertNotNull(obj);
		}
				
				
	}

} 


