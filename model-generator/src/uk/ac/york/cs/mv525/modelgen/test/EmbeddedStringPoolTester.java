package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen.ModelGenerator;
import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.ConfigParser;
import uk.ac.york.cs.mv525.modelgen.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen.producer.CombinedProducer;
import uk.ac.york.cs.mv525.modelgen.producer.RandomProducer;
import uk.ac.york.cs.mv525.modelgen.strategy.AlwaysCreate;

public class EmbeddedStringPoolTester extends FileTester {

	String programLocation = dataDir +"test.eol";
	String metaModelLocation = mmDir+"orgchart.ecore";
	String location = dataDir +"testmodels.modelx";
	String configLocation = dataDir + "embeded_string_pool.config";
	
	@Before
	public void setUp() throws Exception {
		createsFile = true;
	}

	@After
	public void teadDown() {
		File f = new File(location);
		if (f.exists()) {
			f.delete();
		}
	}	

	@Test
	public void test() throws IOException {
		MetaModelIndex mmIndex = MetaModelParser.parse(metaModelLocation);
		
		Configuration cIndex = ConfigParser.parse(configLocation);
		cIndex.setMetaModel(mmIndex);
		
		ModelInstance model = new ModelInstance(location);
				
		RandomProducer rand = new RandomProducer(model, mmIndex, cIndex);
        rand.setStrategy(new AlwaysCreate(rand));
		//EolGenerator eol = new EolGenerator(programLocation, model, mmIndex);
		//eol.setStrategy(new AlwaysCreate(eol));
		
        CombinedProducer generator = new CombinedProducer(rand);
		//generator.addGenerator(eol);
		
		ModelGenerator defaultOrchastration = new ModelGenerator(model);
		defaultOrchastration.addConfiguration(cIndex);
		defaultOrchastration.addProducer(generator);
				
		defaultOrchastration.create();
		
		List<EObject> persons = model.getObjects("Person");
		
		assertNotNull(persons);
		assertTrue(persons.size() >= 4);
		
		EClass Person = persons.get(0).eClass();
		assertNotNull(Person);
		
		EStructuralFeature Name = Person.getEStructuralFeature("name");
		assertNotNull(Name);
		
		boolean jim = false;
		boolean tom = false;
		boolean jerry = false;
		boolean terry = false;

		for(EObject person : persons) {
			String s = (String)person.eGet(Name);

			if(s.equals("Jim")) {
				jim = true;
			} else if (s.equals("Tom")) {
				tom = true;
			} else if (s.equals("Jerry")) {
				jerry = true;
			} else if (s.equals("Terry")) {
				terry = true;
			} 
			
		}

		assertTrue(jim);
		assertTrue(tom);
		assertTrue(jerry);
		assertTrue(terry);
		
		
		model.save();
	}

}
