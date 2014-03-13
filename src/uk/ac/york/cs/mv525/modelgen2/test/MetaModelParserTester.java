package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.MetaModelParser;

public class MetaModelParserTester extends FileTester {
	
	@Before
	public void classSetUp() {	
		location = dataDir + "orgchart.ecore";	
	}
	
	@Test
	public void testSimple() throws IOException {		
		
		MetaModelParser parser = new MetaModelParser();
		
		MetaModelIndex index = parser.parse(location);
		
		assertNotNull(index);
	}

} 


