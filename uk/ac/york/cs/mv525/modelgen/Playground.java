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
	
	public Playground() {
		initResourceSet();
	}
	
	public static void main(String[] args) throws Exception {

		String workingdir = System.getProperty("user.dir");
		String modeldir = "models";
		String metamodelname = "orgchart.ecore";
		String programname = "test.eol";
		
		String metamodellocation = workingdir+"/"+modeldir+"/"+metamodelname;
		String programlocation = workingdir + "/" + modeldir+"/"+programname;
		
		Generator g = new Generator(metamodellocation);
		
		g.generate(programlocation);
		
		/*
		Playground pg = new Playground();
		
		String workingdir = System.getProperty("user.dir");
		String modeldir = "models";
		String metamodelname = "orgchart.ecore";
		
		String metamodellocation = workingdir+"/"+modeldir+"/"+metamodelname;
		
		/////////////////////////
		
		Resource metamodel = pg.readMetaModel(metamodellocation);
		*/
	}
	/*
	private static String indent(int level) {
		if(level > 0) {
			String indention = "";
			while(level != 0) {
				indention = indention + " ";
				level--;
			}
			
			return indention;
			
		} else {			
			return "";
		}		
	}
	*/
	Resource readMetaModel(String location) throws IOException {
		Resource resource = resourceSet.createResource(URI.createFileURI(location));
		resource.load(null);
		
		return resource;
		
	}
	
	private void initResourceSet() {
		
		resourceSet = new ResourceSetImpl();
		resourceSet.
			getResourceFactoryRegistry().
			getExtensionToFactoryMap().
			put("*", new XMIResourceFactoryImpl());
				
	}
}
