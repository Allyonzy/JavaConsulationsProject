package ru.innopolis.java;


public class MainForParser {
    public static void main(String[] args) {
        System.out.println((int)'9');
        System.out.println((int)'7');
        System.out.println((int)'9' - '0');

        String number = "12345";

        ParserImpl parser = new ParserImpl();
        System.out.println(parser.parse(number) + 1);
    }
}
