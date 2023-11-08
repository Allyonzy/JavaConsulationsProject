package ru.innopolis.java.homework05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minCount = 0;
        int maxCount = 2;

        Person [] persons = new Person[maxCount];

        for (int i = minCount; i < maxCount; i++) {
            System.out.println("Введите имя");
            String name = scanner.nextLine();
            try {
                System.out.println("Введите подразделение");
                int departmentNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Введите квалификацию от 0 до 100");
                int qualityLevel = scanner.nextInt(); // берет только число, не переходя на другую строку
                scanner.nextLine();
                System.out.println("Участвует ли сотрудник в проекте? Да или Нет");
                String isProjectWorkerStr = scanner.nextLine();
                boolean isProjectWorker = isProjectWorkerStr.equals("Да"); // сравнивать по equals

                System.out.println("Участвует ли сотрудник в проекте? true или false");
                boolean isProjectWorkerTest = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println(isProjectWorkerTest);
                Person newPerson = new Person(name, departmentNumber, qualityLevel, isProjectWorker);

                persons[i] = newPerson; //0, 1
                System.out.println(newPerson);
            } catch (InputMismatchException exception) {
                System.err.printf("Ошибка %s\n", exception);
                System.out.println("Программа завершена");
            } finally {
                System.out.printf("Итерация %d завершена\n", i);
            }
        }


    }
}