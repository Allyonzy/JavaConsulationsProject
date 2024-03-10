package ru.innopolis.repository;

import ru.innopolis.exceptions.DataAccessException;
import ru.innopolis.exceptions.InvalidUserDataException;
import ru.innopolis.model.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository {
    private static final String FILE_NAME = "src/main/resources/users.txt";
    private final FileDataManager fileDataManager;

    public UsersRepositoryFileImpl() {
        this.fileDataManager = new FileDataManager(FILE_NAME);
    }

    @Override
    public void create(User user) throws InvalidUserDataException, DataAccessException {
        //todo добавить функционал
    }

    @Override
    public void validateUser(User user) throws InvalidUserDataException {
        //todo добавить функционал
    }

    @Override
    public User findById(String id) throws DataAccessException {
        //todo добавить функционал
        return null;
    }

    @Override
    public List<User> findAll() {
        //todo добавить функционал
        return new ArrayList<>();
    }

    @Override
    public void update(User user) {
        //todo добавить функционал
    }

    @Override
    public void deleteById(String id) {
        //todo добавить функционал
    }

    @Override
    public void deleteAll() {
        //todo добавить функционал
    }

    private void rewriteFile(List<User> users) throws IOException {
        //todo добавить функционал
    }

    private String userToString(User user) {
        //todo добавить функционал
        return String.valueOf("");
    }

    private User stringToUser(String str) {
        //todo добавить функционал
        return new User();
    }
}
