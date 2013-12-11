package uk.ac.york.cs.mv525.modelgen.parse;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.types.EolModelElementType;

import uk.ac.york.cs.mv525.modelgen.ResourceOperator;
import uk.ac.york.cs.mv525.modelgen.create.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.Collection;

public class ProgramParser extends ResourceOperator{

	private Collection mCollection;
	private Resource resource;
	private EPackage ePackage;
	
	private EolModule mModule;
	public ProgramParser(Collection mCollection, Resource resource, EPackage ePackage) throws IOException {
		this.mCollection = mCollection;
		this.resource = resource;
		this.ePackage = ePackage;
		
	}
	
	public ProgramParser(Collection mCollection, ModelInstance iInstance) {
		this.mCollection = mCollection;
		resource = iInstance.getResource();
		ePackage = iInstance.getEPackage();
	}
	
	public EolContext parse(String location) throws Exception {
		
		mModule = new EolModule();
		mModule.parse(new File(location));
		
		for (ParseProblem problem : mModule.getParseProblems()) {
			System.err.println(problem.getReason());
		}
		
		return processModules();
	}
	
	private EolContext processModules() throws EolRuntimeException {	

		EolContext context = (EolContext) mModule.createContext();
		context.getModelRepository().addModel(new InMemoryEmfModel("X", resource, ePackage));
		
		for (EolOperation op : mModule.getOperations()) {
			EolModelElementType type = (EolModelElementType) op.getContextType(context);
			
			String mTypeName = type.getName();
			String mOpName = op.getName();
			
			if (!EolAnnotationsUtil.getBooleanAnnotationValue(op.getAst(), "disabled", context, false, true)) {
				
				mCollection.addOperation(mTypeName, mOpName, op);
				
			}
		}
		
		return context;
	}
}


















