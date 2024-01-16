package ru.innopolis.java;

import java.util.List;


public class MainForNumbersProcessor {
    public static void main(String[] args) {
        NumbersProcessor numbersProcessor = new NumbersProcessor(new ParserImpl());
        List<Boolean> result = numbersProcessor.checkEven(new String[]{"12345", "1234", "123", "12"});
        System.out.println(result);
    }
}
