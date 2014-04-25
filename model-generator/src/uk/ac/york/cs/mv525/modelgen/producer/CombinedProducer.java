package uk.ac.york.cs.mv525.modelgen.producer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;

public class CombinedProducer extends Producer {
	
	protected Producer fallback;
	protected List<Producer> producers;
	private Strategy strategy;
	
	public CombinedProducer() {
		producers = new ArrayList<Producer>();
	}
	
	public CombinedProducer(Producer generator) {
		overrideDefaultProducer(generator);
		producers = new ArrayList<Producer>();
	}

	/*
	 * Overrides the default producer.
	 */
	public void overrideDefaultProducer(Producer generator) {
		fallback = generator;
	}
	
	/*
	 * Adds a producer. The producers will be called in
	 * the order they were added. 
	 */
	public void addProducer(Producer producer) {
		producers.add(producer);
	}
	
	
	//TODO: Might want to split into multiple methods
	public EObject create(EClass mClass) {
	
		EObject iObject = null;
		for(Producer producer : producers) {
			iObject = producer.create(mClass);
			if (iObject != null)
			{
				return iObject;
			}
		}
	
	
		return fallback.create(mClass);
	
	}

	public Object link(EObject iObject, EReference feature) {
		for(Producer producer : producers) {
			Object o = producer.link(iObject, feature);
			
			if (o != null) {
				return o;
			}
		}
		
		return fallback.link(iObject,  feature);
	}



	public Object add(EObject iObject, EAttribute feature) {
		for(Producer producer : producers) {
			Object o = producer.add(iObject, feature);
			
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
		for(Producer producer : producers) {						
			if (producer.before()) {
				return true;
			}
		}		
		return fallback.before();		
	}

	@Override
	public boolean after() {
		for(Producer producer : producers) {
			if (producer.after()) {
				return true;
			}
		}		
		return fallback.after();		
		
	}
	
}
