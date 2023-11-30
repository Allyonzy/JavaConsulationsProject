package ru.innopolis.phonecover;

public class CoverByGeneric<T> {
    private T phone;

    public T getPhone() {
        return phone;
    }

    public void setPhone(T phone) {
        this.phone = phone;
    }
}
