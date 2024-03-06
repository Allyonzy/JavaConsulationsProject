package ru.innopolis.java.lambdas;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        int[] numbers = {52, 654, 378, -977, 87, 873, 777, 2987564, 9};

        ByCondition conditionOne = number -> number % 2 == 0 && number != 0;
        ByCondition conditionTwo = number -> number % 3 == 0 && number != 0;
        ByCondition conditionThree = number -> number < 1000 && number != 0;
        ByCondition evenNumbersSumCondition = number -> {
            int sum = 0;
            while (number != 0) {
                int lastDigit = number % 10;
                sum += lastDigit;
                number = number / 10;
            }

            return sum % 2 == 0 && sum != 0;
        };


        System.out.println("Чётные элементы массива: " + Arrays.toString(Sequence.filter(numbers, conditionOne)));
        System.out.println("Числа массива, которые делятся на 3: " + Arrays.toString(Sequence.filter(numbers, conditionTwo)));
        System.out.println("Числа массива, которые меньше 1000: " + Arrays.toString(Sequence.filter(numbers, conditionThree)));
        System.out.println("Числа массива, сумма которых чётна: " + Arrays.toString(Sequence.filter(numbers, evenNumbersSumCondition)));


        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Введите новый массив чисел через запятую: ");
            String newNumbersAsStr = scanner.nextLine();

            int[] numbersFromConsole = Arrays
                    .stream(newNumbersAsStr.split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println("Чётные элементы массива: " + Arrays.toString(Sequence.filter(numbersFromConsole, conditionOne)));
            System.out.println("Числа массива, которые делятся на 3: " + Arrays.toString(Sequence.filter(numbersFromConsole, conditionTwo)));
            System.out.println("Числа массива, которые меньше 1000: " + Arrays.toString(Sequence.filter(numbersFromConsole, conditionThree)));
            System.out.println("Числа массива, сумма которых чётна: " + Arrays.toString(Sequence.filter(numbersFromConsole, evenNumbersSumCondition)));
        } catch (NumberFormatException exception) {
            throw new RuntimeException("Входные данные должны быть формата числа");
        }
    }
}