package ru.innopolis.java.homework11;

import java.util.Objects;
import java.util.StringJoiner;

public class Car {
    private String carNumber;
    private String model;
    private String color;
    private Long mileage;
    private Long price;

    public Car() {
    }

    public Car(String carNumber, String model, String color, Long mileage, Long price) {
        this.carNumber = carNumber;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getCarNumber(), car.getCarNumber()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getColor(), car.getColor()) && Objects.equals(getMileage(), car.getMileage()) && Objects.equals(getPrice(), car.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarNumber(), getModel(), getColor(), getMileage(), getPrice());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("carNumber='" + carNumber + "'")
                .add("model='" + model + "'")
                .add("color='" + color + "'")
                .add("mileage=" + mileage)
                .add("price=" + price)
                .toString();
    }
}
