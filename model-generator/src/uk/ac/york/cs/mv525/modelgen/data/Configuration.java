package uk.ac.york.cs.mv525.modelgen.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.javatuples.Pair;

import uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.FileStringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPool;
import uk.ac.york.cs.mv525.modelgen.index.Index;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.InvalidConfigurationException;

public class Configuration implements Index {

	private HashMap<String, Long> index = new HashMap<String, Long>();
	private HashSet<String> excludes = new HashSet<String>();
	private HashMap<String, HashMap<String, StringPoolContainer>> pools = new HashMap<>();
	private HashMap<String, HashMap<String, Pair<Long, Long>>> refs = new HashMap<>();

	private long targetElementsCount;
	public MetaModelIndex metaModel;
	private ModelConfiguration config;
	private String configFileLocation = "";
	private StringPoolContainer defaultStringPool;

	public void setMetaModel(MetaModelIndex mmIndex) {
		metaModel = mmIndex;
		init();
	}

	public Configuration(ModelConfiguration config) {
		this.config = config;
	}

	private void init() {
		targetElementsCount = config.getTotalMinimumCount();

		handleExcludes();

		long num = handleOverrides();

		handleCounts(num);
	}

	private void handleCounts(long num) {
		// Deal with counts
		long overrideClassCount = index.size();
		long totalClassCount = metaModel.getCount();

		long remainingClassCount = totalClassCount - overrideClassCount;

		long countForEachNewElement = 0;

		if (remainingClassCount > 0 && num < targetElementsCount) {
			countForEachNewElement = (targetElementsCount - num) / remainingClassCount;
		}

		for (EClass mClass : metaModel.dump()) {
			if (!index.containsKey(mClass.getName())) { // don't duplicate
				add(mClass.getName(), countForEachNewElement);
			}
		}
		
		if (getNextState == null) {
			initialiseGetNextState();
		}
	}

	private long handleOverrides() {
		// Deal with overrides
		long num = 0;
		for (Object _over : config.getModelElementOverrides()) {
			ModelElementOverride over = (ModelElementOverride) _over;

			if (!metaModel.exists(over.getName())) {
				throw new InvalidConfigurationException(over.getName());
			}

			add(over.getName(), over.getMinimumCount());

			num += over.getMinimumCount();

			handleStringPools(over);
			handleReferences(over);

		}
		return num;
	}

	private void handleReferences(ModelElementOverride over) {
		// Deal with References
		EList<ReferenceOverride> references = over.getReferences();
		for (ReferenceOverride refOver : references) {
			
			if (!metaModel.exists(over.getName(), refOver.getName())) {
				throw new InvalidConfigurationException(over.getName()+"::"+refOver.getName());
			}
			
			String name = refOver.getName();
			Long min = refOver.getMinimumCount();
			Long max = refOver.getMaximumCount();
			
			if (!refs.containsKey(over.getName())) {
				refs.put(over.getName(),
						new HashMap<String, Pair<Long, Long>>());
			}
			HashMap<String, Pair<Long, Long>> ref = refs
					.get(over.getName());
			ref.put(name, new Pair<Long, Long>(min, max));
		}
	}

	private void handleStringPools(ModelElementOverride over) {
		// Deal with StringPool
		EList<StringPool> spools = over.getStringPools();
		for (StringPool sp : spools) {
			//StringPool sp = (StringPool) _sp;

			if (!metaModel.exists(over.getName(), sp.getName())) {
				throw new InvalidConfigurationException(over.getName() + "::" + sp.getName());
			}

			if (!pools.containsKey(over.getName())) {
				pools.put(over.getName(), new HashMap<String, StringPoolContainer>());
			}
			
			HashMap<String, StringPoolContainer> pool = pools.get(over.getName());
			
			
			if (sp instanceof EmbeddedStringPool) {
				EmbeddedStringPool esp = (EmbeddedStringPool)sp; 
				pool.put(sp.getName(), new StringPoolContainer(esp));
			} else if (sp instanceof FileStringPool) {
				FileStringPool fsp = (FileStringPool)sp; 
				pool.put(sp.getName(), new StringPoolContainer(fsp.getLocation(), configFileLocation));
			}
			
		}
		StringPool sp = config.getDefaultStringPool();
		if (sp instanceof EmbeddedStringPool) {
			EmbeddedStringPool esp = (EmbeddedStringPool)sp; 
			defaultStringPool = new StringPoolContainer(esp);
		} else if (sp instanceof FileStringPool) {
			FileStringPool fsp = (FileStringPool)sp; 
			defaultStringPool = new StringPoolContainer(fsp.getLocation(), configFileLocation);
		}
	}

	private void handleExcludes() {
		// Deal with exclusions
		EList<ModelElementExclusion> excls = config.getModelElemetExclusions();
		for (ModelElementExclusion excl : excls) {

			if (metaModel.exists(excl.getName())) {

				exclude(excl.getName());
			} else {
				System.err.println(excl.getName());
				throw new InvalidConfigurationException(excl.getName());
			}
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
		
		//System.out.println("Configuration::dump()");
		
		LinkedList<Pair<String, Long>> list = new LinkedList<>();
		for (String key : index.keySet()) {
			list.add(new Pair<String, Long>(key, index.get(key)));
		}

		
		return list;
	}

	public void resetState() {
		initialiseGetNextState();
	}
	
	private void initialiseGetNextState() {
		getNextState = new GetNextState(dump());
	}

	public EClass getNext() {
		if (getNextState == null) {
			initialiseGetNextState();
		}
		
		String modelName = getNextState.next();
		if (modelName != null) {
			
			return (EClass) metaModel.get(modelName);
		}
		return null;
	}
	
	/**
	 * Skips all abstract and interface classes.
	 * */
	public EClass getNextInstantiable() {		
		
		//System.out.println("---");
		
		EClass ec = null;
		do {
			ec = getNext();
			/*
			System.out.println(ec);
			if (ec != null) {
				System.out.println(ec.isAbstract());
				System.out.println(ec.isInterface());
				
				System.out.println(ec != null && !ec.isAbstract() && !ec.isInterface());
				System.out.println(ec != null && ec.isAbstract() && ec.isInterface());
				System.out.println(ec != null && (ec.isAbstract() || ec.isInterface()));
			}
		
			System.out.println("---");
	*/
		} while (ec != null && (ec.isAbstract() || ec.isInterface()));
		
		return ec;		
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

		HashMap<String, StringPoolContainer> classPools = pools.get(className);

		if (classPools != null) {

			StringPoolContainer pool = classPools.get(attrName);

			if (pool != null) {

				return pool.get();
			}

		} else if (defaultStringPool != null) {
			return defaultStringPool.get();
		}

		return null;
	}
	
	public uk.ac.york.cs.mv525.modelgen.config.config.Producer getProducer() {
		return config.getProducer();
	}

	public long getMinimumReferences(EReference mReference) {
				
		//EClass mClass = (EClass)mReference.eContainingFeature();
		
		//EClass mClass2 = mReference.eContainer().eClass();
		EClass mClass = (EClass)mReference.eContainer();
		
		HashMap<String, Pair<Long, Long>> ref = refs.get(mClass.getName());
		
		if (ref != null && ref.containsKey(mReference.getName())) {			
			return ref.get(mReference.getName()).getValue0();
		}
		
		return -1;
	}

	public long getMaximumReferences(EReference mReference) {
		
		//EClass mClass = (EClass)mReference.eContainingFeature();
		
		//EClass mClass = mReference.eContainer().eClass();
		EClass mClass = (EClass)mReference.eContainer();
		
		
		HashMap<String, Pair<Long, Long>> ref = refs.get(mClass.getName());
		
		if (ref != null && ref.containsKey(mReference.getName())) {			
			return ref.get(mReference.getName()).getValue1();
		}
		
		return -1;
	}
	public long getMinimumCount() {
		return targetElementsCount;
	}

	public String getDirectory() {
		return configFileLocation;
	}
	
	public void setDirectory(String dir) {
		configFileLocation = dir;
	}

	public long getMinimumCount(EClass mClass) {
		Long count = index.get(mClass.getName());
		if(count == null){
			return 0;			
		}
		return count;
	}

}
