package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    /**
     * Поиск пользователя по имени и возрасту
     * @param name - имя пользователя
     * @param age - возраст пользователя
     * @return список пользователей
     */
    List<User> findByLogNameAndAge(String name, Integer age);

    /**
     *
     * @param lowBound
     * @param upperBound
     * @return
     */
    Integer countDistinctByAgeInterval(Integer lowBound, Integer upperBound);

    String findNameByMinAge();

    Double findAverageAgeByAvatarColor(String color);
}
