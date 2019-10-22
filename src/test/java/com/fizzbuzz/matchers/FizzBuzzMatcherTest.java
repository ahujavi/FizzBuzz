package com.fizzbuzz.matchers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FizzBuzzMatcherTest {

    FizzBuzzMatcher matcher = FizzBuzzMatcher.getInstance();

    @Test
    public void shouldMatchNumberDivisibleBy3And5() throws Exception {
        assertTrue(matcher.test(15));
        assertTrue(matcher.test(30));
    }

    @Test
    public void shouldMatchNumberNumberDivisibleBy3AndContaining5() throws Exception {
        assertTrue(matcher.test(51));
        assertTrue(matcher.test(54));
    }

    @Test
    public void shouldMatchNumberNumberDivisibleBy5AndContaining3() throws Exception {
        assertTrue(matcher.test(35));
        assertTrue(matcher.test(305));
    }

    @Test
    public void testNonMatchingNumbers() throws Exception {
        assertFalse(matcher.test(0));
        assertFalse(matcher.test(4));
    }

}