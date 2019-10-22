package com.fizzbuzz;

import java.util.stream.Stream;

public class FizzBuzzApplication {

    public static void main(String[] args) {
        try {
            SeriesUtility seriesUtility = new SeriesUtilityImpl();

            Stream<String> series = seriesUtility.generateSeries(100);
            String result = seriesUtility.toPrettyString(series);

            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Internal Error!");
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
