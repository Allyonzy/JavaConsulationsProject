package ru.innopolis.java.homework11;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        // Шаг 1 Загрузить автомобили в список

        try(Scanner scanner = new Scanner(System.in)) {
            String newCarStr = "START";
            while(!newCarStr.isEmpty()) {
                newCarStr = scanner.nextLine();
                String[] newCarStrParams = newCarStr.split("\\|");

                Car newCar = new Car();
                newCar.setCarNumber(newCarStrParams[0]);
                newCar.setModel(newCarStrParams[1]);
                newCar.setColor(newCarStrParams[2]);
                newCar.setMileage(Long.parseLong(newCarStrParams[3]));
                newCar.setPrice(Long.parseLong(newCarStrParams[4]));
                System.out.println(newCar);
                cars.add(newCar);
            }

        } catch(RuntimeException exception) {
            exception.getClass();
        }

        // Шаг 2 Применить функции к списку автомобилей - создать фильтры

         // 1)   Номера   всех   автомобилей,   имеющих   заданный   в   переменной   цвет colorToFind или нулевой пробег mileageToFind.
        String color = "Black";
        Long mileage = 0L;


        Predicate<Car> filterCarByColorOrMileage = car ->
                 car.getColor().equals(color) || car.getMileage().equals(mileage);

        // 2) Количество уникальных моделей в ценовом диапазоне от n до m тыс.
        Long startPrice = 900_000L;
        Long endPrice = 950_000L;

        Predicate<Car> filterCarByStartEndPrice = car ->
                car.getPrice() >= startPrice && car.getPrice() <= endPrice;

        //3) Вывести цвет автомобиля с минимальной стоимостью.
        // Предикат не нужен

        // 4) Среднюю стоимость искомой модели modelToFind
        String modelToFind = "Toyota";
        Predicate<Car> filterCarByModel = car -> car.getModel().equals(modelToFind);

        //Создать стримы для работы

        // 1)   Номера   всех   автомобилей,
        // имеющих   заданный   в   переменной   цвет
        // colorToFind или нулевой пробег mileageToFind.
        List<String> carNumbers = cars
                .stream()
                .filter(filterCarByColorOrMileage)
                .map(Car::getCarNumber)
                .toList();

        System.out.printf("Исходный список автомобилей: %s\n", String.join(", ", cars.toString()));
        System.out.printf("Заданный цвет colorToFind: %s\n", color);
        System.out.printf("Заданный пробег mileageToFind: %d\n", mileage);
        System.out.printf("Список автомобилей: %s\n", String.join(", ", carNumbers));

        // 2) Количество уникальных моделей в ценовом диапазоне от n до m тыс.
        Long countDistinctCarsByPrice = cars
                .stream()
                .filter(filterCarByStartEndPrice)
                .distinct()
                .count();

        System.out.printf("Исходный список автомобилей: %s\n", String.join(", ", cars.toString()));
        System.out.printf("Заданный диапазон цен: от %d до %d\n", startPrice, endPrice);
        System.out.printf("Количество уникальных моделей в ценовом диапазоне: %d\n", countDistinctCarsByPrice);

        //3) Вывести цвет автомобиля с минимальной стоимостью.
        // Предикат не нужен

        try {
            String carColorWithMinPrice = cars
                    .stream()
                    .min(Comparator.comparingLong(Car::getPrice))
                    .orElseThrow().getColor();

            System.out.printf("Исходный список автомобилей: %s\n", String.join(", ", cars.toString()));
            System.out.printf("Вывести цвет автомобиля с минимальной стоимостью: %s\n", carColorWithMinPrice);


            // 4) Среднюю стоимость искомой модели modelToFind
            OptionalDouble optionalAverageCarPrice  = cars
                    .stream()
                    .filter(filterCarByModel)
                    .map(Car::getPrice)
                    .mapToDouble(price -> price)
                    .average();


            Double averageCarPrice = optionalAverageCarPrice.orElseThrow();


            System.out.printf("Исходный список автомобилей: %s\n", String.join(", ", cars.toString()));
            System.out.printf("Заданная модель modelToFind: %s\n", modelToFind);
            System.out.printf("Средняя стоимость модели modelToFind: %.2f\n", averageCarPrice);

            System.out.println();
        } catch(NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        }



    }
}