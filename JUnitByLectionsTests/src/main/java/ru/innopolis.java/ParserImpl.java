package ru.innopolis.java;


public class ParserImpl implements Parser {
    // "1234" -> 1234
    public int parse(String string) {

        if (string.equals("")) {
            throw new IllegalArgumentException("Empty string");
        }

        int result = 0;
        char number[] = string.toCharArray();
        int mult = 1;
        int sign = 1;

        int finish = 0;
        if (number[0] == '-') {
            sign = -1;
            finish = 1;
        } else if (number[0] == '+') {
            finish = 1;
        }
        for (int i = number.length - 1; i >= finish; i--) {
            if (Character.isDigit(number[i])) {
                // 3542 = 3 * 10^3 + 5 * 10^2 + 4 * 10^1 + 2 * 10^0
                result = result + (number[i] - '0') * mult;
                mult *= 10;
            } else throw new IllegalArgumentException("Incorrect string value");
        }
        return  result * sign;
    }
}
