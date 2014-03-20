package uk.ac.york.cs.mv525.modelgen.generate;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.EolIndex;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.EolParser;
import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;

public class EolGenerator implements Generator {

	EFactory iClassGenerator;
	EolIndex opIndex;
	MetaModelIndex mIndex;
	ModelInstance iModel;
	Strategy strategy;

	public EolGenerator(String programLocation, ModelInstance modelInstance,
			MetaModelIndex metaModel) throws IOException {
		mIndex = metaModel;
		iModel = modelInstance;
		iClassGenerator = mIndex.getEPackage().getEFactoryInstance();

		EolParser parser = new EolParser(iModel.getResource(),
				mIndex.getEPackage());
		opIndex = parser.parse(programLocation);
	}

	@Override	
	public void setStrategy(Strategy s) {
		strategy = s;
	}
	/*
	 * Creates a class using the normal method. Then calls and EOL operation on
	 * that class. Then adds in to resource.
	 */
	public EObject create(EClass mClass) {
		try {
			
			EObject iObject = iClassGenerator.create(mClass);

			EolOperation createOp = opIndex.get(mClass.getName());
			if (createOp != null) {
				createOp.execute(iObject, Collections.emptyList(),
						opIndex.getEolContext());
			}

			iModel.add(iObject); /* Controversial */

			return iObject;
			
		} catch (EolRuntimeException e) {
			return null;
		}
	}

	public Object add(EObject iObject, EStructuralFeature mAttribute) {
		try {
			
			if (!iObject.eIsSet(mAttribute)) {
				EolOperation attributeOp = opIndex.get(iObject.eClass(),
						mAttribute);

				if (attributeOp != null) {
					attributeOp.execute(iObject, Collections.emptyList(),
							opIndex.getEolContext());

				}
			}

			return iObject.eGet(mAttribute);
			
		} catch (EolRuntimeException e) {
			return null;
		}
	}

	public Object link(EObject iObjectContainer, EReference mReference) {		
		/*
		 * +------------------+ +---------------------+---------+ |
		 * iObjectContainer |---->| iReferenceContainer | iObject |
		 * +------------------+ +---------------------+---------+
		 */
		@SuppressWarnings("unchecked")
		EList<EObject> iReferenceContainer = (EList<EObject>) iObjectContainer
				.eGet(mReference);

		EObject iObject = strategy.retrieaveObject((EClass) mReference.getEType());

		iReferenceContainer.add(iObject);

		return null; // NOTE: Not implemented while not executing any EOL.
						// For now just a copy of the RandomGenerator's
						// link.
		// return iObjectContainer.eGet(mReference);
	}

}
