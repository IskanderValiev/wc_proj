package dao.usersdao;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by isko on 9/25/17.
 */
public class UsersDaoJdbcImpl implements UsersDao {
    private Connection connection;

    //language=SQL
    private static final String SQL_INSERT_USER =
            "insert into users (login, password, name, lastname, city, bday, gender, telephone) values (?, ?, ?, ?, ?, ?, ?, ?);";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "";

    @Override
    public void save(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, new String[] {"id"});
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getName());
            statement.setString(4, model.getLastname());
            statement.setString(5, model.getCity());
            statement.setString(6, model.getBday());
            statement.setString(7, model.getGender());
            statement.setString(8, model.getTelephone());

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                long id = resultSet.getLong(1);
                model.setId(id);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public User find(String login) {
        try {
            PreparedStatement statement = connection.prepareStatement("");
            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getLong("id"))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .name(resultSet.getString("name"))
                        .lastname(resultSet.getString("lastname"))
                        .city(resultSet.getString("city"))
                        .bday(resultSet.getString("bday"))
                        .build();
            } else throw new IllegalArgumentException("User not found");
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public String getPasswordByLogin(String login) {
        return null;
    }

    @Override
    public String getColumnByLogin(String columnName, String login) {
        return null;
    }
}
