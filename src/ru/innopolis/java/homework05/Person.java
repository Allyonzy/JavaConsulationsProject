package ru.innopolis.java.homework05;

import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private String name;
    // ...

    //Номер включенного канала - целое число,
    private int departmentNumber;

    //c. Громкость звука - целое число;
    private int qualityLevel;

    //    d. Признак включен ли телевизор.
    private boolean isProjectWorker;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int departmentNumber, int qualityLevel, boolean isProjectWorker) {
        this.name = name;
        this.departmentNumber = departmentNumber;
        this.qualityLevel = qualityLevel;
        this.isProjectWorker = isProjectWorker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQualityLevel() {
        return this.qualityLevel;
    }

    public void setQualityLevel(int qualityLevel) {
//        if (qualityLevel <= 0 || qualityLevel >= 100) {
//            throw new RuntimeException("Введенное значение должно быть >= 0 и <= 100");
//        }
//        this.qualityLevel = qualityLevel;

        if (qualityLevel >= 0 && qualityLevel <= 100) {
            this.qualityLevel = qualityLevel;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("departmentNumber=" + departmentNumber)
                .add("qualityLevel=" + qualityLevel)
                .add("isProjectWorker=" + isProjectWorker)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return departmentNumber == person.departmentNumber &&
                getQualityLevel() == person.getQualityLevel() &&
                isProjectWorker == person.isProjectWorker &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),
                departmentNumber,
                getQualityLevel(),
                isProjectWorker
        );
    }
}
