package ru.innopolis.repository;

import ru.innopolis.model.User;

import java.util.List;

public interface UsersRepository {
    /**
     * Поиск всех пользователей
     * @return - список пользователей
     */
    List<User> findAll();

    /**
     * Поиск в базе по имени
     * @param name - имя
     * @return - список с заданным именем
     */
    List<User> findByName(String name);

    /**
     * Сохранение пользователя в базе данных
     * @param user - измененный пользователь
     */
    void save(User user);
}
