package uk.ac.york.cs.mv525.modelgen.parse;

import java.io.IOException;

import uk.ac.york.cs.mv525.modelgen.index.Index;

//TODO This should be static
public interface Parser {

	public /*@ pure @*/ Index parse(String location) throws IOException;
}
