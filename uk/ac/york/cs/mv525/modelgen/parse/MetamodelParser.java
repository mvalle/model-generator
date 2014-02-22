package uk.ac.york.cs.mv525.modelgen.parse;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.mv525.modelgen.ResourceOperator;

public class MetamodelParser extends ResourceOperator {

	private EPackage ePackage;
	
	//private Collection mCollection;
	
	private HashMap<String, EClass> mClasses;
	
	private Resource metaModel;

	public MetamodelParser(String metamodelLocation) throws IOException {
		metaModel = readMetaModel(metamodelLocation);
		
		mClasses = new HashMap<String, EClass>();
	}

	public HashMap<String, EClass> parse() throws Exception {
		// Read metamodel
		// Scan for classes
		// Scan for references
		
		findEPackage();

		walkETree(metaModel.getContents());

		return mClasses;
	}
	
	public EPackage getEPackage() {
		return ePackage;
	}
	
	private void findEPackage() {
		ePackage = (EPackage) metaModel.getContents().get(0);
		
	}
	
	private void walkETree(EList<EObject> mObjs) {
		for(EObject mObj : mObjs) {
			if(mObj.eClass().getName().equals("EClass")) {

				EClass mClass = (EClass)mObj;
				mClasses.put(mClass.getName(), mClass);
				
			}
			walkETree(mObj.eContents());
		}
		
	}

	public HashMap<String, EClass> getEClasses() {
		// TODO Auto-generated method stub
		return mClasses;
	}



















}
