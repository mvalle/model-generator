package uk.ac.york.cs.mv525.modelgen2.parse;

import java.io.IOException;

import uk.ac.york.cs.mv525.modelgen2.index.Index;

//TODO This should be static
public interface Parser {

	public /*@ pure @*/ Index parse(String location) throws IOException;
}
