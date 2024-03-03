package ru.innopolis.java.collections;

import ru.innopolis.java.collections.model.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String inputText = "a123me|Mercedes|0\n" +
                "b873of|Volga|0\n" +
                "w487mn|Lexus|76000\n" +
                "p987hj|Volga|610\n" +
                "p987hj|Woltswagen|67890\n" +
                "c987ss|Toyota|254000";

        Consumer<Car> printCarNumber = car -> System.out.println(car.getCarNumber());

        // TODO срефакторить DoubleFunction<UnaryOperator<Car>>
        Function<Double, UnaryOperator<Car>> addOneToMileage = number -> car -> {
            car.setMileageToFind(number + car.getMileageToFind());
            return car;
        };


        String[] inputStrArray = inputText.split("\n");

        List<Car> cars = new ArrayList<>();
        Set<Car> carSet = new HashSet<>();

        for (String inputStr : inputStrArray) {
            String[] infoCarText = inputStr.split("\\|");
            Car tempCar = new Car(
                    infoCarText[0],
                    infoCarText[1],
                    Double.parseDouble(infoCarText[2])
            );
            cars.add(tempCar);
            carSet.add(tempCar);
        }

        Double someDouble = 3.0;
        cars.stream()
                .map(car -> addOneToMileage.apply(someDouble).apply(car))
                .forEach(System.out::println);
        cars.forEach(printCarNumber);
        System.out.println("Завершено"); // TODO срефакторить на Logger Java 17

    }
}