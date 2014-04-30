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
import org.eclipse.epsilon.eol.types.EolType;

import uk.ac.york.cs.mv525.modelgen.index.EolIndex;

/*
 * TODO : Create ModelContextParser interface.
 */
public class EolParser implements Parser {

	private Resource resource;
	private EPackage ePackage;

	public EolParser(Resource resource, EPackage ePackage) {
		this.resource = resource;
		this.ePackage = ePackage;
	}

	public EolIndex parse(String location) throws IOException {
		
		EolModule mModule = new EolModule();
		
		try {
			mModule.parse(new File(location));
		} catch (Exception e) {
			throw new IOException("EOL program not found. Looking for "+location);
		}

		for (ParseProblem problem : mModule.getParseProblems()) {
			System.err.println(problem.getReason());
		}

		
		
		EolContext context = (EolContext) mModule.createContext();

		EolIndex pIndex = new EolIndex(context);

		context.getModelRepository().addModel(
				//new InMemoryEmfModel("X", resource, ePackage));
				new InMemoryEmfModel("*", resource, ePackage));

		for (EolOperation op : mModule.getOperations()) {			
			try {
				EolType _type = op.getContextType(context);
				
				String mTypeName = "";				
				if (_type instanceof EolModelElementType) {
					EolModelElementType type = (EolModelElementType) op.getContextType(context);
					mTypeName = type.getName();
				}
				
				String mOpName = op.getName();
				
				if (!EolAnnotationsUtil.getBooleanAnnotationValue(op.getAst(),
						"disabled", context, false, true)) {
					pIndex.add(mTypeName, mOpName, op);
				}
				
			} catch (EolRuntimeException e1) {
				e1.printStackTrace();
			}
		}

		return pIndex;

	}

}
