package ru.innopolis.java.lambdas;

public class Sequence {
    public static int[] filter (int[] inputNumbers, ByCondition condition) {
        int[] resultNumbers = new int[inputNumbers.length];

        int count = 0;

        for (int inputNumber : inputNumbers) {
            if (condition.isOk(inputNumber)) {
                resultNumbers[count] = inputNumber;
                count++;
            }
        }

        return resultNumbers;
    }
}
