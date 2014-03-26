package uk.ac.york.cs.mv525.modelgen.generate;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;

public class CombinedGenerator implements Generator {
	protected Generator fallback;
	protected List<Generator> generators;
	private Strategy strategy;
	
	public CombinedGenerator() {
		generators = new ArrayList<Generator>();
	}
	
	public CombinedGenerator(Generator generator) {
		overrideDefaultGenerator(generator);
		generators = new ArrayList<Generator>();
	}

	/*
	 * Overrides the default generator.
	 */
	public void overrideDefaultGenerator(Generator generator) {
		fallback = generator;
	}
	
	/*
	 * Adds a generator. The generators will be called in
	 * the order they were added. 
	 */
	public void addGenerator(Generator generator) {
		generators.add(generator);
	}
	
	
	//TODO: Might want to split into multiple methods
	public EObject create(EClass mClass) {
	
		EObject iObject = null;
		for(Generator generator : generators) {
			iObject = generator.create(mClass);
			if (iObject != null)
			{
				return iObject;
			}
		}
	
	
		return fallback.create(mClass);
	
	}

	public Object link(EObject iObject, EReference feature) {
		for(Generator generator : generators) {
			Object o = generator.link(iObject, feature);
			
			if (o != null) {
				return o;
			}
		}
		
		return fallback.link(iObject,  feature);
	}



	public Object add(EObject iObject, EStructuralFeature feature) {
		for(Generator generator : generators) {
			Object o = generator.add(iObject, feature);
			
			if (o != null) {
				return o;
			}
		}
		
		return fallback.add(iObject,  feature);		
	}
	
	@Override
	public void setStrategy(Strategy s) {
		strategy = s;
		
	}

	@Override
	public boolean before() {
		for(Generator generator : generators) {						
			if (generator.before()) {
				return true;
			}
		}		
		return fallback.before();		
	}

	@Override
	public boolean after() {
		for(Generator generator : generators) {
			if (generator.after()) {
				return true;
			}
		}		
		return fallback.after();		
		
	}
	
}
