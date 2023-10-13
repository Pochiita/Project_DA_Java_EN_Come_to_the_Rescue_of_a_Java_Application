package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final WriteSymptomDataToFile writer;

	/**
	 *
	 * @param fileName is the name of the file that contains the symptoms
	 */
	public AnalyticsCounter(String fileName){
		this.reader = new ReadSymptomDataFromFile(fileName);
		this.writer = new WriteSymptomDataToFile();
	}

	/**
	 *
	 * @return a list of symptoms from symptoms.txt
	 */
	public List<String> getSymptoms(){
		return this.reader.getSymptoms();
	}

	public void writeSymptoms(Map<String,Integer> sortedData){
		this.writer.writeSymptoms(sortedData);
	}

	/**
	 *
	 * @param rawData expect a list of symptoms
	 * @return a map of all the symptoms counted
	 */
	public Map<String,Integer> countSymptoms(List<String> rawData){
		HashMap<String,Integer> symptomsHashMap = new HashMap<>();

		for (String item : rawData ){
			if (symptomsHashMap.containsKey(item)){
				symptomsHashMap.put(item, symptomsHashMap.get(item)+1);
			}else{
				symptomsHashMap.put(item,1);
			}
		}
		return symptomsHashMap;
	}

	/**
	 *
	 * @param data is a map of symptoms
	 * @return a new map with all symptoms sorted
	 */
	public Map<String,Integer> sortSymptoms(Map<String,Integer> data){

        return new TreeMap<>(data);

	} 
	
}
