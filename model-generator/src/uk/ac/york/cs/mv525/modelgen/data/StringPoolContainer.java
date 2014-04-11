package uk.ac.york.cs.mv525.modelgen.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry;

public class StringPoolContainer {

	ArrayList<String> pool;
	int state = 0;
	
	public StringPoolContainer(String location) {
		
		pool = new ArrayList<String>();
		
		try {
			
			@SuppressWarnings("resource")
			BufferedReader r = new BufferedReader(new FileReader(location));

			String s = r.readLine();
			while (s != null) {
				pool.add(s);
				s = r.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public StringPoolContainer(EmbeddedStringPool sp) {
		pool = new ArrayList<String>();
				
		for(StringPoolEntry spe : sp.getStrings()) {
			pool.add(spe.getString());
		}
	}
	
	public String get() {
		
		if (pool.size() > 0) {
			String s = pool.get(state%pool.size());
			state++;
			return s;
		} else {
			return "";
		}
		
	}
}
