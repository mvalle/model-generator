package uk.ac.york.cs.mv525.modelgen.strategy;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import uk.ac.york.cs.mv525.modelgen.generate.Generator;

public class AlwaysCreate implements Strategy {
	private Generator generator;

	public AlwaysCreate(Generator gen) {
		generator = gen;
	}
		
	@Override
	public EObject retrieaveObject(EClass mType) {
		return generator.create(mType);
		
	}
}
