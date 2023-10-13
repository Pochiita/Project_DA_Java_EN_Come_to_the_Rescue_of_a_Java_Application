package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Simply write data to a file.
 */
public interface ISymptomWriter {
    
	/**
	 * Generate a results.out file and write the content of a map on it in the format : "key : value"
	 * 
	 * @return null
	 */
    void writeSymptoms(Map<String, Integer> symptoms);
}
