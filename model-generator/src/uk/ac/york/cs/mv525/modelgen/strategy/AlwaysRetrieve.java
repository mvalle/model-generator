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
		Integer i = state.get(mType.getName());
		if(i == null) {
			i = Integer.valueOf(0);
			state.put(mType.getName(), i);
		}
		List<EObject> os = model.getObjects(mType.getName());
		
		return os.get(i++%os.size());		
	}

}
