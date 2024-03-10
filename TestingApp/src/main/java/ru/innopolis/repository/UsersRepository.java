package ru.innopolis.repository;


import ru.innopolis.exceptions.DataAccessException;
import ru.innopolis.exceptions.InvalidUserDataException;
import ru.innopolis.exceptions.UserNotFoundException;
import ru.innopolis.model.User;

import java.util.List;

public interface UsersRepository {
    void create(User user) throws InvalidUserDataException, DataAccessException; // Создание пользователя и запись его в файл

    User findById(String id) throws UserNotFoundException, DataAccessException; // Поиск пользователя в файле по идентификатору

    List<User> findAll(); // Выгрузка всех пользователей из файла

    void update(User user); // Обновление полей существующего в файле пользователя

    void deleteById(String id); // Удаление пользователя по идентификатору

    void deleteAll(); // Удаление всех пользователей

    void validateUser(User user) throws InvalidUserDataException;
}
