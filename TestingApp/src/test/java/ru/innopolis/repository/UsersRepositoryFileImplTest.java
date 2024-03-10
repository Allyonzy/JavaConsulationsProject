package ru.innopolis.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.innopolis.exceptions.InvalidUserDataException;
import ru.innopolis.model.User;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {
    /**
     * Поле тестового класса
     */
    private UsersRepositoryFileImpl usersRepository;

    @BeforeEach
    void setUp() {
        usersRepository = new UsersRepositoryFileImpl();
    }

    @Test

    void createUser_AssertThrows_DoesNotThrow() {
        User user = new User(
                "1",
                LocalDateTime.now(),
                "testuser",
                "password",
                "password",
                "Test",
                "User",
                null,
                30,
                true
        );
        assertDoesNotThrow(() -> usersRepository.create(user));
    }

    @Test
    @Order(1)
    void createUser_AssertEquals_EqualUsers() {
        User user = new User(
                "5",
                LocalDateTime.parse("2024-02-16T19:02:06.322683800"),
                "user001",
                "5345464d",
                "6456546456d",
                "Иванов",
                "Иван",
                "Всеволодович",
                21,
                false
        );
        final User[] foundUser = new User[1];

        assertDoesNotThrow(() -> {
            usersRepository.create(user);
            foundUser[0] = usersRepository.findById(user.getId());

        });
        assertEquals(foundUser[0], user);
    }

    @Test
    @Order(2)
    void createDublicateUser_AssertThrows() {
        User user = new User(
                "5",
                LocalDateTime.parse("2024-02-16T19:02:06.322683800"),
                "user001",
                "5345464d",
                "6456546456d",
                "Иванов",
                "Иван",
                "Всеволодович",
                21,
                false
        );
        final User[] foundUser = new User[1];

        assertThrows(RuntimeException.class, () -> {
            usersRepository.create(user);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "9", "2", "3"})
    void findUsers_userFromIdList_doesNotExists(String id) {
        assertDoesNotThrow(() -> {
            usersRepository.findById(id);
            assertNull(usersRepository.findById(id));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "5", "1", "7"})
    void findUsers_userFromIdList_doesExists(String id) {
        assertDoesNotThrow(() -> {
            usersRepository.findById(id);
            assertNotNull(usersRepository.findById(id));
        });
    }

    @ParameterizedTest
    @MethodSource("argsIdTestArray")
    void findUsers_userFromIdStream_doesExists(String id) {
        assertDoesNotThrow(() -> {
            usersRepository.findById(id);
            assertNotNull(usersRepository.findById(id));
        });
    }

    static Stream<String> argsIdTestArray() {
        return Stream.of("5", "1", "7");
    }

    @Test
    void deleteById() {
        User user = new User(
                "67",
                LocalDateTime.parse("2024-02-16T12:02:06.322683800"),
                "user001",
                "5345464d",
                "6456546456d",
                "Иванов",
                "Иван",
                "Всеволодович",
                21,
                false
        );

        assertDoesNotThrow(() -> {
            usersRepository.create(user);
            usersRepository.deleteById(user.getId());
            assertNull(usersRepository.findById(user.getId()));
        });
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/test_update_users.csv",
            delimiter='|'
    )
    void updateUsers_userFromFile_updateName(String id, LocalDateTime dateAdded, String login, String password,
                                             String confirmPassword, String lastName, String firstName,
                                             String patronymic, Integer age, boolean isWorker) {
        User user = new User(id,
                dateAdded,
                login,
                password,
                confirmPassword,
                lastName,
                firstName,
                patronymic, age, isWorker);
        assertDoesNotThrow(() -> usersRepository.create(user));
        user.setFirstName("Валерий");
        assertDoesNotThrow(() -> {
            usersRepository.update(user);
            User updatedUser = usersRepository.findById(user.getId());
            assertEquals(user, updatedUser);
            usersRepository.deleteById(user.getId());
        });
    }

    @Test
    void validateUserTest_ThrownException() {
        User user = new User(
                null,
                LocalDateTime.parse("2024-02-16T12:02:06.322683800"),
                "user001",
                "5345464d",
                "6456546456d",
                "Иванов",
                "Иван",
                "Всеволодович",
                21,
                false
        );
        assertThrows(InvalidUserDataException.class, () -> {
            usersRepository.validateUser(user);
        });
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/test_not_valid_users.csv",
            delimiter=','
    )
    void validateUserTest_ThrownException(String id, LocalDateTime dateAdded, String login, String password,
                                          String confirmPassword, String lastName, String firstName,
                                          String patronymic, Integer age, boolean isWorker) {
        User user = new User(id,
                dateAdded,
                login,
                password,
                confirmPassword,
                lastName,
                firstName,
                patronymic, age, isWorker);
        assertThrows(InvalidUserDataException.class, () -> {
            usersRepository.validateUser(user);
        });
    }
}