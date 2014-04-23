package uk.ac.york.cs.mv525.modelgen.strategy;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import uk.ac.york.cs.mv525.modelgen.producer.Producer;

public class AlwaysCreate implements Strategy {
	private Producer producer;
	
	public AlwaysCreate(Producer pro) {
		producer = pro;
	}
		
	@Override
	public EObject retrieaveObject(EClass mType) {
		
		EObject o = producer.create(mType);
		
		for(EStructuralFeature f : mType.getEStructuralFeatures()) {
			if( f instanceof EAttribute) {
				producer.add(o, (EAttribute)f);
			}
		}
		return o;		
		
	}

	@Override
	public EObject retrieaveUncontainedObject(EClass eType) {		
		return retrieaveObject(eType);
	}
}
