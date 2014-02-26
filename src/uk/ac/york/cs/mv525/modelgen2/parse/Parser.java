package uk.ac.york.cs.mv525.modelgen2.parse;

import uk.ac.york.cs.mv525.modelgen2.index.Index;

//TODO This should be static
public interface Parser {

	public Index parse(String location);
}
