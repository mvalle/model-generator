package uk.ac.york.cs.mv525.modelgen2.strategy;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;


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
	
	public DefaultStrategy(String metamodel) {
		
		MetaModelParser mmParser = new MetaModelParser();
		mmIndex = mmParser.parse(metamodel);
		
	}
	
	
	//TODO: Maybe this should be refactored into a separate class 
	public void addConfiguration(String configuration) {
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
		// TODO Auto-generated method stub
		modelInstance = new ModelInstance(output);
		// init generator
		
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
		List<EObject> list;
		FindWhatsNext(List<EObject> list) {
			this.list = list;
			state = 0;
		}
		EObject yield() {
			if (state < list.size())
			{
			EObject o = list.get(state);
			state++;
			return o;
			}
			return null;
		}
	}
	
	private FindWhatsNext g = new FindWhatsNext(null);
	
}
