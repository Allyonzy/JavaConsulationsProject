package ru.inno;

public class Main {
    public static void main(String[] args) {
        NumbersUtil numbersUtil = new NumbersUtil();

        System.out.println(numbersUtil.isPrime(7)); // true
        System.out.println(numbersUtil.isPrime(6)); // false
        System.out.println(numbersUtil.isPrime(121)); // false
        System.out.println(numbersUtil.isPrime(113)); // true
        System.out.println(numbersUtil.isPrime(169)); // false
        System.out.println(numbersUtil.isPrime(99)); // false
    }
}