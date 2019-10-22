package com.fizzbuzz;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static java.util.stream.Collectors.toList;
import static junit.framework.Assert.assertEquals;


public class SeriesUtilityImplTest {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    private SeriesUtilityImpl seriesProducer = new SeriesUtilityImpl();

    @Test
    public void testFizzMapping() {
        //divisible by 3
        mustMapToFizz(3);
        mustMapToFizz(6);

        //has '3' in it
        mustMapToFizz(13);
        mustMapToFizz(31);
    }

    @Test
    public void testBuzzMapping() {
        //divisible by 5
        mustMapToBuzz(5);
        mustMapToBuzz(10);

        //has '5' in it
        mustMapToBuzz(52);
    }

    @Test
    public void testFizzBuzzMapping() {
        //divisible by both 3 and 5
        mustMapToFizzBuzz(15);

        //divisible by 3 and has '5' in it
        mustMapToFizzBuzz(51);

        //divisible by 5 and has '3' in it
        mustMapToFizzBuzz(35);
    }

    @Test
    public void testOtherNumbers() {
        mustMapToSelf(0);
        mustMapToSelf(1);
        mustMapToSelf(7);
    }

    @Test
    public void testGenerateSeries() {
        List<String> expected = asList("1", "2", FIZZ, "4", BUZZ,
                FIZZ, "7", "8", FIZZ, BUZZ,
                "11", FIZZ, FIZZ, "14", FIZZBUZZ);

        assertEquals(expected, seriesProducer.generateSeries(15).collect(toList()));
    }

    @Test
    public void testGenerateSeriesWithZeroRange() {
        assertEquals(EMPTY_LIST, seriesProducer.generateSeries(0).collect(toList()));
    }

    @Test
    public void testGenerateSeriesWithNegativeRange() {
        assertEquals(EMPTY_LIST, seriesProducer.generateSeries(-2).collect(toList()));
    }

    @Test
    public void testToPrettyString() {
        Stream<String> series = Stream.of("aa", "bb", "cc");
        String expected = new StringBuilder()
                .append("aa")
                .append(System.lineSeparator())
                .append("bb")
                .append(System.lineSeparator())
                .append("cc")
                .toString();

        assertEquals(expected, seriesProducer.toPrettyString(series));
    }

    private void mustMapToFizz(int input) {
        checkMapping(input, FIZZ);
    }

    private void mustMapToBuzz(int input) {
        checkMapping(input, BUZZ);
    }

    private void mustMapToFizzBuzz(int input) {
        checkMapping(input, FIZZBUZZ);
    }

    private void mustMapToSelf(int input) {
        checkMapping(input, String.valueOf(input));
    }

    private void checkMapping(int input, String expected) {
        assertEquals(String.format("Failed to transform %s", input),
                expected, seriesProducer.transform(input));
    }

}