package ru.innopolis;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/pcs_2",
                "postgres", "qwerty007");

        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        System.out.println(usersRepository.findAll());

        User user = User.builder()
                .age(10)
                .firstName("Рита")
                .lastName("Скитер")
                .build();

        usersRepository.save(user);

    }
}
