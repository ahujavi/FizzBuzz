package com.fizzbuzz;

import java.util.stream.IntStream;

class SequenceGenerator {

    IntStream generateSeries(int range) {
        return IntStream.rangeClosed(1, range);
    }

}
