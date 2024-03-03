package ru.innopolis.java.homework07;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private String name;
    private int money = 100;

    private int productBasketLength = 10; //при создании
    private Product [] productBasket; //array объектов

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int money, int productBasketLength) {
        this.name = name;
        this.money = money;
        this.productBasketLength = productBasketLength;
        this.productBasket = new Product [productBasketLength];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return money == person.money && productBasketLength == person.productBasketLength && Objects.equals(name, person.name) && Arrays.equals(productBasket, person.productBasket);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, money, productBasketLength);
        result = 31 * result + Arrays.hashCode(productBasket);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("money=" + money)
                .add("productBasketLength=" + productBasketLength)
                .add("productBasket=" + Arrays.toString(productBasket))
                .toString();
    }
}
