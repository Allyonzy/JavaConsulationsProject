package ru.innopolis.java.exceptionshierarhy;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class Elephant extends Animal {
    private Integer elephantCoeff;


    @Override
    protected Integer zooAnimalCount(int zooNumber) throws FileNotFoundException, EOFException {
        try {
            return zooNumber * this.elephantCoeff;
        } catch(Exception exception){
            throw new EOFException("Введено не число");
        }
    }
}
