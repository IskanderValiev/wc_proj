import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by isko on 9/24/17.
 */
public class DataBase {

    private Connection connection;

    //language=SQL
    private static final String SQL_INSERT_USER =
            "insert into users (login, password, name, lastname, city, bday, gender) values (?, ?, ?, ?, ?, ?, ?);";


    public void addUser(String login, String password, String name, String lastname, String email, String bday, String city) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
