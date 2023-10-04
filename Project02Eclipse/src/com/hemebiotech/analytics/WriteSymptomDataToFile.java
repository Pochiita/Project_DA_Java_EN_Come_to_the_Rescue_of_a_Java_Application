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

   

	@Override
    public void writeSymptoms(Map<String,Integer> symptoms){
        try{
            writer = new FileWriter("result.out");
            

        }catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }

}
