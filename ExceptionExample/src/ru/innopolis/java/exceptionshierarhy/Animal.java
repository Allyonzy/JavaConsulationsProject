package ru.innopolis.java.exceptionshierarhy;

import java.io.IOException;
import java.util.Objects;
import java.util.StringJoiner;

public class Animal {
    private Integer defaultAnimalCount;
    private String info;

    public Animal() {
    }

    public Animal(String info) {
        this.info = info;
    }

    public Integer getDefaultAnimalCount() {
        return defaultAnimalCount;
    }

    public void setDefaultAnimalCount(Integer defaultAnimalCount) {
        this.defaultAnimalCount = defaultAnimalCount;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    protected Integer zooAnimalCount(int zooNumber) throws IOException {
        try {
            return zooNumber * defaultAnimalCount;
        } catch(Exception exception){
            throw new IOException("Введено не число");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(getDefaultAnimalCount(), animal.getDefaultAnimalCount()) && Objects.equals(getInfo(), animal.getInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDefaultAnimalCount(), getInfo());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Animal.class.getSimpleName() + "[", "]")
                .add("defaultAnimalCount=" + defaultAnimalCount)
                .add("info='" + info + "'")
                .toString();
    }
}
