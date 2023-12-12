package repository;

import model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class UserRepositoryImpl implements UserRepository{
    private static final String FILE_NAME = "streamsapi/src/data/input_data.txt";

    private static final Function<String, User> userMapper = line -> {
      String[] parseLine = line.split("\\|");
      return new User(
              Integer.parseInt(parseLine[0]),
              parseLine[1],
              parseLine[2],
              Integer.parseInt(parseLine[3]),
              Boolean.getBoolean(parseLine[4])
      );
    };

    /**
     * Поиск пользователя по имени и возрасту
     *
     * @param name - имя пользователя
     * @param age  - возраст пользователя
     * @return список пользователей
     */
    @Override
    public List<User> findByLogNameAndAge(String name, Integer age) {
        return null;
    }

    /**
     * @param lowBound
     * @param upperBound
     * @return
     */
    @Override
    public Integer countDistinctByAgeInterval(Integer lowBound, Integer upperBound) {
        return null;
    }

    /**
     * @param minAge
     * @return
     */
    @Override
    public String findNameByMinAge() {
        try(BufferedReader reader = new BufferedReader(new FileReader((FILE_NAME)))) {
            Optional<User> minAgeUser = reader
                    .lines()
                    .map(userMapper)
                    .min(Comparator.comparingInt(User::getAge));

            return minAgeUser.map(User::getLogName).orElse(null);
        } catch (IOException ioException) {
            throw new IllegalArgumentException(ioException);
        }
    }

    /**
     * @return
     */
    @Override
    public Double findAverageAgeByAvatarColor(String color) {
        try(BufferedReader reader = new BufferedReader(new FileReader((FILE_NAME)))) {
            List<Integer> agesByColor = reader
                    .lines()
                    .map(userMapper)
                    .filter(user -> user.getAvatarColor().equals(color))
                    .map(User::getAge)
                    .toList();
            OptionalDouble averageAge = agesByColor.stream().mapToDouble(age -> age).average();

            return averageAge.isPresent() ? averageAge.getAsDouble() : 0d;
        } catch (IOException ioException) {
            throw new IllegalArgumentException(ioException);
        }
    }
}
