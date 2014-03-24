package uk.ac.york.cs.mv525.modelgen.strategy;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class RetrieveOrCreate implements Strategy {

	Strategy creator;
	Strategy retriever;
	
	public RetrieveOrCreate(Strategy creator, Strategy retriever) {
		this.creator = creator;
		this.retriever = retriever;
	}
	
	@Override
	public EObject retrieaveObject(EClass mType) {
		EObject o = retriever.retrieaveObject(mType);
		if (o == null) {
			o = creator.retrieaveObject(mType);
		}
		return o;
	}

}
