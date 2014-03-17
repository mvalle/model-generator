package uk.ac.york.cs.mv525.modelgen.index;

import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.execute.context.EolContext;

public class EolIndex implements Index {
	public static final String OP_PREFIX = "create";
	
	//  First string is type. Second string is operation name.
	
	/* +---------+      +------+
	 * | Person  |----->| Name |---> <Person createName()>
	 * | Company |--+   | Age  |---> <Person createAge()>
	 * +---------+  |   +------+
	 *              |   +------+
	 *              +-->| Name |---> <Company createName()>
	 *                  | Boss |---> <Company createBoss()>
	 *                  +------+
	 */
	HashMap<String, HashMap<String, EolOperation>> index;
	EolContext eolContext;
	
	public EolIndex(EolContext context) {
		index = new HashMap<String, HashMap<String, EolOperation>>();
		eolContext = context;
	}
	

	// TODO : Change argumen types and order. mTypeName -> EClass
	public void add(String mTypeName, String mOpName, EolOperation op) {
		
		if(!index.containsKey(mTypeName)) {
			index.put(mTypeName, new HashMap<String, EolOperation>());
		}
		
		HashMap<String, EolOperation> opTable = index.get(mTypeName);
		// Overwrite operation, if exists
		opTable.put(mOpName, op);
	}

	public EolOperation get(String mTypeName, String mOpName) {		
		if(!index.containsKey(mTypeName)) return null;

		HashMap<String, EolOperation> opTable = index.get(mTypeName);
		
		return opTable.get(OP_PREFIX+mOpName);
	}

	public EolOperation get(EClass mClass, EStructuralFeature mAttribute) {
		return get(mClass.getName(), mAttribute.getName());
	}
		
	public EolContext getEolContext() {
		return eolContext;
	}


	public EolOperation get(String name) {
		return get(name, OP_PREFIX);
	}


	
}
