package uk.ac.york.cs.mv525.modelgen.strategy;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import uk.ac.york.cs.mv525.modelgen.generate.Generator;

public class AlwaysCreate implements Strategy {
	private Generator generator;
	
	public AlwaysCreate(Generator gen) {
		generator = gen;
	}
		
	@Override
	public EObject retrieaveObject(EClass mType) {
		
		EObject o = generator.create(mType);
		
		for(EStructuralFeature f : mType.getEStructuralFeatures()) {
			if( f instanceof EAttribute) {
				generator.add(o, (EAttribute)f);
			}
		}
		return o;		
		
	}

	@Override
	public EObject retrieaveUncontainedObject(EClass eType) {		
		return retrieaveObject(eType);
	}
}
