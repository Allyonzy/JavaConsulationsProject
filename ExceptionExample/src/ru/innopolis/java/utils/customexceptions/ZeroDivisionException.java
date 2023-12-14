package ru.innopolis.java.utils.customexceptions;

public class ZeroDivisionException extends ArithmeticException {
    public ZeroDivisionException(String errorMessage) {
        super(errorMessage);
    }
}
