package uk.ac.york.cs.mv525.modelgen.create;

import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;

import uk.ac.york.cs.mv525.modelgen.index.Collection;
import uk.ac.york.cs.mv525.modelgen.parse.ProgramParser;

public class EolGenerator {

	private Collection iIndex;
	private EPackage ePackage;

	private EolContext eolContext;
	private ModelInstance iInstance;

	public EolGenerator(ModelInstance iInstance) {
		iIndex = iInstance.getIIndex();
		ePackage = iInstance.getEPackage();
		
		this.iInstance = iInstance;
	}
	
	public void parseProgram(String programLocation) throws Exception {

		ProgramParser pp = new ProgramParser(iIndex, iInstance);

		eolContext = pp.parse(programLocation);
	}

	public Object createAttribute(EObject iObject, EStructuralFeature mAttribute)
			throws EolRuntimeException {

		if (!iObject.eIsSet(mAttribute)) {

			EolOperation attributeOp = iIndex.getOperation(iObject.eClass(),
					mAttribute);

			if (attributeOp != null) {
				attributeOp.execute(iObject, Collections.emptyList(),
						eolContext);

			}
		}

		return iObject.eGet(mAttribute);
	}
	
	public Object createReference(EObject iObjectContainer, EReference mReference)
			throws EolRuntimeException {

		//if(iObjectContainer.eIsSet(mReference)) {

			EList<EObject> iReferenceContainer = (EList<EObject>) iObjectContainer
					.eGet(mReference);
			
			EFactory iClassGenerator = ePackage.getEFactoryInstance();
			EObject iObject = iClassGenerator.create((EClass)mReference.getEType());
			
			iReferenceContainer.add(iObject);
			
			executeCreate(iObject.eClass(), iObject);
		//}		

		return iObjectContainer.eGet(mReference);
	}
	
	public EObject create(EClass mClass) throws EolRuntimeException {

		EFactory iClassGenerator = ePackage.getEFactoryInstance();

		EObject iObject = iClassGenerator.create(mClass);

		iInstance.add(iObject);

		executeCreate(mClass, iObject);

		return iObject;
	}

	private void executeCreate(EClass mClass, EObject iObject)
			throws EolRuntimeException {
		EolOperation createOp = iIndex.getCreateOperation(mClass);
		if (createOp != null) {
			createOp.execute(iObject, Collections.emptyList(), eolContext);
		}
	}
}
