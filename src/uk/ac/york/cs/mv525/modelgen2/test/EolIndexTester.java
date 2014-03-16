package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.index.EolIndex;
import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.EolParser;
import uk.ac.york.cs.mv525.modelgen2.parse.MetaModelParser;

public class EolIndexTester extends FileTester {

	String modelLocation = dataDir+"output.model";
	String metaModelLocation = dataDir+"orgchart.ecore";
	MetaModelIndex mIndex;
	ModelInstance iModel;

	@Before
	public void setUp() throws IOException {

		location = dataDir + "test.eol";

		MetaModelParser parser = new MetaModelParser();
		
		mIndex = parser.parse(metaModelLocation);

		iModel = new ModelInstance(location);
		
	}

	@Test
	public void test() throws IOException {
		
		EolParser parser = new EolParser(iModel.getResource(), mIndex.getEPackage());

		EolIndex index = parser.parse(location);
		
		EolOperation o = index.get("Person", "name");
		
		assertNotNull(o);
	}
	@Test
	public void test_non_existing_opname() throws IOException {
		
		EolParser parser = new EolParser(iModel.getResource(), mIndex.getEPackage());

		EolIndex index = parser.parse(location);
		
		EolOperation o = index.get("Person", "dfasdfasdfasdfasdf");
		
		assertNull(o);
	}

	@Test
	public void test_non_existing_typename() throws IOException {
		
		EolParser parser = new EolParser(iModel.getResource(), mIndex.getEPackage());

		EolIndex index = parser.parse(location);
		
		EolOperation o = index.get("adsfasdfasdfasdfasdf", "createname");
		
		assertNull(o);
	}
	
	@Test
	public void test_non_null_opname() throws IOException {
		EolParser parser = new EolParser(iModel.getResource(), mIndex.getEPackage());

		EolIndex index = parser.parse(location);
		
		EolOperation o = index.get("Person", null);
		
		assertNull(o);
	}

	@Test
	public void test_non_null_typename() throws IOException {
		EolParser parser = new EolParser(iModel.getResource(), mIndex.getEPackage());

		EolIndex index = parser.parse(location);
		
		EolOperation o = index.get(null, "createname");
		
		assertNull(o);
	}

	@Test
	public void test_empty_lookup() throws IOException {
		EolParser parser = new EolParser(iModel.getResource(), mIndex.getEPackage());

		EolIndex index = parser.parse(location);
		
		EolOperation o = index.get("", "");
		
		assertNull(o);
	}
	
	@Test
	public void test_get_eolcontext() throws IOException {

		EolParser parser = new EolParser(iModel.getResource(), mIndex.getEPackage());

		EolIndex index = parser.parse(location);
		
		EolContext context = index.getEolContext();
		
		assertNotNull(context);		
	}

}
