package uk.ac.york.cs.mv525.modelgen.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.javatuples.Pair;

import uk.ac.york.cs.mv525.modelgen.config.config.ModelConfiguration;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementExclusion;
import uk.ac.york.cs.mv525.modelgen.config.config.ModelElementOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.ReferenceOverride;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry;
import uk.ac.york.cs.mv525.modelgen.index.Index;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.InvalidConfigurationException;

public class Configuration implements Index {

	private HashMap<String, Long> index = new HashMap<String, Long>();
	private HashSet<String> excludes = new HashSet<String>();
	private HashMap<String, HashMap<String, StringPool>> pools = new HashMap<>();

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

			// TODO : It's supposed to multiple string pools!
			// Deal with StringPool
			StringPool sp = over.getStringPools();
			if (sp != null) {
			

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
			for(Object _ref : references) {
				ReferenceOverride ref = (ReferenceOverride) _ref;
				ref.
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
		return excludes.contains(name);
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
		if (index.containsKey(name)) {
			return index.get(name);
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
		LinkedList<Pair<String, Long>> list = new LinkedList<>();
		for (String key : index.keySet()) {
			list.add(new Pair<String, Long>(key, index.get(key)));
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
}
