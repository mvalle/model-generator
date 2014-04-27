package uk.ac.york.cs.mv525.modelgen.strategy;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;

public class AlwaysRetrieve implements Strategy {

	private ModelInstance model;
	HashMap<String, Integer> state = new HashMap<>();
	
	public AlwaysRetrieve(ModelInstance m) {
		model = m;
	}
	
	@Override
	public EObject retrieaveObject(EClass mType) {
		
		//if( mType.getName().equals("ENamedElement")) {
		//	System.out.println();
		//}
		
		Integer s = state.get(mType.getName());
		if(s == null) {
			s = Integer.valueOf(0);
			state.put(mType.getName(), s);
		}
		List<EObject> os = model.getObjects(mType.getName());
		
		
		if(os == null) return null;
		
		EObject output = output = os.get(s%os.size());
		
		if (s == Integer.MAX_VALUE) {
			s = 0;
		}
		
		state.put(mType.getName(), s+1);
		
		return output;
	}

	@Override
	public EObject retrieaveUncontainedObject(EClass mType) {
		int breaker = model.count(mType);
		
		EObject i = retrieaveObject(mType);
		
		while( i != null && i.eContainer() != null ) {
			i = retrieaveObject(mType);
			// retrieaveObject will cycle through all objects indefinatly
			if(breaker-- <= 0) {
				return null;
			}
		}
		
		return i;
	}

}
