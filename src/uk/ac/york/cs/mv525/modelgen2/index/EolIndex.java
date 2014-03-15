package uk.ac.york.cs.mv525.modelgen2.index;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eol.EolOperation;

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
	HashMap<String, HashMap<String, EolOperation>> index
	
	public void add(String name, EObject object) {
		// TODO Auto-generated method stub

	}

	
	public EObject get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	// TODO : Change argumen types and order. mTypeName -> EClass
	public void add(String mTypeName, String mOpName, EolOperation op) {
		
		
	}

}
