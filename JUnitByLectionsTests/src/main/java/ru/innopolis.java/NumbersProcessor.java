package ru.innopolis.java;

import java.util.ArrayList;
import java.util.List;


public class NumbersProcessor {

    private Parser parser;

    public NumbersProcessor(Parser parser) {
        this.parser = parser;
    }

    public List<Boolean> checkEven(String numbers[]) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            result.add(parser.parse(numbers[i]) % 2 == 0);
        }
        return result;
    }
}
