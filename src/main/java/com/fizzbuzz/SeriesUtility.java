package com.fizzbuzz;

import java.util.stream.Stream;

public interface SeriesUtility {
    Stream<String> generateSeries(int range);

    String toPrettyString(Stream<String> series);
}
