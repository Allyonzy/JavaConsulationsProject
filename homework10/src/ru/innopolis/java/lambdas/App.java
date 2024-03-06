package ru.innopolis.java.lambdas;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] array = {52, 653, 6, 5648, 6897, 502, 89, 0};
        ByCondition evenCondition = number -> number % 2 == 0;

        int[] evenNumber = Sequence.filter(array, evenCondition);
        System.out.println("Четные элементы массива: " + Arrays.toString(evenNumber));

        ByCondition evenNumbersSumCondition = number -> {
            int sum = 0;
            while (number != 0) {
                int lastDigit = number % 10;
                sum += lastDigit;
                number = number / 10;
            }

            return sum % 2 == 0;
        };
        int[] sumOfDigitsEvenNumber = Sequence.filter(array, evenNumbersSumCondition);
        System.out.println("Элементы массива, сумма цифр которых четное число: " + Arrays.toString(sumOfDigitsEvenNumber));

    }
}