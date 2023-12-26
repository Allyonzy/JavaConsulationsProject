package ru.innopolis.java.lambdas;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        boolean[] resultCondition = new boolean[array.length];
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            resultCondition[i] = condition.isOk(array[i]);
            if (resultCondition[i]) {
                size++;
            }
        }
        int[] result = new int[size];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (resultCondition[i]) {
                result[count] = array[i];
                count++;
            }
        }
        return result;
    }
}

