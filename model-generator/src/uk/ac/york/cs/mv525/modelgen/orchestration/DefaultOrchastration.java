package uk.ac.york.cs.mv525.modelgen.orchestration;

import java.io.IOException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.data.Configuration;

// TODO : This class feels like it's two classes in one
public class DefaultOrchastration {

	//protected MetaModelIndex mmIndex;
	protected Configuration cIndex;
	
	protected ModelInstance modelInstance;
	
	protected ModelGeneration generator;
	
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

	public void addGenerator(ModelGeneration generator) {
		this.generator = generator;
	}
	
	public void addModel(ModelInstance model) {
		modelInstance = model;
	}
		
	public void create() {
		
		generator.before();
		
		/* Start by creating the minimum amount of classes. */
		
		EClass mClass = (EClass) cIndex.getNext();
		
		while(mClass != null) {
			EObject iObject = generator.create(mClass);
			
			for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
				if (feature.getEType() instanceof EClass ) {
					//generator.link(iObject, (EReference) feature);
				} else {				
					generator.add(iObject, feature);				
				}
			}			

			mClass = (EClass) cIndex.getNext();
		}
		
		/* Finish by linking the objects together. 
		 * This section may create more objects, 
		 * depending on the strategy used. */
		
		cIndex.resetState();
		mClass = (EClass) cIndex.getNext();
		
		while(mClass != null) {
			EObject iObject = modelInstance.get(mClass.getName());
			
			for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
				if (feature.getEType() instanceof EClass ) {
					generator.link(iObject, (EReference) feature);
				}
			}
			
			mClass = (EClass) cIndex.getNext();
		}
		
		
		
		
		
		
		generator.after();
	}	
}
