package uk.ac.york.cs.mv525.modelgen.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.javatuples.Pair;

import uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelGeneration;
import uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry;
import uk.ac.york.cs.mv525.modelgen.config.config.impl.ModelConfigurationImpl;
import uk.ac.york.cs.mv525.modelgen.index.Index;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.InvalidConfigurationException;

public class Configuration implements Index {

	private HashMap<String, Long> index = new HashMap<String, Long>();
	private HashSet<String> excludes = new HashSet<String>();
	private HashMap<String, HashMap<String, StringPool>> pools = new HashMap<>();
	private HashMap<String, HashMap<String, Pair<Long, Long>>> refs = new HashMap<>();

	// private int totalCount = 0;
	private long targetElementsCount;
	// private BigInteger averageNonOverriddenCount;
	private MetaModelIndex metaModel;
	private ModelConfiguration config;

	public Configuration(ModelConfiguration config, MetaModelIndex mmIndex) {
		metaModel = mmIndex;
		this.config = config;
		
		init();
	}

	public void setMetaModel(String metaModelLocation) {
		config.setMetaModelLocation(metaModelLocation);
		metaModel = ((ModelConfigurationImpl)config).getMM();
	}
	public void setMetaModel(MetaModelIndex mmIndex) {
		metaModel = mmIndex;
		init();
	}

	public Configuration(ModelConfiguration config) {
		this.config = config;
	}

	private void init() {
		targetElementsCount = config.getTotalMinimumCount();

		//
		for (Object _excl : config.getModelElemetExclusions()) {
			ModelElementExclusion excl = (ModelElementExclusion) _excl;

			if (metaModel.exists(excl.getName())) {

				exclude(excl.getName());
			} else {
				System.err.println(excl.getName());
				throw new InvalidConfigurationException();
			}
		}

		//
		long num = 0;
		for (Object _over : config.getModelElementOverrides()) {
			ModelElementOverride over = (ModelElementOverride) _over;

			if (!metaModel.exists(over.getName())) {
				throw new InvalidConfigurationException();
			}

			add(over.getName(), over.getMinimumCount());

			num += over.getMinimumCount();

			// Deal with StringPool
			EList spools = over.getStringPools();
			for (Object _sp : spools) {
				StringPool sp = (StringPool) _sp;

				if (!metaModel.exists(over.getName(), sp.getName())) {
					throw new InvalidConfigurationException();
				}

				if (!pools.containsKey(over.getName())) {
					pools.put(over.getName(), new HashMap<String, StringPool>());
				}
				HashMap<String, StringPool> pool = pools.get(over.getName());
				pool.put(sp.getName(), sp);
			}

			EList references = over.getReferences();
			for (Object _refOver : references) {
				ReferenceOverride refOver = (ReferenceOverride) _refOver;
				String name = refOver.getName();
				long min = refOver.getMinimumCount();
				long max = refOver.getMaximumCount();
				Pair<Long, Long> range = new Pair<Long, Long>(min, max);

				if (!refs.containsKey(over.getName())) {
					refs.put(over.getName(),
							new HashMap<String, Pair<Long, Long>>());
				}
				HashMap<String, Pair<Long, Long>> ref = refs
						.get(over.getName());
				ref.put(name, range);
			}

		}

		//
		long overrideClassCount = index.size();
		long totalClassCount = metaModel.getCount();

		long remainingClassCount = totalClassCount - overrideClassCount;

		long countForEachNewElement = 0;

		if (remainingClassCount > 0 && num > targetElementsCount) {
			countForEachNewElement = remainingClassCount
					/ (targetElementsCount - num);
		}

		for (EObject mObject : metaModel.dump()) {
			add(((EClass) mObject).getName(), countForEachNewElement);
		}

		if (getNextState == null) {
			initialiseGetNextState();
		}
	}

	public void exclude(String name) {
		excludes.add(name);
	}

	private boolean isExcluded(String name) {
		
		boolean excluded = false;
		for(Object o : config.getModelElemetExclusions()) {
			ModelElementExclusion e = (ModelElementExclusion)o;
			if(e.getName().equals(name) ) {
				excluded = true;
				break;
			}
		}
		
		assert(excludes.contains(name) == excluded);
		
		return excluded;
	}

	/*
	 * Adds @count number of mObject to the index.
	 */
	public void add(String name, long count) {
		if (isExcluded(name))
			return;

		if (index.containsKey(name)) {
			long old = index.get(name);
			index.put(name, count + old);
		} else {
			index.put(name, count);
		}
	}

	public long get(String name) {
		
		long c = 0;
		for(Object o: config.getModelElementOverrides()) {
			ModelElementOverride m = (ModelElementOverride) o;
			if (m.getName().equals(name)) {
				c = m.getMinimumCount();
				break;
			}
		}
		
		if (index.containsKey(name)) {
			
			assert(index.get(name) == c);
			return c;
			//return index.get(name);
			
		} else if (excludes.contains(name)) {
			return 0;// note
		} else {
			throw new IllegalStateException(
					"Model Element '"
							+ name
							+ "' not found in configuration. Configuration is in an invalid state");
		}
	}

	public LinkedList<Pair<String, Long>> dump() {
		LinkedList<Pair<String, Long>> list2 = new LinkedList<>();
		for(Object o : config.getModelElementOverrides()) {
			ModelElementOverride m = (ModelElementOverride) o;
			list2.add(new Pair<String, Long>(m.getName(), m.getMinimumCount()));
		}
		
		LinkedList<Pair<String, Long>> list = new LinkedList<>();
		for (String key : index.keySet()) {
			list.add(new Pair<String, Long>(key, index.get(key)));
		}

		assert(list.size() == list2.size());
		assert(list2.contains(list.get(0)));
		assert(list.contains(list2.get(0)));
		assert(list.contains(list2.get(list2.size()-1)));
		assert(list2.contains(list.get( list.size()-1)));
		
		
		return list2;
	}

	public void resetState() {
		initialiseGetNextState();
	}
	
	private void initialiseGetNextState() {
		getNextState = new GetNextState(dump());
	}

	public EObject getNext() {
		if (getNextState == null) {
			initialiseGetNextState();
		}
		
		String modelName = getNextState.next();
		if (modelName != null) {
			return metaModel.get(modelName);
		}
		return null;
	}

	protected class GetNextState {
		private int state;
		private long substate;
		LinkedList<Pair<String, Long>> list;

		GetNextState(LinkedList<Pair<String, Long>> linkedList) {
			this.list = linkedList;
			state = 0;
			substate = 0;
		}

		String next() {

			if (state < list.size()) {

				Pair<String, Long> o = list.get(state);

				if (o.getValue1() > substate) {
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

	public String getString(EStructuralFeature mAttr) {
		String attrName = mAttr.getName();
		String className = mAttr.getEContainingClass().getName();

		HashMap<String, StringPool> classPools = pools.get(className);

		if (classPools != null) {

			StringPool pool = classPools.get(attrName);

			if (pool != null) {

				StringPoolEntry entry = pool.get();
				if (entry != null) {
					return entry.getString();
				}
			}

		} else {
			StringPool pool = config.getDefaultStringPool();
			if (pool != null) {
				return pool.get().getString();
			}
		}

		return "";
	}
	
	

	public void create(String outputLocation) {
		ModelGeneration generator = config.getModelGeneration();
		config.setOutputModelLocation(outputLocation);
		
		generator.before();
		
		/* Start by creating the minimum amount of classes. */
		
		EClass mClass = (EClass) getNext();
		
		while(mClass != null) {
			EObject iObject = generator.create(mClass);
			
			for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
				if (feature.getEType() instanceof EClass ) {
					//generator.link(iObject, (EReference) feature);
				} else {				
					generator.add(iObject, feature);				
				}
			}			

			mClass = (EClass) getNext();
		}
		
		/* Finish by linking the objects together. 
		 * This section may create more objects, 
		 * depending on the strategy used. */
		
		resetState();
		mClass = (EClass) getNext();
		
		while(mClass != null) {
			EObject iObject = ((ModelConfigurationImpl)config).getModel().get(mClass.getName());
			
			if (iObject != null) {
				for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
					if (feature.getEType() instanceof EClass ) {
						generator.link(iObject, (EReference) feature);
					}
				}
			}
			mClass = (EClass) getNext();
		}
		
		
	}
	
	@Deprecated
	public void create(ModelInstance model) {
		ModelGeneration generator = config.getModelGeneration();
		((ModelConfigurationImpl)config).iModel = model;
		
		generator.before();
		
		/* Start by creating the minimum amount of classes. */
		
		EClass mClass = (EClass) getNext();
		
		while(mClass != null) {
			EObject iObject = generator.create(mClass);
			
			for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
				if (feature.getEType() instanceof EClass ) {
					//generator.link(iObject, (EReference) feature);
				} else {				
					generator.add(iObject, feature);				
				}
			}			

			mClass = (EClass) getNext();
		}
		
		/* Finish by linking the objects together. 
		 * This section may create more objects, 
		 * depending on the strategy used. */
		
		resetState();
		mClass = (EClass) getNext();
		
		while(mClass != null) {
			EObject iObject = model.get(mClass.getName());
			
			if (iObject != null) {
				for(EStructuralFeature feature : iObject.eClass().getEAllStructuralFeatures() ) {
					if (feature.getEType() instanceof EClass ) {
						generator.link(iObject, (EReference) feature);
					}
				}
			}
			mClass = (EClass) getNext();
		}
		
		
	}

}
