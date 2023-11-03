package ru.innopolis.java.homework05;

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
            System.out.println("Введите подразделение");
            int departmentNumber = scanner.nextInt();
            System.out.println("Введите квалификацию от 0 до 100");
            int qualityLevel = scanner.nextInt();
            System.out.println("Участвует ли сотрудник в проекте? Да или Нет");
            boolean isProjectWorker = scanner.nextLine() == "Да";

            Person newPerson = new Person(name, departmentNumber, qualityLevel, false);

            persons[persons.length - 1] = newPerson;
            System.out.println(newPerson);
        }


    }
}