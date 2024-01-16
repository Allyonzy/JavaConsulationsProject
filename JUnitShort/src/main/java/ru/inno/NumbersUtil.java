package ru.inno;

public class NumbersUtil {
    // 1 способ
    // 113 -> 2, 3, 4, 5, 6, 7, 8, 9, ..., 112

    // 2 способ
    // 113 -> 2, 3, 4, 5, ..., 56

    // 3 способ, i < sqrt(x) -> i^2 < x -> i * i < x
    // 113 -> 2, 3, 4, 5, 6, 7, 8, 9, 10
    public boolean isPrime(int number) {

        if (number == 0 || number == 1) {
            throw new IllegalArgumentException("Not correct number");
        }

        if (number == 2 || number == 3) {
            return true;
        }

        // нам подали на вход число, переберем все его делители
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
