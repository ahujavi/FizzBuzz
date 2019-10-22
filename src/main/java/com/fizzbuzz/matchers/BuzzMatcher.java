package com.fizzbuzz.matchers;

import lombok.Getter;

import java.util.function.Predicate;

public class BuzzMatcher implements Predicate<Integer> {

    private static final String FIVE = "5";

    @Getter
    private static final BuzzMatcher instance = new BuzzMatcher();

    private BuzzMatcher() {
    }

    @Override
    public boolean test(Integer number) {
        return number != 0 && (number % 5 == 0 || String.valueOf(number).contains(FIVE));
    }
}
