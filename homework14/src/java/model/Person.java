package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private String name;
    private int money = 100;

    private ArrayList<Product> productBasket; //array объектов

    public Person() {
        this.productBasket = new ArrayList<>();
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int money, ArrayList<Product> productBasket) {
        this.name = name;
        this.money = money;
        this.productBasket = productBasket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Product> getProductBasket() {
        return productBasket;
    }

    public void setProductBasket(ArrayList<Product> productBasket) {
        this.productBasket = productBasket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getMoney() == person.getMoney() && Objects.equals(getName(), person.getName()) && Objects.equals(getProductBasket(), person.getProductBasket());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMoney(), getProductBasket());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", productBasket=" + productBasket +
                '}';
    }
}
