package ru.innopolis.app;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.innopolis.model.User;
import ru.innopolis.repository.UsersRepository;
import ru.innopolis.repository.UsersRepositoryJdbcTemplateImpl;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("Projects\\24. SQL & JDBC\\src\\main\\resources\\db.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataSource dataSource = new DriverManagerDataSource(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password")
        );

        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);

        System.out.println(usersRepository.findAll());

        User user = new User(1, "Антон", "Рихтер", 20);

        usersRepository.save(user);

        List<User> listByName = usersRepository.findByName("Антон");

        listByName.forEach(u -> System.out.println(u.toString()));

    }
}
