package uk.ac.york.cs.mv525.modelgen2.index;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride;

public class ConfigIndex {

	private HashMap<String, BigInteger> index = new HashMap<String, BigInteger>();
	private HashSet<String> excludes = new HashSet<String>();
	
	private int totalCount = 0;
	private BigInteger targetCount;
	//private BigInteger averageNonOverriddenCount;
	
	public ConfigIndex(ModelConfiguration config) {
				
		targetCount = config.getCount();

		//for(Object _excl : config.getModelElemetExclusions())
		//    ModelElementExclusion excl = (ModelElementExclusion) _excl;
		//    exclude(excl.getName());
		//}	
		
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

}
