package uk.ac.york.cs.mv525.modelgen2.test;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.MetaModelParser;

public class ModelInstanceTester extends FileTester {

	String metaModel = dataDir + "orgchart.ecore";
	MetaModelIndex index;
	
	@Before
	public void setUp() throws Exception {
		createsFile = true;
		location = dataDir + "output.model";

		index = MetaModelParser.parse(metaModel);
	}
	
	@After
	public void teadDown() {
		File f = new File(location);
		if (f.exists()) {
			f.delete();
		}
	}

	@Test
	public void test_add() {
		ModelInstance model = new ModelInstance(location);
				
		
		EObject o = index.get("Person"); 
		
		model.add(o);
		
		EObject o2 = model.get(o.eClass().getName());
		
		assertEquals(o, o2);
		
	}
	
		
	@Test
	public void test_getResource() {
		ModelInstance model = new ModelInstance(location);

		EObject o = index.get("Person"); 
		
		model.add(o);
		
		EObject o2 = model.get(o.eClass().getName());

		assertEquals(o, o2);
		
		
		Resource res = model.getResource();
		
		assertNotNull(res);	
		
	}
	
	@Test
	public void test_CompareResources() {
		ModelInstance model = new ModelInstance(location);

		EObject o = index.get("Person"); 
		
		model.add(o);
		
		EObject o2 = model.get(o.eClass().getName());

		assertEquals(o, o2);
		

		
		EPackage ePack = index.getEPackage();
		
		assertNotNull(ePack);
		
		Resource res = model.getResource();
		
		assertNotNull(res);
		
		assertNotSame(res, ePack.eResource());
	}

}























