package com.fizzbuzz;

import java.util.function.Consumer;


class Writer {

    void write(String output, Consumer<String> consumer) {
        consumer.accept(output);
    }
}
