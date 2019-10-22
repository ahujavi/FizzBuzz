package com.fizzbuzz;

import com.fizzbuzz.matchers.BuzzMatcher;
import com.fizzbuzz.matchers.FizzBuzzMatcher;
import com.fizzbuzz.matchers.FizzMatcher;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SeriesUtilityImpl implements SeriesUtility {
    private static final String FIZZBUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    private final Map<Predicate<Integer>, Function<Integer, String>> transformers;

    SeriesUtilityImpl() {
        //using LinkedHashMap because we need to have control over the order in which we traverse this map
        transformers = new LinkedHashMap<>();

        //need to instantiate dependencies in the absence of Spring dependency injection
        transformers.put(FizzBuzzMatcher.getInstance(), i -> FIZZBUZZ);
        transformers.put(FizzMatcher.getInstance(), i -> FIZZ);
        transformers.put(BuzzMatcher.getInstance(), i -> BUZZ);
    }

    @Override
    public Stream<String> generateSeries(int range) {
        return IntStream
                .rangeClosed(1, range)
                .mapToObj(this::transform);
    }

    String transform(int number) {
        for(Predicate<Integer> matcher : transformers.keySet()) {
            if (matcher.test(number)) {
                return transformers.get(matcher).apply(number);
            }
        }

        return String.valueOf(number);
    }

    @Override
    public String toPrettyString(Stream<String> series) {
        return series.collect(Collectors.joining(System.lineSeparator()));
    }

}
