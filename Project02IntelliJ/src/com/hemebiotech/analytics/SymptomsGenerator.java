package com.hemebiotech.analytics;

public class SymptomsGenerator {

    public static void main(String[] args) {

        AnalyticsCounter counter = new AnalyticsCounter("symptoms.txt");

        counter.generateSymptoms();
    }

}
