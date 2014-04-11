package uk.ac.york.cs.mv525.modelgen.parse;

public class InvalidConfigurationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2315452368475765687L;
	String m;
	
	public InvalidConfigurationException(String m) {
		super();
		this.m = m;
	}
	
	@Override
	public String getMessage() {
		return m;		
	}
	
}
