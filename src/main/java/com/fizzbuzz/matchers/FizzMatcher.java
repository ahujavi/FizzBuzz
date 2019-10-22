package com.fizzbuzz.matchers;

import lombok.Getter;

import java.util.function.Predicate;
public class FizzMatcher implements Predicate<Integer> {

    private static final String THREE = "3";

    @Getter
    private static final FizzMatcher instance = new FizzMatcher();

    private FizzMatcher() {
    }

    @Override
    public boolean test(Integer number) {
        return number != 0 && (number % 3 == 0 || String.valueOf(number).contains(THREE));
    }

}
