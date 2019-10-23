package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class TransformerTest {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    private Transformer transformer = new Transformer();

    @Test
    public void testNumberDivisibleBy3() {
        mustTransformToFizz(3);
        mustTransformToFizz(6);
    }

    @Test
    public void testNumberContaining3() {
        mustTransformToFizz(13);
        mustTransformToFizz(31);
    }

    @Test
    public void testNumberDivisibleBy5() {
        mustMapToBuzz(5);
        mustMapToBuzz(10);
    }

    @Test
    public void testNumberContaining5() {
        mustMapToBuzz(52);
    }

    @Test
    public void testNumberDivisibleBy3And5() {
        mustMapToFizzBuzz(15);
    }

    @Test
    public void testNumberDivisibleBy3AndContaining5() {
        mustMapToFizzBuzz(51);
    }

    @Test
    public void testNumberDivisibleBy5AndContaining5() {
        mustMapToFizzBuzz(35);
    }

    @Test
    public void testOtherNumbers() {
        mustMapToSelf(0);
        mustMapToSelf(1);
        mustMapToSelf(7);
    }

    private void mustTransformToFizz(int input) {
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
                expected, transformer.transform(input));
    }

}