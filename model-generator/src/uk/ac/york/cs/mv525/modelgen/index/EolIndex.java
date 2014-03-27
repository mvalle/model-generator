package uk.ac.york.cs.mv525.modelgen.index;

import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.execute.context.EolContext;

public class EolIndex implements Index {
	public static final String OP_PREFIX = "create";
	public static final String OP_BEFORE = "before";
	public static final String OP_AFTER = "after";
	public static final String OP_NOCONTEXT = "";
	
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
	

	// TODO : Change argument types and order. mTypeName -> EClass
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


	public EolOperation getBefore() {
		if(!index.containsKey(OP_NOCONTEXT)) return null;

		HashMap<String, EolOperation> opTable = index.get(OP_NOCONTEXT);
		
		return opTable.get(OP_BEFORE);
	}
	


	public EolOperation getAfter() {
		if(!index.containsKey(OP_NOCONTEXT)) return null;

		HashMap<String, EolOperation> opTable = index.get(OP_NOCONTEXT);
		
		return opTable.get(OP_AFTER);
	}


	public boolean hasConstructor(EClass mClass) {
		if(!index.containsKey(OP_NOCONTEXT)) return false;

		HashMap<String, EolOperation> opTable = index.get(OP_NOCONTEXT);
		
		return opTable.containsKey(OP_PREFIX+mClass.getName());
	}


	public EolOperation getConstructor(EClass mClass) {
		return get(OP_NOCONTEXT, mClass.getName());	}



	
}
