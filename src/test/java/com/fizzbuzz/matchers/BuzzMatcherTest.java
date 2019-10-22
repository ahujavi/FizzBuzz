package com.fizzbuzz.matchers;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuzzMatcherTest {

    private BuzzMatcher matcher = BuzzMatcher.getInstance();

    @Test
    public void shouldMatchNumberDivisibleBy5() throws Exception {
        assertTrue(matcher.test(5));
        assertTrue(matcher.test(15));
    }

    @Test
    public void shouldMatchNumberContaining5() throws Exception {
        assertTrue(matcher.test(5));
        assertTrue(matcher.test(52));
    }

    @Test
    public void testNonMatchingNumbers() throws Exception {
        assertFalse(matcher.test(0));
        assertFalse(matcher.test(4));
    }

}