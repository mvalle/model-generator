package uk.ac.york.cs.mv525.modelgen.orchestration;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
//import uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.producer.CombinedProducer;
import uk.ac.york.cs.mv525.modelgen.producer.EolProducer;
import uk.ac.york.cs.mv525.modelgen.producer.Producer;
import uk.ac.york.cs.mv525.modelgen.producer.RandomProducer;
import uk.ac.york.cs.mv525.modelgen.strategy.AlwaysCreate;
import uk.ac.york.cs.mv525.modelgen.strategy.AlwaysRetrieve;
import uk.ac.york.cs.mv525.modelgen.strategy.RetrieveOrCreate;
import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;
// TODO : Rename to ...
public class Orchastrator {

	protected MetaModelIndex mIndex;
	protected Configuration cIndex;
	
	protected ModelInstance modelInstance;
	
	protected Producer producer;
	
	public Orchastrator(ModelInstance model) {
		modelInstance = model;
	}
	
	public void addConfiguration(Configuration index) {
		cIndex = index;
		mIndex = index.metaModel;
		if(modelInstance != null) {
			init();
		}
	}

	private void init() {
		try {
			if (cIndex.getProducer() == null) {
				addDefaultProducer();
			} else {
				addProducer(cIndex.getProducer());				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void addDefaultProducer() {
		
		Producer p = new RandomProducer(modelInstance, mIndex, cIndex);

		AlwaysCreate ac = new AlwaysCreate(p);
		AlwaysRetrieve ar = new AlwaysRetrieve(modelInstance);
		RetrieveOrCreate roc = new RetrieveOrCreate(ac, ar);
		
		p.setStrategy(roc);
		
		this.producer = p;
		
	}

	// TODO : Make private
	private void addProducer(uk.ac.york.cs.mv525.modelgen.config.config.Producer producer) throws IOException {
		this.producer = convert(producer);
	}
	
	public void create() {
		
		producer.before();
		
		/* Start by creating the minimum amount of classes. */
		
		System.out.println("START GENERATE OBJECTS");
		
		EClass mClass = cIndex.getNextInstantiable();
		
		while(mClass != null) {
			EObject iObject = producer.create(mClass);

			if(mClass.getName().equals("EAnnotation")) {
				System.out.println();
			}
			if(mClass.getName().equals("EStringToStringMapEntry")) {
				System.out.println();
			}
			
			
			for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
				
				if (feature instanceof EAttribute && !iObject.eIsSet(feature) ) {
					
					producer.add(iObject, (EAttribute)feature);
					
				} else {
					//System.out.println(feature instanceof EReference);	
				}
			}			

			mClass = cIndex.getNextInstantiable();
		}
		

		System.out.println("END GENERATE OBJECTS");
		//if (true) return;
		
		/* Finish by linking the objects together. 
		 * This section may create more objects, 
		 * depending on the strategy used. */
				
		ArrayList<EObject> iObjects = modelInstance.dump();
		System.out.println("START GENERATE LINKS : " + iObjects.size());
		long c = 0;
		for(EObject iObject : iObjects) {
			c++;
			if ((c % 1000) == 0) {
				System.out.println(c);
			}
			if (iObject.eClass().getName().equals("EAnnotation")) {
				System.out.println("");
			}

			
			
			long f = 0;
			for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
				f++;
				
				
				if (feature.getEType() instanceof EClass && feature.isChangeable() ) {

					//System.out.println(" "+f);
					producer.link(iObject, (EReference) feature);
				}
			}
			
		
		}

		System.out.println("END GENERATE LINKS");
		producer.after();
	}	
	

	protected Producer convert(uk.ac.york.cs.mv525.modelgen.config.config.Producer root) throws IOException {
		Producer output = null;
		
		if (root == null){
			System.out.println("Using default producer");
			output = new RandomProducer(modelInstance, mIndex, cIndex);
			output.setStrategy(convert(null, output));
		}
		else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.EolProducer) {
			uk.ac.york.cs.mv525.modelgen.config.config.EolProducer pro = (uk.ac.york.cs.mv525.modelgen.config.config.EolProducer)root;			
			output = new EolProducer(pro.getLocation(), modelInstance, cIndex);
			output.setStrategy(convert(pro.getStrategy(), output));
			
			
		} else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.RandomProducer) {
			output = new RandomProducer(modelInstance, mIndex, cIndex);
			output.setStrategy(convert(root.getStrategy(), output));
		}
		else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.CombinedProducer) {

			uk.ac.york.cs.mv525.modelgen.config.config.CombinedProducer pro = (uk.ac.york.cs.mv525.modelgen.config.config.CombinedProducer)root;			
			output = new CombinedProducer();
			output.setStrategy(convert(root.getStrategy(), output));
			
			((CombinedProducer)output).overrideDefaultProducer(convert(pro.getFallback()) );
			for(uk.ac.york.cs.mv525.modelgen.config.config.Producer g : pro.getProducers()) {
				((CombinedProducer)output).addProducer(convert(g));
			}		
		} 
		
		return output;
	}
	
	protected Strategy convert(uk.ac.york.cs.mv525.modelgen.config.config.Strategy root, Producer pro) {
		Strategy output = null;
		
		if (root == null) {
			System.out.println("Using default strategy");
			output = new AlwaysRetrieve(modelInstance);			
		} else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy) {
			output = new AlwaysCreate(pro);
		} else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveStrategy) {
			output = new AlwaysRetrieve(modelInstance);
		} else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy) {
			uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy strat = (uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy)root;
			
			output = new RetrieveOrCreate(	convert(strat.getCreator(), pro),
											convert(strat.getRetriver(), pro));			
		}
		
		return output;
	}

	@Deprecated
	public Orchastrator() {					
	}
	
	@Deprecated
	public void addMetaModel(MetaModelIndex mmIndex) {
		mIndex = mmIndex;		
	}
	
	@Deprecated
	public void addModel(ModelInstance model) {
		modelInstance = model;		
	}

	@Deprecated
	public void addProducer(Producer producer) {
		this.producer = producer;
	}
		
}
