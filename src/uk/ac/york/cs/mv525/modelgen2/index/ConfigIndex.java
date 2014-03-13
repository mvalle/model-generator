package uk.ac.york.cs.mv525.modelgen2.index;

import java.util.Hashtable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.javatuples.Pair;

public class ConfigIndex implements Index {

	private Hashtable<String, Pair<EObject, Integer>> index;
	private int totalCount = 0;
	private int targetCount = 0;
	
	@Override
	public void add(String name, EObject mObject) {
		add(name, mObject, 1);
	}

	/*
	 * Adds @count number of mObject to the index.
	 */
	public void add(String name, EObject mObject, int count) {
		if (count <= 0) return;
		
		if (index.containsKey(name)) {
			Pair<EObject, Integer> value = index.get(name);
			index.put(name, new Pair<EObject, Integer>(mObject, count+value.getValue1()));
		} else {
			index.put(name, new Pair<EObject, Integer>(mObject, count));
		}
		totalCount += count;
	}
	
	@Override
	public EObject get(String name) {
		if (index.containsKey(name)) {
			return index.get(name).getValue0();
		}
		return null;
	}

	public void setMetaModel(MetaModelIndex mmIndex) {
		// TODO Take into account total number of elements.
		int count = 1;
		for(EObject mObject : mmIndex.dump()) {
			if (get( ((EClass)mObject).getName() ) == null) {
				add( ((EClass)mObject).getName() , mObject, count);
			}
		}
		
	}

}
