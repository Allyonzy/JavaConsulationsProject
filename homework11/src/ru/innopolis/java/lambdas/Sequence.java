package ru.innopolis.java.lambdas;

public class Sequence {
    public int[] filter (int[] inputNumbers, ByCondition condition) {
        boolean[] resultConditions = new boolean[inputNumbers.length];

        int size = 0;

        for (int pos = 0; pos < inputNumbers.length; pos++) {
            resultConditions[pos] = condition.isOk(inputNumbers[pos]);
            if(resultConditions[pos]) {
                size++;
            }
        }

        int[] resultNumbers = new int[size];

        int count = 0;
        for (int pos = 0; pos < resultConditions.length; pos++) {
            if(resultConditions[pos]) {
                resultNumbers[count] = inputNumbers[pos];
                count++;
            }
        }
        return resultNumbers;
    }
}
