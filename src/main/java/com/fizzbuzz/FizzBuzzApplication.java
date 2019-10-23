package com.fizzbuzz;

import java.util.function.Consumer;

public class FizzBuzzApplication {

    public static void main(String[] args) {
        try {
            //initialising objects manually in the absence of Spring dependency Injection
            SequenceGenerator sequenceGenerator = new SequenceGenerator();
            Transformer transformer = new Transformer();
            Writer writer = new Writer();
            Consumer<String> consoleWriter = System.out::println;

            sequenceGenerator.generateSeries(100)
                    .mapToObj(transformer::transform)
                    .forEach(s -> writer.write(s, consoleWriter));
        } catch (Exception e) {
            System.out.println("Internal Error!");
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
