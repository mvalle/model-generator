package uk.ac.york.cs.mv525.modelgen.data;

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
import uk.ac.york.cs.mv525.modelgen.index.Index;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.InvalidConfigurationException;

public class Configuration implements Index  {

	private HashMap<String, BigInteger> index = new HashMap<String, BigInteger>();
	private HashSet<String> excludes = new HashSet<String>();
	
	//private int totalCount = 0;
	private BigInteger targetElementsCount;
	//private BigInteger averageNonOverriddenCount;
	private MetaModelIndex metaModel;
	private ModelConfiguration config;
	
	public Configuration(ModelConfiguration config, MetaModelIndex mmIndex) {
		metaModel = mmIndex;
		this.config = config;
		
		init();		
	}

	public void setMetaModel(MetaModelIndex mmIndex) {
		metaModel = mmIndex;
		init();
	}

	public Configuration(ModelConfiguration config) {
		this.config = config;
	}
	
	private void init() {
		targetElementsCount = config.getCount();

		for(Object _excl : config.getModelElemetExclusions()) {			
			ModelElementExclusion excl = (ModelElementExclusion) _excl;
			
			if (metaModel.exists(excl.getName())) {
			
				exclude(excl.getName());
			} else {
				throw new InvalidConfigurationException();
			}
		}	
		
		BigInteger num = BigInteger.ZERO;
		for(Object _over : config.getModelElementOverrides()) {			
			ModelElementOverride over = (ModelElementOverride) _over;
			
			if (metaModel.exists(over.getName())) {
			
				add(over.getName(), over.getCount());
			
				num = num.and(over.getCount());
			} else {
				throw new InvalidConfigurationException();
			}
		}
		long overrideClassCount = index.size();
		long totalClassCount = metaModel.getCount();
		
		long remainingClassCount = totalClassCount - overrideClassCount;
		
		BigInteger countForEachNewElement = BigInteger.ZERO;
		
		if(remainingClassCount > 0 && num.compareTo(targetElementsCount) > 0 ) {
			countForEachNewElement = BigInteger.valueOf(remainingClassCount).divide(targetElementsCount.subtract(num));
		}
	
		
		for(EObject mObject : metaModel.dump()) {
			add( ((EClass)mObject).getName(), countForEachNewElement);
		}

		if(getNextState == null) {
			initialiseGetNextState();
		}
	}
	
	public void exclude(String name) {
		excludes.add(name);
	}
	private boolean isExcluded(String name) {
		return excludes.contains(name);
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
	
	public BigInteger get(String name) {
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
	
	private void initialiseGetNextState() {
		getNextState = new GetNextState(dump());
	}
	
	public EObject getNext() {
		String modelName = getNextState.next();
		if (modelName != null) {
			return metaModel.get(modelName);
		}
		return null;
	}
	
	protected class GetNextState {
		private int state;
		private long substate;
		LinkedList<Pair<String, BigInteger>> list;
		
		GetNextState(LinkedList<Pair<String, BigInteger>> linkedList) {
			this.list = linkedList;
			state = 0;
			substate = 0;
		}
		
		String next() {
			
			if (state < list.size())
			{
				
				Pair<String, BigInteger> o = list.get(state);
				
				if(o.getValue1().compareTo(BigInteger.valueOf(substate)) < 0) {				
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
	
	private GetNextState getNextState = null;
}
