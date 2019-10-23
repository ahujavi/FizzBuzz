package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class WriterTest {

    private Writer writer = new Writer();

    @Test
    public void write() throws Exception {
        String input = "foo";
        writer.write(input, output -> assertEquals(input, output));
    }

}