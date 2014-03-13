package uk.ac.york.cs.mv525.modelgen2.generate;

import java.io.File;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;

import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.index.ProgramIndex;
import uk.ac.york.cs.mv525.modelgen2.parse.EolParser;

public class EolGenerator implements Generator {
	
	private ProgramIndex pIndex;
	
	public EolGenerator(String location, ModelInstance model) throws Exception {
		
		EolParser pParser = new EolParser();
		pIndex = pParser.parse(location, model);
		
		
	}
	
	@Override
	public void setResourceSet(Resource resourceSet) {
		// TODO Auto-generated method stub

	}

	@Override
	public EObject generate(EObject mObject) {
		// TODO Auto-generated method stub
		return null;
	}

}
