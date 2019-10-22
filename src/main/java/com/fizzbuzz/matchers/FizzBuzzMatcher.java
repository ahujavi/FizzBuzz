package com.fizzbuzz.matchers;

import lombok.Getter;

import java.util.function.Predicate;

public class FizzBuzzMatcher implements Predicate<Integer> {

    @Getter
    private static final FizzBuzzMatcher instance = new FizzBuzzMatcher();

    private final Predicate<Integer> predicate;

    private FizzBuzzMatcher() {
        this.predicate = FizzMatcher.getInstance().and(BuzzMatcher.getInstance());
    }

    @Override
    public boolean test(Integer number) {
        return predicate.test(number);
    }
}
