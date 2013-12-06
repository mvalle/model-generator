package uk.ac.york.cs.mv525.modelgen.create;

import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.mv525.modelgen.index.Collection;

public class RandomGenerator {

	private EPackage ePackage;
	private Collection iIndex;
	private Resource resource;
	private EList<EObject> instance;

	public RandomGenerator(Collection iIndex, Resource resource, EPackage ePackage) throws Exception{
		this.iIndex = iIndex;
		this.resource = resource;
		this.ePackage = ePackage;
		
		instance = resource.getContents();
	}

	public RandomGenerator(ModelInstance iInstance) {
		iIndex = iInstance.getIIndex();
		resource = iInstance.getResource();
		ePackage = iInstance.getEPackage();
		
		instance = resource.getContents();
	}
	
	public Object createAttribute(EObject iObject, EStructuralFeature mAttribute) {
		
		if (!iObject.eIsSet(mAttribute)) {
			
			if (mAttribute.getEType().getName() == "EString") {
				iObject.eSet(mAttribute, createEString());

				// TODO : Generate more EDataTypes
				
			} else {
				// print("Unknown EDataType");
			}
		}
		
		
		return iObject.eGet(mAttribute);
	}

	private String createEString() {
		String s = "";
		Random r= new Random();
		
		int size = r.nextInt(95)+5;
		
		for(int i = 0; i < size; i++) {	
			s = s + (char)r.nextInt();
		}
		
		return s;
	}
	
	public EObject create(EClass mClass) {

		EFactory iClassGenerator = ePackage.getEFactoryInstance();

		EObject iObject = iClassGenerator.create(mClass);

		add(iObject);

		return iObject;
	}

	private void add(EObject iObject) {

		iIndex.add(iObject);
		instance.add(iObject);

	}
}
