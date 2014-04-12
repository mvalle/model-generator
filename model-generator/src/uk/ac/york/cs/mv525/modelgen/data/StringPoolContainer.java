package uk.ac.york.cs.mv525.modelgen.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import uk.ac.york.cs.mv525.modelgen.config.config.EmbeddedStringPool;
import uk.ac.york.cs.mv525.modelgen.config.config.StringPoolEntry;

public class StringPoolContainer {

	ArrayList<String> pool;
	int state = 0;

	public StringPoolContainer(String location, String configlocation) {

		pool = new ArrayList<String>();

		try {

			File f = new File(location);

			if (f.exists()) {
			} else {
				File c = new File(configlocation);
				if (c.isFile()) {
					f = new File(c.getParent() + File.separator + location);
				} else {
					f = new File(configlocation + location);
				}
			}

			@SuppressWarnings("resource")
			BufferedReader r = new BufferedReader(new FileReader(f));

			String s = r.readLine();
			while (s != null) {
				pool.add(s);
				s = r.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public StringPoolContainer(EmbeddedStringPool sp) {
		pool = new ArrayList<String>();

		for (StringPoolEntry spe : sp.getStrings()) {
			pool.add(spe.getString());
		}
	}

	public String get() {

		if (pool.size() > 0) {
			String s = pool.get(state % pool.size());
			state++;
			return s;
		} else {
			return null;
		}

	}
}
