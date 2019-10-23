package com.fizzbuzz;

import com.fizzbuzz.matchers.BuzzMatcher;
import com.fizzbuzz.matchers.FizzBuzzMatcher;
import com.fizzbuzz.matchers.FizzMatcher;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


class Transformer {

    private static final String FIZZBUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    private final Map<Predicate<Integer>, Function<Integer, String>> transformers;

    Transformer() {
        //using LinkedHashMap because we need to have control over the order in which we traverse this map
        transformers = new LinkedHashMap<>();

        //need to instantiate objects in the absence of Spring dependency injection
        transformers.put(FizzBuzzMatcher.getInstance(), i -> FIZZBUZZ);
        transformers.put(FizzMatcher.getInstance(), i -> FIZZ);
        transformers.put(BuzzMatcher.getInstance(), i -> BUZZ);
    }

    String transform(int number) {
        for(Predicate<Integer> matcher : transformers.keySet()) {
            if (matcher.test(number)) {
                return transformers.get(matcher).apply(number);
            }
        }

        return String.valueOf(number);
    }
}
