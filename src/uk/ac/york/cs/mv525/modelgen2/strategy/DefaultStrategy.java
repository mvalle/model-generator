package uk.ac.york.cs.mv525.modelgen2.strategy;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.javatuples.Pair;


import uk.ac.york.cs.mv525.modelgen2.generate.Generator;
import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.index.ConfigIndex;
import uk.ac.york.cs.mv525.modelgen2.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.MetaModelParser;
import uk.ac.york.cs.mv525.modelgen2.parse.ConfigParser;

// TODO : This class feels like it's two classes in one
public class DefaultStrategy extends Strategy {

	protected MetaModelIndex mmIndex;
	protected ConfigIndex cIndex;
	
	protected ModelInstance modelInstance;
	
	public DefaultStrategy(String metamodel) throws IOException {
		
		MetaModelParser mmParser = new MetaModelParser();
		mmIndex = mmParser.parse(metamodel);
		
	}
	
	
	//TODO: Maybe this should be refactored into a separate class 
	public void addConfiguration(String configuration) throws IOException {
		ConfigParser cParser = new ConfigParser();
		cIndex = cParser.parse(configuration);
		cIndex.setMetaModel(mmIndex);
	}
		
	// TODO: Might want to split into multiple methods
	private EObject createElement(EObject mObject) {
		
		EObject iObject = null;
		for(Generator generator : generators) {
			iObject = generator.generate(mObject);
			if (iObject != null)
			{
				return iObject;
			}
		}
		
		
		return fallback.generate(mObject);
		
	}
	
	private EObject nextElement() {
		
		return g.yield();
		
	}
	
	@Override
	public void create(String output) {
		modelInstance = new ModelInstance(output);
		
		// TODO  g = new FindWhatsNext(cIndex.dump());
		
		EObject mObject = nextElement();
		while(mObject != null) {
			EObject iObject = createElement(mObject);
			modelInstance.add(iObject);
		}
		
	}

	@Override
	public ResourceSet getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	// placeholder generator
	class FindWhatsNext {
		private int state;
		private int substate;
		List<Pair<EObject, Integer>> list;
		FindWhatsNext(List<Pair<EObject, Integer>> list) {
			this.list = list;
			state = 0;
			substate = 0;
		}
		EObject yield() {
			if (state < list.size())
			{
				Pair<EObject, Integer> o = list.get(state);
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
