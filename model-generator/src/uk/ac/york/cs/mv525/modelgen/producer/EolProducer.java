package uk.ac.york.cs.mv525.modelgen.producer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.EolIndex;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.EolParser;
import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;

public class EolProducer extends Producer {

	EFactory iClassFactory;
	EolIndex opIndex;

	MetaModelIndex mIndex;
	ModelInstance iModel;
	Strategy strategy;
	Configuration config;

	public EolProducer(String programLocation, ModelInstance modelInstance,
			Configuration config) throws IOException {

		// System.out.print(modelInstance);
		// System.out.println(" EolProducer()");

		mIndex = config.metaModel;
		iModel = modelInstance;
		iClassFactory = mIndex.getEPackage().getEFactoryInstance();

		EolParser parser = new EolParser(iModel.getResource(),
				mIndex.getEPackage());
		try {
			opIndex = parser.parse(programLocation);
		} catch (IOException e) {
			String configDir = config.getDirectory();

			File f = new File(configDir);
			if (f.isFile()) {
				opIndex = parser.parse(f.getParent() + f.separator
						+ programLocation);
			} else {
				opIndex = parser.parse(config.getDirectory() + programLocation);
			}
		}

		this.config = config;
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
			EObject iObject = null;

			EolOperation constructOp = opIndex.getConstructor(mClass);
			if (constructOp != null) {
				iObject = (EObject) constructOp.execute(null,
						Arrays.asList(iObject), opIndex.getEolContext());
			}

			EolOperation createOp = opIndex.get(mClass.getName());
			if (createOp != null) {

				// System.out.println(iClassGenerator.getEPackage());
				// System.out.println(mClass.getEPackage());
				if (iObject == null) {
					iObject = iClassFactory.create(mClass);
				}

				createOp.execute(iObject, Collections.emptyList(),
						opIndex.getEolContext());

			}

			if (iObject != null) {
				iModel.add(iObject);
			}

			return iObject;

		} catch (EolRuntimeException e) {
			return null;
		}
	}

	public Object add(EObject iObject, EAttribute mAttribute) {
		try {

			if (!iObject.eIsSet(mAttribute)) {

				EolOperation attributeOp = opIndex.get(iObject.eClass(),
						mAttribute);

				if (attributeOp != null) {
					attributeOp.execute(iObject, Collections.emptyList(),
							opIndex.getEolContext());
					// System.out.
					if (opIndex.getEolContext().getErrorStream().checkError()) {
						return null;
					}

				}
			}

			return iObject.eGet(mAttribute);

		} catch (EolRuntimeException e) {
			return null;
		}
	}

	public Object link(EObject iObjectContainer, EReference mReference) {
		if (null == opIndex.get(mReference.getEContainingClass(), mReference)) {
			// If there's no EOL function for this reference,
			// then there's nothing to do.
			return null;
		}

		/*
		 * +------------------+ +---------------------+---------+ |
		 * iObjectContainer |---->| iReferenceContainer | iObject |
		 * +------------------+ +---------------------+---------+
		 */
		long lower = mReference.getLowerBound();
		long upper = mReference.getUpperBound();
		// * == -1
		if (upper == -1) {
			upper = Long.MAX_VALUE;
		}

		@SuppressWarnings("unchecked")
		EList<EObject> iReferenceContainer = (EList<EObject>) iObjectContainer
				.eGet(mReference);
		try {
			if (upper == 1) {
				// if multiplicity of 1, do one
				if (iReferenceContainer.size() < 1) {
					callLink(iObjectContainer, mReference);
				}
			} else if (upper > iReferenceContainer.size()) {

				// Add minimum references
				while (lower > iReferenceContainer.size()
						&& upper < iReferenceContainer.size()) {
					callLink(iObjectContainer, mReference);
				}

				long configMin = config.getMinimumReferences(mReference);
				long configMax = config.getMaximumReferences(mReference);

				if (configMin == -1) {
					configMin = 1;
				}
				if (configMax == -1) {
					configMax = config.getMinimumCount((EClass) mReference
							.getEType());
				}

				/*
				 * callLink may not actually add a link. Therfore, we simulate
				 * the size of the list as a delimiter of how many times to call
				 * the callLink. If we use the actual size we will end up with
				 * an infinite loop
				 */

				long simulatedSize = iReferenceContainer.size();

				while (configMin > simulatedSize && configMax > simulatedSize
						&& upper > simulatedSize) {
					callLink(iObjectContainer, mReference);
					simulatedSize++;
				}

			}
		} catch (EolRuntimeException e) {
			return null;
		}

		return iObjectContainer.eGet(mReference);
	}

	private void callLink(EObject iObjectContainer, EReference mReference)
			throws EolRuntimeException {
		EObject iObject = strategy.retrieaveObject((EClass) mReference
				.getEType());

		EolOperation linkOp = opIndex
				.get(iObjectContainer.eClass(), mReference);

		if (linkOp != null) {
			linkOp.execute(iObjectContainer, Arrays.asList(iObject),
					opIndex.getEolContext());
			// System.out.
			if (opIndex.getEolContext().getErrorStream().checkError()) {
				throw new EolRuntimeException();
			}

		}

	}

	@Override
	public boolean before() {
		try {
			EolOperation op = opIndex.getBefore();
			if (op != null) {
				op.execute(null, Collections.emptyList(),
						opIndex.getEolContext());
				return true;
			}
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean after() {
		try {
			EolOperation op = opIndex.getAfter();
			if (op != null) {
				op.execute(null, Collections.emptyList(),
						opIndex.getEolContext());
				return true;
			}
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}