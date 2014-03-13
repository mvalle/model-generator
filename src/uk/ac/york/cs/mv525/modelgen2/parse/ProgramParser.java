package uk.ac.york.cs.mv525.modelgen2.parse;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.types.EolModelElementType;

import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.index.Index;
import uk.ac.york.cs.mv525.modelgen2.index.ProgramIndex;

/*
 * TODO : Create ModelContextParser interface.
 */
public class ProgramParser  implements Parser {

	
	public ProgramIndex parse(String location, ModelInstance model) throws IOException, EolRuntimeException {
		EolModule mModule;
		
		mModule = new EolModule();
		try {
			mModule.parse(new File(location));
		} catch (Exception e) {
			throw new IOException("EOL program not found.");
		}
		
		for (ParseProblem problem : mModule.getParseProblems()) {
			System.err.println(problem.getReason());
		}
		
		ProgramIndex pIndex = new ProgramIndex();
		
		EolContext context = (EolContext) mModule.createContext();
		context.getModelRepository().addModel(
				new InMemoryEmfModel("X", model.getResource(), model.getEPackage()));
		
		for (EolOperation op : mModule.getOperations()) {
			EolModelElementType type = (EolModelElementType) op.getContextType(context);
			
			String mTypeName = type.getName();
			String mOpName = op.getName();
			
			if (!EolAnnotationsUtil.getBooleanAnnotationValue(op.getAst(), "disabled", context, false, true)) {
				
				pIndex.add(mTypeName, mOpName, op);
				
			}
		}
		
		return pIndex;

	}

	@Override
	public Index parse(String location) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
