package ru.innopolis;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();

    void save(User user);
}
