package ru.innopolis;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into account(first_name, last_name, age) values(?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id";

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<User> userRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        int age = row.getInt("age");

        return new User(id, firstName, lastName, age);
    };

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update(SQL_INSERT, user.getFirstName(), user.getLastName(), user.getAge());
    }

}
