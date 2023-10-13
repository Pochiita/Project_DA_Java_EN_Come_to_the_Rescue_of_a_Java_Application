package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    
    public FileWriter writer; //new FileWriter ("result.out");

   
    /**
     * Generating a file that displays every symptom
     * 
     * @return null
     */
	@Override
    public void writeSymptoms(Map<String,Integer> symptoms){
        try{
            writer = new FileWriter("result.out");
            for (Map.Entry<String, Integer> set :
            symptoms.entrySet()) {
            writer.write(set.getKey()+" : "+set.getValue()+"\n");
            }
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
