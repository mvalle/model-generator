package uk.ac.york.cs.mv525.modelgen.generate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

import uk.ac.york.cs.mv525.modelgen.data.Configuration;
import uk.ac.york.cs.mv525.modelgen.data.ModelInstance;
import uk.ac.york.cs.mv525.modelgen.index.EolIndex;
import uk.ac.york.cs.mv525.modelgen.index.MetaModelIndex;
import uk.ac.york.cs.mv525.modelgen.parse.EolParser;
import uk.ac.york.cs.mv525.modelgen.strategy.Strategy;

public class EolGenerator extends Generator {

	EFactory iClassGenerator;
	EolIndex opIndex;
	
	MetaModelIndex mIndex;
	ModelInstance iModel;
	Strategy strategy;
	Configuration config;

	public EolGenerator(String programLocation, ModelInstance modelInstance,
			MetaModelIndex metaModel, Configuration config) throws IOException {
		
		System.out.print(modelInstance);
		System.out.println(" EolGenerator()");
		
		mIndex = metaModel;
		iModel = modelInstance;
		iClassGenerator = mIndex.getEPackage().getEFactoryInstance();

		EolParser parser = new EolParser(iModel.getResource(),
				mIndex.getEPackage());
		opIndex = parser.parse(programLocation);
		
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

			EObject iObject = iClassGenerator.create(mClass);

			EolOperation createOp = opIndex.get(mClass.getName());
			if (createOp != null) {
				createOp.execute(iObject, Collections.emptyList(),
						opIndex.getEolContext());
			}

			iModel.add(iObject);  /* Controversial */ 

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
					//System.out. 
					if(opIndex.getEolContext().getErrorStream().checkError()) {
						System.out.println("ERROR");
						
					}
					
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
		
		long lower = mReference.getLowerBound();
		long upper = mReference.getUpperBound();
		// * == -1
		if (upper == -1) {upper = config.getMinimumCount();}
		
		@SuppressWarnings("unchecked")
		EList<EObject> iReferenceContainer = (EList<EObject>) iObjectContainer
				.eGet(mReference);
		if (lower == upper && upper == 1) {
			// if multiplicity of 1, do one
			if(iReferenceContainer.size() < 1) {
				callLink(iObjectContainer, mReference);
			}
		} else if (upper < iReferenceContainer.size())	{
			// Add minimum references
			while(lower > iReferenceContainer.size() && upper < iReferenceContainer.size()) {
				callLink(iObjectContainer, mReference);
			}
			
			long configMin = config.getMinimumReferences(mReference);
			while(configMin > iReferenceContainer.size() && upper < iReferenceContainer.size()) {
				callLink(iObjectContainer, mReference);
			}			
		}
		
		return iObjectContainer.eGet(mReference); 
	}

	private void callLink(EObject iObjectContainer, EReference mReference) {
		EObject iObject = strategy.retrieaveObject((EClass) mReference
				.getEType());

		try {
			EolOperation linkOp = opIndex.get(iObject.eClass(),
					mReference);

			if (linkOp != null) {
				linkOp.execute(iObjectContainer, Arrays.asList(iObject),
						opIndex.getEolContext());
				//System.out. 
				if(opIndex.getEolContext().getErrorStream().checkError()) {
					System.out.println("ERROR");					
				}
				
			}
		} catch (EolRuntimeException e) {
			System.err.println(e.getMessage());
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