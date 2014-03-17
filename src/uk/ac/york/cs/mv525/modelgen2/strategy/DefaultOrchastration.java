package uk.ac.york.cs.mv525.modelgen2.strategy;

import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.javatuples.Pair;


import uk.ac.york.cs.mv525.modelgen2.generate.CombinedGenerator;
import uk.ac.york.cs.mv525.modelgen2.generate.Generator;
import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.data.Configuration;
import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen2.parse.ConfigParser;

// TODO : This class feels like it's two classes in one
public class DefaultOrchastration extends Strategy {

	//protected MetaModelIndex mmIndex;
	protected Configuration cIndex;
	
	protected ModelInstance modelInstance;
	
	protected Generator generator;
	
	public DefaultOrchastration() {
		
		//MetaModelParser mmParser = new MetaModelParser();
		//mmIndex = mmParser.parse(metamodel);				
	}
	
	
	//TODO: Maybe this should be refactored into a separate class 
	public void addConfiguration(Configuration index) throws IOException {
		cIndex = index;
		//ConfigParser cParser = new ConfigParser();
		//cIndex = cParser.parse(configuration);
		//cIndex.setMetaModel(mmIndex);
	}

	public void addGenerator(Generator generator) {
		this.generator = generator;
	}
	
	public void addModel(ModelInstance model) {
		modelInstance = model;
	}
		
	public void create() {
		EClass mClass = (EClass) cIndex.getNext();
		
		while(mClass != null) {
			EObject iObject = generator.create(mClass);
			
			for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
				if (feature.getEType() instanceof EClass ) {
					generator.link(iObject, (EReference) feature);
				} else {				
					generator.add(iObject, feature);				
				}
			}
			

			mClass = (EClass) cIndex.getNext();
		} 
	}	
}
