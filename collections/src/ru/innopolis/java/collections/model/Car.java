package ru.innopolis.java.collections.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Car {
    private String carNumber;
    private String model;
    private Double mileageToFind;

    public Car() {
    }

    public Car(String carNumber, String model, Double mileageToFind) {
        this.carNumber = carNumber;
        this.model = model;
        this.mileageToFind = mileageToFind;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setMileageToFind(Double mileageToFind) {
        this.mileageToFind = mileageToFind;
    }

    public Double getMileageToFind() {
        return mileageToFind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carNumber, car.carNumber) && Objects.equals(model, car.model) && Objects.equals(mileageToFind, car.mileageToFind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("carNumber='" + carNumber + "'")
                .add("model='" + model + "'")
                .add("mileageToFind=" + mileageToFind)
                .toString();
    }
}
