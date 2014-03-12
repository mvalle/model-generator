package uk.ac.york.cs.mv525.modelgen;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import uk.ac.york.cs.mv525.modelgen.create.Generator;

public class Playground {

	private ResourceSet resourceSet;
		
	public static void main(String[] args) throws Exception {

		String workingdir = System.getProperty("user.dir");
		String modeldir = "models";
		String metamodelname = "orgchart.ecore";
		String programname = "test.eol";
		
		String metamodellocation = workingdir+"/"+modeldir+"/"+metamodelname;
		String programlocation = workingdir + "/" + modeldir+"/"+programname;
		
		Generator g = new Generator(metamodellocation);
		
		g.generate(programlocation);
		
		
	}
	
}
