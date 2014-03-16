package uk.ac.york.cs.mv525.modelgen2.index;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.execute.context.EolContext;

public class EolIndex implements Index {

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
		
		return opTable.get(mOpName);
	}

	public EolContext getEolContext() {
		return eolContext;
	}
	
}
