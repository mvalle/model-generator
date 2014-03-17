package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.generate.EolGenerator;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;

public class EolGeneratorTester extends FileTester {

	MetaModelIndex mIndex;
	ModelInstance model;
	
	@Before
	public void setUp() throws Exception {
		location = dataDir + "test.eol";

		mIndex = MetaModelParser.parse(dataDir+"orgchart.ecore");
		
		model = new ModelInstance(dataDir+"test.model");
	}
	
	@After
	public void teadDown() {
		File f = new File(dataDir+"test.model");
		if (f.exists()) {
			f.delete();
		}
	}
	
	@Test
	public void test_create_class() throws Exception {
		
		EolGenerator eg  = new EolGenerator(location, model, mIndex);
		EObject randObj = eg.create((EClass) mIndex.get("Person"));
		
		assertNotNull(randObj);
	}
	
	@Test
	public void test_create_attribute() throws Exception {
		
		EolGenerator eg  = new EolGenerator(location, model, mIndex);
		EClass mClass = (EClass) mIndex.get("Person");
		EStructuralFeature mName = mClass.getEStructuralFeature("name");
		
		EObject person = eg.create(mClass);
		Object name = eg.add(person, mName);		
		assertNotNull(name);
		
		Object actual = person.eGet(mName);
		assertSame(name, actual);
	}
	
	@Test
	public void test_link() throws Exception {
		EolGenerator eg  = new EolGenerator(location, model, mIndex);
		EClass mClass = (EClass) mIndex.get("Person");
		EStructuralFeature mManages = mClass.getEStructuralFeature("manages");
		
		EObject person = eg.create(mClass);
		Object manager = eg.link(person, (EReference) mManages);		
		assertNotNull(manager);
		
		Object actual = person.eGet(mManages);		
		assertSame(manager, actual);
	}
}
