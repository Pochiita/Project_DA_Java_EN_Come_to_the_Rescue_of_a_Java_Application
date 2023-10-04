package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	
	public static void main(String args[]) throws Exception {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

		ISymptomWriter writer = new WriteSymptomDataToFile();
		
		List<String> dataNotCounted = reader.GetSymptoms();

		Map<String,Integer> dataCounter = symptomsListGenerator(dataNotCounted);

		Map<String,Integer> sortedData = symptomsSortingTypes(dataCounter);


		writer.writeSymptoms(sortedData);


		//.out.println(symptomsSortingTypes(symptomsListGenerator(data)));
		//countMap(data);
		//System.out.println(data);	
		
		 //List<String> data = reader.GetSymptoms();
		// System.out.println(data);
		//BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		//String line = reader.readLine();
/*
		int i = 0;	
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
		*/

		
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
