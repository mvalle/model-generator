package uk.ac.york.cs.mv525.modelgen2.strategy;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;

import uk.ac.york.cs.mv525.modelgen2.generate.Generator;

public abstract class Strategy {
	
	protected Generator fallback;
	protected List<Generator> generators;
		
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
	
	public abstract void create(String output);
	public abstract ResourceSet getModel();
}
