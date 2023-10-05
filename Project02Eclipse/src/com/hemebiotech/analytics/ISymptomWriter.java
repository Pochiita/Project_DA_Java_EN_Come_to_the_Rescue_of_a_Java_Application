package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Simply write Map<String,Integer> to file.
 */
public interface ISymptomWriter {
    
	/**
	 * Generate an .out file and write the content of a map on it in the format : "key : value"
	 * 
	 * @return null
	 */
    public void writeSymptoms(Map<String,Integer> symptoms);
}
