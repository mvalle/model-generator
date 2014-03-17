package uk.ac.york.cs.mv525.modelgen2.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.javatuples.Pair;

import uk.ac.york.cs.mv525.modelgen.ResourceOperator;
import uk.ac.york.cs.mv525.modelgen.index.Collection;
import uk.ac.york.cs.mv525.modelgen.parse.ProgramParser;

public class ModelInstance extends ResourceOperator {

	HashMap<String, ArrayList<EObject>> iIndex; // Index of the model elements
	
	private Resource resource;
	
	public ModelInstance(String location) {
		String suffix;
		{
			String[] s = location.split("\\.");
			assert(s.length >=2);
			suffix = s[s.length-1];
		}
		
		resource = getResourceSet(suffix).createResource(
					URI.createFileURI(location));
		
		iIndex = new HashMap<>();	
	}
	
	public void add(EObject iObject) {
		if(iIndex.containsKey(iObject.eClass().getName())) {
			ArrayList<EObject> o = iIndex.get(iObject.eClass().getName());
			o.add(iObject);
			
		} else {
			ArrayList<EObject> o = new ArrayList<EObject>();
			o.add(iObject);
			iIndex.put(iObject.eClass().getName(), o);
		}
		
		resource.getContents().add(iObject);
	}
		
	public EObject get(String name) {
		ArrayList<EObject> o = iIndex.get(name);
		if (o != null) {
			return o.get(0);
		}
		
		return null;
	}
	

	public Resource getResource() {
		return resource;
	}

	public long getCount() {
		long count = 0;
		for(ArrayList<EObject> l : iIndex.values()) {
			count += l.size();
		}
		
		long size = resource.getContents().size();
		assert(size == count);
		
		return count;
	}

	public void save() throws IOException {
		resource.save(null);
	}
}