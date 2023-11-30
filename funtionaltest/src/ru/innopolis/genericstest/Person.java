package ru.innopolis.genericstest;

import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private String name;
    private String nation;

    public Person() {
    }

    public Person(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(nation, person.nation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nation);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("nation='" + nation + "'")
                .toString();
    }
}
