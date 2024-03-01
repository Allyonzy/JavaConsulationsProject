package ru.innopolis.springbootappexample.services;

import ru.innopolis.springbootappexample.model.User;

import java.util.List;

public interface UsersServices {
    List<User> getAll();
}
