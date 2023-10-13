package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private final ReadSymptomDataFromFile reader;
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
	 * Generates a "result.out" file with all the symptoms sorted
	 */
	public void generateSymptoms(){
		// first get input
		List<String> dataNotCounted = this.reader.getSymptoms();

		Map<String,Integer> dataCounter = symptomsListGenerator(dataNotCounted);

		Map<String,Integer> sortedData = symptomsSortingTypes(dataCounter);

		this.writer.writeSymptoms(sortedData);
	}

	/**
	 *
	 * @param raw_data expect a list of symptoms
	 * @return a map of all the symptoms counted
	 */
	public Map<String,Integer> symptomsListGenerator (List<String> raw_data){
		HashMap<String,Integer> symptomsHashMap = new HashMap<>();

		for (String item : raw_data ){
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
	public Map<String,Integer> symptomsSortingTypes (Map<String,Integer> data){

        return new TreeMap<>(data);

	} 
	
}
