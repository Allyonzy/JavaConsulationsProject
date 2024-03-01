package ru.innopolis.springbootappexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.springbootappexample.model.User;
import ru.innopolis.springbootappexample.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServicesImpl implements UsersServices {

    private final UserRepository userRepository;

    /**
     * Получить всех пользователей из БД
     * @return список пользователей
     */
    @Override
    public List<User> getAll() {
        return userRepository.findAll(); //Select * from user;
    }
}
