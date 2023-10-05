package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 */
public class AnalyticsCounter {
			
	public static void main(String args[]) throws Exception {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

		ISymptomWriter writer = new WriteSymptomDataToFile();
		
		List<String> dataNotCounted = reader.GetSymptoms();

		Map<String,Integer> dataCounter = symptomsListGenerator(dataNotCounted);

		Map<String,Integer> sortedData = symptomsSortingTypes(dataCounter);


		writer.writeSymptoms(sortedData);
	}

	public static Map<String,Integer> symptomsListGenerator (List<String> raw_data){
		
		HashMap<String,Integer> symptomsHashMap = new HashMap<String,Integer>();

		for (String item : raw_data ){
			if (symptomsHashMap.containsKey(item)){
				symptomsHashMap.put(item, symptomsHashMap.get(item)+1);
			}else{
				symptomsHashMap.put(item,1);
			}
		}
		return symptomsHashMap;
	}

	public static Map<String,Integer> symptomsSortingTypes (Map<String,Integer> data){
		
			Map<String, Integer> sortedMap = new TreeMap<>(data);
			return sortedMap;

	} 
	
}
