package com.fizzbuzz;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static java.util.Collections.singletonList;
import static org.junit.Assert.*;


public class SequenceGeneratorTest {
    private SequenceGenerator sequenceGenerator = new SequenceGenerator();

    @Test
    public void generateSequenceOf1() throws Exception {
        checkSequence(singletonList(1), 1);
    }

    @Test
    public void generateSequenceOf2() throws Exception {
        checkSequence(asList(1, 2), 2);
    }

    @Test
    public void generateSequenceOf5() throws Exception {
        checkSequence(asList(1, 2, 3, 4, 5), 5);
    }

    @Test
    public void generateSequenceOf0() throws Exception {
        checkSequence(EMPTY_LIST, 0);
    }

    @Test
    public void generateSequenceWithNegativeRange() throws Exception {
        checkSequence(EMPTY_LIST, -2);
    }

    private void checkSequence(List<Integer> expected, int range) {
        assertEquals(expected,
                sequenceGenerator.generateSeries(range).boxed().collect(Collectors.toList()));
    }

}