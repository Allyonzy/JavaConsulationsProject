package ru.innopolis.java.homework05;

public class Test {
    public static void main(String[] args) {
        Person human = new Person("Вася"); // ['В', 'a', 'c', 'я'] экземпляр, объект

        human.getName();

        human.setName("Петя");

        human.setQualityLevel(6);

        human.setName("Петя");

        Person nextHuman = Person.customPerson();

        nextHuman.setName("Ксавьер");

        System.out.println();

    }
}
