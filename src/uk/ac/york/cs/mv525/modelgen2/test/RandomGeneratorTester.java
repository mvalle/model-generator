package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.generate.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.MetaModelParser;

public class RandomGeneratorTester extends FileTester {

	MetaModelIndex index;
	
	@Before
	public void setUp() throws Exception {
		
		location = dataDir + "orgchart.ecore";

		MetaModelParser parser = new MetaModelParser();
		index = parser.parse(location);
		
		
	}
	
	@Test
	public void test_create_class() {
		
		RandomGenerator rg  = new RandomGenerator(index.getEPackage().getEFactoryInstance());
		EObject randObj = rg.create((EClass) index.get("Person"));
		
		assertNotNull(randObj);
	}
	
	@Test
	public void test_create_attribute() {
		
		RandomGenerator rg  = new RandomGenerator(index.getEPackage().getEFactoryInstance());
		EClass mClass = (EClass) index.get("Person");
		EStructuralFeature mName = mClass.getEStructuralFeature("name");
		
		EObject person = rg.create(mClass);
		Object name = rg.add(person, mName);		
		assertNotNull(name);
		
		Object actual = person.eGet(mName);		
		assertSame(name, actual);
	}
	
	@Test
	public void test_link() {
		RandomGenerator rg  = new RandomGenerator(index.getEPackage().getEFactoryInstance());
		EClass mClass = (EClass) index.get("Person");
		EStructuralFeature mManages = mClass.getEStructuralFeature("manages");
		
		EObject person = rg.create(mClass);
		Object manager = rg.link(person, (EReference) mManages);		
		assertNotNull(manager);
		
		Object actual = person.eGet(mManages);		
		assertSame(manager, actual);
	}

}




















