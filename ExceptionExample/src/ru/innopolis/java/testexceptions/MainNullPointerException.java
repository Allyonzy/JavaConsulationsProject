package ru.innopolis.java.testexceptions;

import ru.innopolis.java.exceptionshierarhy.Animal;

public class MainNullPointerException {
    public static void main(String[] args) {
        Animal girapha = new Animal();
        Animal sazan = null;
        getInfo(girapha);
        getInfo(sazan);

    }

    private static String getInfo(Animal animal) {
        try {
            return animal.getInfo();
        } catch (NullPointerException exception) {
            System.err.println(exception.getMessage());
        } finally {
            return "Нет информации.";

        }
    }



}
