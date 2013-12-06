package uk.ac.york.cs.mv525.modelgen.create;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;

import uk.ac.york.cs.mv525.modelgen.index.Collection;
import uk.ac.york.cs.mv525.modelgen.parse.ProgramParser;

public class EolGenerator {

	private Collection iIndex;
	private Resource resource;
	private EPackage ePackage;

	private EolContext eolContext;
	private EList<EObject> instance;

	public EolGenerator(Collection iIndex, Resource resource, EPackage ePackage)
			throws Exception {
		this.iIndex = iIndex;
		this.resource = resource;
		this.ePackage = ePackage;

		instance = resource.getContents();
	}

	public EolGenerator(ModelInstance iInstance) {
		iIndex = iInstance.getIIndex();
		resource = iInstance.getResource();
		ePackage = iInstance.getEPackage();
		
		instance = resource.getContents();
	}
	
	public void parseProgram(String programLocation) throws Exception {

		ProgramParser pp = new ProgramParser(iIndex, resource, ePackage);

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

	public EObject create(EClass mClass) throws EolRuntimeException {

		EFactory iClassGenerator = ePackage.getEFactoryInstance();

		EolOperation createOp = iIndex.getCreateOperation(mClass);
		EObject iObject = iClassGenerator.create(mClass);

		add(iObject);

		if (createOp != null) {
			createOp.execute(iObject, Collections.emptyList(), eolContext);
		}

		return iObject;
	}

	private void add(EObject iObject) {

		iIndex.add(iObject);
		instance.add(iObject);

	}
}
