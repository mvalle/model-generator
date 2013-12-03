package uk.ac.york.cs.mv525.modelgen.create;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;

import uk.ac.york.cs.mv525.modelgen.ResourceOperator;
import uk.ac.york.cs.mv525.modelgen.index.Collection;
import uk.ac.york.cs.mv525.modelgen.parse.ProgramParser;

public class ModelInstance extends ResourceOperator {

	private Collection iIndex; // Index of the model elements
	private HashMap<String, EClass> mIndex; // Index of the meta-model elements
	
	private EPackage ePackage;
	private Resource resource;
	private EList<EObject> instance;
	
	private EolContext eolContext;
	
	public ModelInstance(HashMap<String, EClass> mClasses) throws Exception{
		mIndex = mClasses;
		iIndex = new Collection();
		
		initialisIIndex();
		
	}

	//initilise iindex with all empty arrays fom mindex
	//that way the programparser can find a place to ime
	//add programparser into this class.
	private void initialisIIndex() {
		for(EClass mClass : mIndex.values()) {
			iIndex.createIndex(mClass);
		}
	}
	
	public void initiliseInstance(String suffix, String modelLocation, String programLocation, EPackage ePackage) throws Exception {

		resource = getResourceSet(suffix).createResource(
				URI.createFileURI(getModelDir(modelLocation)));
		
		instance = resource.getContents();
		
		this.ePackage = ePackage;
		
		ProgramParser pp = new ProgramParser(iIndex, resource, ePackage);
		
		eolContext = pp.parse(programLocation);
		
	}
	
	public EObject create(EClass mClass) throws EolRuntimeException {

		EFactory iClassGenerator = ePackage.getEFactoryInstance();
		
		EolOperation createOp = iIndex.getCreateOperation(mClass);
		EObject iObject = iClassGenerator.create(mClass);

		add(iObject);
		
		if (createOp != null) {

			Object o = createOp.execute(iObject, Collections.emptyList(), eolContext);
			
			System.out.println(mClass.getName() + " " + o);
			
		}
		
		
		
		
		return iObject;
	}
	
	
	
	
	
	
	
	public void add(EObject iObject) {
		iIndex.add(iObject);
		instance.add(iObject);
	}
	
	//?
	public EObject get(EClass mClass) {
		if(mIndex.containsKey(mClass.eClass().getName())) {
			return iIndex.get(mClass);
		}
		// throw not in excepion
		return null;
	}
	
	public EObject get(EObject iObject) {
		return get(iObject.eClass());
	}
	
	public Iterable<EObject> iterable(EClass mClass) {
		return iIndex.iterable(mClass);
	}
	
	public Iterable<EObject> iterable(EObject iObject) {
		return iterable(iObject.eClass());
	}

	public Iterable<EObject> mAll() {
		return null;//mIndex.all();
	}
	
	public void save() throws IOException {
		resource.save(null);
	}

	public Resource getResource() {
		return resource;
	}
	
	public Iterable<EObject> getEClasses() {
		return iIndex.getAll("EClass");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}













