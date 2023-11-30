package ru.innopolis.phonecover;

@FunctionalInterface
public interface PhoneSystemLogger<T, S, U> {
    String log(T phone, S authorisingKey, U dayOfWeek);
}
