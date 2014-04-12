package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.generate.EolGenerator;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen.strategy.AlwaysCreate;

public class EolGeneratorConstructor extends FileTester {

	String configLocation = dataDir + "test.config";
	String metaModelLocation = mmDir+"orgchart.ecore";
	Configuration cIndex;
	
	MetaModelIndex mIndex;
	ModelInstance model;
	
	@Before
	public void setUp() throws Exception {
		location = dataDir + "test_constructor.eol";
		
		mIndex = MetaModelParser.parse(metaModelLocation);
		
		model = new ModelInstance(dataDir+"test.model");
	

		cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mIndex);
		
	}
	@After
	public void teadDown() {
		File f = new File(dataDir+"test.model");
		if (f.exists()) {
			f.delete();
		}
	}

	@Test
	public void test_constructor_create() throws IOException {

		EolGenerator eg  = new EolGenerator(location, model, cIndex);
		eg.setStrategy(new AlwaysCreate(eg));

		EClass mClass = (EClass) mIndex.get("Person");
		
		EObject person = eg.create(mClass);
		
		//EObject person = eg.create((EClass) mIndex.get("Person"));
		
		assertNotNull(person);
		
		
	}
	
	@Test
	public void test_constructor_atribute_as_been_created() throws IOException {

		EolGenerator eg  = new EolGenerator(location, model, cIndex);
		eg.setStrategy(new AlwaysCreate(eg));
		//EObject person = eg.create((EClass) mIndex.get("Person"));
		
		EClass mClass = (EClass) mIndex.get("Person");

		EObject person = eg.create(mClass);
		
		EStructuralFeature mName = mClass.getEStructuralFeature("name");
		
		String actual = (String) person.eGet(mName);
		String expected = "created from createPerson";
		assertEquals(expected, actual);
		
		
	}

}
