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
import uk.ac.york.cs.mv525.modelgen.generate.CombinedGenerator;
import uk.ac.york.cs.mv525.modelgen.generate.EolGenerator;
import uk.ac.york.cs.mv525.modelgen.generate.Generator;
import uk.ac.york.cs.mv525.modelgen.generate.RandomGenerator;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.strategy.AlwaysCreate;
import uk.ac.york.cs.mv525.modelgen.strategy.AlwaysRetrieve;
import uk.ac.york.cs.mv525.modelgen.strategy.RetrieveOrCreate;
import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;
// TODO : Rename to ...
public class Orchastrator {

	protected MetaModelIndex mIndex;
	protected Configuration cIndex;
	
	protected ModelInstance modelInstance;
	
	protected Generator generator;
	
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
			if (cIndex.getGenerator() == null) {
				addDefaultGenerator();
			} else {
				addGenerator(cIndex.getGenerator());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void addDefaultGenerator() {
		
		Generator g = new RandomGenerator(modelInstance, mIndex, cIndex);

		AlwaysCreate ac = new AlwaysCreate(g);
		AlwaysRetrieve ar = new AlwaysRetrieve(modelInstance);
		RetrieveOrCreate roc = new RetrieveOrCreate(ac, ar);
		
		g.setStrategy(roc);
		
		this.generator = g;
		
	}

	// TODO : Make private
	public void addGenerator(uk.ac.york.cs.mv525.modelgen.config.config.Generator generator) throws IOException {
		this.generator = convert(generator);
	}
	
	public void create() {
		
		generator.before();
		
		/* Start by creating the minimum amount of classes. */
		
		EClass mClass = cIndex.getNextInstantiable();
		
		while(mClass != null) {
			EObject iObject = generator.create(mClass);
			
			for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
				if (feature instanceof EAttribute ) {
					generator.add(iObject, (EAttribute)feature);
				} else {
					System.out.println(feature instanceof EReference);	
				}
			}			

			mClass = cIndex.getNextInstantiable();
		}
		
		/* Finish by linking the objects together. 
		 * This section may create more objects, 
		 * depending on the strategy used. */
		
		// TODO : getNext from modelInstance.
		
		ArrayList<EObject> iObjects = modelInstance.dump();
		
		for(EObject iObject : iObjects) {
			
			if (iObject.eClass().getName().equals("ModelConfiguration")) {
				System.out.println("");
			}
			
			for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
				if (feature.getEType() instanceof EClass ) {
					generator.link(iObject, (EReference) feature);
				}
			}
			
		
		}
			
		generator.after();
	}	
	

	protected Generator convert(uk.ac.york.cs.mv525.modelgen.config.config.Generator root) throws IOException {
		Generator output = null;

		if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator) {
			uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator gen = (uk.ac.york.cs.mv525.modelgen.config.config.EolGenerator)root;			
			output = new EolGenerator(gen.getLocation(), modelInstance, cIndex);
			output.setStrategy(convert(gen.getStrategy(), output));
			
			
		} else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.RandomGenerator) {
			output = new RandomGenerator(modelInstance, mIndex, cIndex);
			output.setStrategy(convert(root.getStrategy(), output));
		}
		else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator) {

			uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator gen = (uk.ac.york.cs.mv525.modelgen.config.config.CombinedGenerator)root;			
			output = new CombinedGenerator();
			output.setStrategy(convert(root.getStrategy(), output));
			
			((CombinedGenerator)output).overrideDefaultGenerator(convert(gen.getFallback()) );
			for(uk.ac.york.cs.mv525.modelgen.config.config.Generator g : gen.getGenerators()) {
				((CombinedGenerator)output).addGenerator(convert(g));
			}		
		} else {
			System.err.println("Unable to find generator");
		}
		
		return output;
	}
	
	protected Strategy convert(uk.ac.york.cs.mv525.modelgen.config.config.Strategy root, Generator gen) {
		Strategy output = null;
		
		if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.AlwaysCreateStrategy) {
			output = new AlwaysCreate(gen);
		} else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveStrategy) {
			output = new AlwaysRetrieve(modelInstance);
		} else if (root instanceof uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy) {
			uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy strat = (uk.ac.york.cs.mv525.modelgen.config.config.AlwaysRetrieveOrCreateStrategy)root;
			
			output = new RetrieveOrCreate(	convert(strat.getCreator(), gen),
											convert(strat.getRetriver(), gen));			
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
	public void addGenerator(Generator generator) {
		this.generator = generator;
	}
		
}
