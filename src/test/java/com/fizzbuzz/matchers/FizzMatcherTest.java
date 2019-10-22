package com.fizzbuzz.matchers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FizzMatcherTest {

    private FizzMatcher matcher = FizzMatcher.getInstance();

    @Test
    public void shouldMatchNumberDivisibleBy3() throws Exception {
        assertTrue(matcher.test(3));
        assertTrue(matcher.test(15));
    }

    @Test
    public void shouldMatchNumberContaining3() throws Exception {
        assertTrue(matcher.test(3));
        assertTrue(matcher.test(31));
    }

    @Test
    public void testNonMatchingNumbers() throws Exception {
        assertFalse(matcher.test(0));
        assertFalse(matcher.test(4));
    }

}