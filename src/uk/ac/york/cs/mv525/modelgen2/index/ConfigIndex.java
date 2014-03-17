package uk.ac.york.cs.mv525.modelgen2.index;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.javatuples.Pair;

import uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion;

public class ConfigIndex implements Index  {

	private HashMap<String, BigInteger> index = new HashMap<String, BigInteger>();
	private HashSet<String> excludes = new HashSet<String>();
	
	private int totalCount = 0;
	private BigInteger targetCount;
	//private BigInteger averageNonOverriddenCount;
	
	public ConfigIndex(ModelConfiguration config) {
				
		targetCount = config.getCount();

		for(Object _excl : config.getModelElemetExclusions()) {
			ModelElementExclusion excl = (ModelElementExclusion) _excl;
		    exclude(excl.getName());
		}	
		
		BigInteger num = BigInteger.ZERO;

		for(Object _over : config.getModelElementOverrides()) {
			ModelElementOverride over = (ModelElementOverride) _over;
			add(over.getName(), over.getCount());
			
			num = num.and(over.getCount());
		}
		
	}

	public void exclude(String name) {
		excludes.add(name);
	}
	private boolean isExcluded(String name) {
		return excludes.contains(name);
	}
	
	public void add(String name, int count) {
		add(name, BigInteger.valueOf(count));
	}

	/*
	 * Adds @count number of mObject to the index.
	 */
	public void add(String name, BigInteger count) {
		if (isExcluded(name)) return;
		
		if (index.containsKey(name)) {
			BigInteger old = index.get(name);
			index.put(name, count.add(old));
		} else {
			index.put(name, count);
		}
	}


	public void setMetaModel(MetaModelIndex mmIndex) {
		
		int count = 1; // calc from averageNonOverriddenCount and total MM elements
		
		for(EObject mObject : mmIndex.dump()) {
			add( ((EClass)mObject).getName(), count);
		}

	}

	/* TODO : Recator interfaces. */
	public void add(String name, EObject object) {
		// TODO Auto-generated method stub
		//throw new NotImplementedException();		
	}
	
	public BigInteger get(String name) {
		// TODO Auto-generated method stub
		if (index.containsKey(name)) {
			return index.get(name);
		} else if (excludes.contains(name)) {
			return null;
		} else {
			throw new IllegalStateException("Model Element '"+name+"' not found in configuration. Configuration is in an invalid state"); 
		}		
	}
	
	public LinkedList<Pair<String, BigInteger>> dump() {
		LinkedList<Pair<String, BigInteger>> list = new LinkedList<>();
		for(String key : index.keySet()) {
			list.add(new Pair<String, BigInteger>(key, index.get(key)));
		}
		
		return list;
	}
	
	// placeholder generator
	class FindWhatsNext {
		private int state;
		private int substate;
		LinkedList<Pair<String, BigInteger>> list;
		FindWhatsNext(LinkedList<Pair<String, BigInteger>> linkedList) {
			this.list = linkedList;
			state = 0;
			substate = 0;
		}
		EObject yield() {
			if (state < list.size())
			{
				Pair<EObject, Integer> o = null; //= list.get(state);
				if(substate < o.getValue1()) {
					substate++;
				} else {
					substate = 0;
					state++;
				}

				return o.getValue0();
				
			}
			return null;
		}
	}
	
	private FindWhatsNext g;
}
