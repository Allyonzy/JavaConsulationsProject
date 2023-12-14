package ru.innopolis.java.testexceptions;

import ru.innopolis.java.utils.customexceptions.ZeroDivisionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainArythmeticException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textApp = "START";

        while(!textApp.equals("END")) {
            try {
                System.out.println("Введите число 1: ");
                double firstNumber = scanner.nextDouble();
                System.out.println("Введите число 2: ");
                double secondNumber = scanner.nextDouble();
                if(secondNumber == 0) {
                    throw new ZeroDivisionException("Деление на 0 недопустимо");
                }
                double result = firstNumber / secondNumber;
                System.out.printf("%f / %f = %f", firstNumber, secondNumber, result);
            } catch (ZeroDivisionException exception) {
                System.err.println(exception.getMessage());
            } catch (InputMismatchException exception) {
                System.err.println("Требуется ввести число!");
            }
            System.out.println();
            scanner.nextLine();
            System.out.println("Для завершения программы введите END. Иначе - START");
            textApp = scanner.nextLine();
        }
    }
}
