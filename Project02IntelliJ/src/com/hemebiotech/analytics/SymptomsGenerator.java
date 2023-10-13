package com.hemebiotech.analytics;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class SymptomsGenerator {

    public static void main(String[] args) {

        AnalyticsCounter counter = new AnalyticsCounter("symptoms.txt");

        List<String> dataNotCounted = counter.getSymptoms();

        Map<String,Integer> dataCounter = counter.countSymptoms(dataNotCounted);

        Map<String,Integer>  sortedData = counter.sortSymptoms(dataCounter);

        counter.writeSymptoms(sortedData);
        //Path absolutePath = Path.of("symptoms.txt").toAbsolutePath();


    }

}
