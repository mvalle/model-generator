package uk.ac.york.cs.mv525.modelgen.test;

import static org.junit.Assert.*;

import java.awt.JobAttributes.DefaultSelectionType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Before;
import org.junit.Test;


import uk.ac.york.cs.mv525.modelgen.generate.CombinedGenerator;

public class CreatingConfigTester extends FileTester {
	
	String configMM = dataDir + "metamodel/Config.ecore";
	String genEol = dataDir + "config_gen.eol";
	String location = dataDir + "config_output.config";
		
	@Before
	public void setUp() throws Exception {
		createsFile = true;
	}

	@Test
	public void test() throws IOException {
		/*
		// Create Model
		ModelConfiguration mc =	ConfigFactory.eINSTANCE.createModelConfiguration();
		
		mc.setTotalMinimumCount(100);
		mc.setMetaModelLocation(configMM);
		mc.setOutputModelLocation(location);
		
		
		StringPool defaultStringPool = ConfigFactory.eINSTANCE.createEmbeddedStringPool();
		defaultStringPool.setName("default");
		mc.setDefaultStringPool(defaultStringPool);
		
		CombinedGenerator gen = (CombinedGenerator) ConfigFactory.eINSTANCE.createCombinedGenerator();
		
		Generator rand = ConfigFactory.eINSTANCE.createRandomGenerator();
		//gen.setFallback(rand);
		
		EolGenerator eol = ConfigFactory.eINSTANCE.createEolGenerator();
		eol.setLocation(genEol);
		eol.setStrategy(ConfigFactory.eINSTANCE.createAlwaysRetrieveOrCreateStrategy());
		//gen.addGenerator(eol);
		
		//mc.setModelGeneration(gen);
		
		Strategy defaultStrategy = ConfigFactory.eINSTANCE.createAlwaysRetrieveOrCreateStrategy();		
		//gen.setDefaultStrategy(defaultStrategy);		
		
		ModelElementOverride modelElementOverride = ConfigFactory.eINSTANCE.createModelElementOverride();
		modelElementOverride.setMinimumCount(10);
		modelElementOverride.setName("ModelElementOverride");
		
		StringPool stringPool = ConfigFactory.eINSTANCE.createEmbeddedStringPool();
		stringPool.setName("Name");
		modelElementOverride.addStringPool(stringPool);
		
		mc.addModelElementOverride(modelElementOverride);
		assertEquals(1, mc.getModelElementOverrides().size());
		
		ModelElementExclusion modelElementExclusion = ConfigFactory.eINSTANCE.createModelElementExclusion();
		modelElementExclusion.setName("FileStringPool");
		
		mc.addModelElementExclusion(modelElementExclusion);
		assertEquals(1, mc.getModelElemetExclusions().size());
		
		// Save Model		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("config", new XMIResourceFactoryImpl());
		
		ResourceSet resSet = new ResourceSetImpl();
		
		Resource resource = resSet.createResource(URI.createURI("output_modelgen.config"));
		resource.getContents().add(mc);
		
		resource.save(Collections.EMPTY_MAP);
		*/
	}

}
