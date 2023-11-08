package ru.innopolis.java.homework03;

import java.util.Scanner;

public class TestPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerTwo = new Scanner(System.in);
        int test = scanner.nextInt();
        scanner.nextLine();
        double twoTest = scannerTwo.nextDouble();
        scannerTwo.nextLine();
        String text = scanner.nextLine();
        System.out.printf("Введенные значения: %d, %f, %s\n", test, twoTest, text);
    }
}
