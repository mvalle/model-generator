package uk.ac.york.cs.mv525.modelgen2.parse;

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

import uk.ac.york.cs.mv525.modelgen2.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen2.index.Index;
import uk.ac.york.cs.mv525.modelgen2.index.EolIndex;

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

		EolIndex pIndex = new EolIndex();

		EolContext context = (EolContext) mModule.createContext();

		context.getModelRepository().addModel(
				new InMemoryEmfModel("X", resource, ePackage));

		for (EolOperation op : mModule.getOperations()) {
			
			try {
				EolModelElementType type;
				type = (EolModelElementType) op.getContextType(context);

				String mTypeName = type.getName();
				String mOpName = op.getName();

				if (!EolAnnotationsUtil.getBooleanAnnotationValue(op.getAst(),
						"disabled", context, false, true)) {

					pIndex.add(mTypeName, mOpName, op);
				}
				
			} catch (EolRuntimeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return pIndex;

	}

}
