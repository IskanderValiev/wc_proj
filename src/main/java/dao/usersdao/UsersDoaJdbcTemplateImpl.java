package dao.usersdao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import models.User;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class UsersDoaJdbcTemplateImpl implements UsersDao {

    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO users (\"login\", password, name, lastname, gender, bday, city, telephone, email, salt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    //language=SQL
    private static final String SQL_SELECT_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

    //language=SQL
    private static final String SQL_DELETE_BY_LOGIN = "DELETE FROM users WHERE login = ?";

    //language=SQL
    private static final String SQL_SELECT_PASSWORD_BY_LOGIN = "SELECT password FROM users WHERE login = ?";

    //language=SQL
    private static final String SQL_CHECKING_USER_EXISTENCE =
            "SELECT id FROM users WHERE login = ?";

    //language=SQL
    private static final String SQL_CHECKING_EMAIL_EXISTANCE =
            "SELECT id FROM users WHERE email = ?";

    //language=SQL
    private static final String SQL_SELECT_STATUS =
            "SELECT status FROM users WHERE login = ?";



    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterTemplate;

    Map<Long, User> users;

    public UsersDoaJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
        users = new HashMap<>();
    }

    private RowMapper<User> userRowMapper = (resultSet, rowNumber) -> {
        // смотрим id текущего пользователя
        Long currentUserId = resultSet.getLong(1);
        // если такой пользователь еще не был зарегистрирован - кладем его в map
        if (users.get(currentUserId) == null) {
            users.put(currentUserId,User.builder()
                    .id(currentUserId)
                    .login(resultSet.getString(2))
                    .password(resultSet.getString(3))
                    .name(resultSet.getString(4))
                    .lastname(resultSet.getString(5))
                    .gender(resultSet.getString(6))
                    .bday(resultSet.getString(7))
                    .city(resultSet.getString(8))
                    .telephone(resultSet.getString(9))
                    .salt(resultSet.getString(11))
                    .build());
        }
        return users.get(currentUserId);
    };

    @Override
    public void save(User model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                connection -> {
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(SQL_INSERT_USER, new String[]{"id"});
                    preparedStatement.setString(1, model.getLogin());
                    preparedStatement.setString(2, model.getPassword());
                    preparedStatement.setString(3, model.getName());
                    preparedStatement.setString(4, model.getLastname());
                    preparedStatement.setString(5, model.getGender());
                    preparedStatement.setString(6, model.getBday());
                    preparedStatement.setString(7, model.getCity());
                    preparedStatement.setString(8, model.getTelephone());
                    preparedStatement.setString(9, model.getEmail());
                    preparedStatement.setString(10, model.getSalt());
                    return preparedStatement;
                },
                keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public User find(String login) {
        User user = template.query(SQL_SELECT_BY_LOGIN, new String[]{login}, userRowMapper).get(0);
        users.clear();
        return user;
    }

    @Override
    public void delete(Long id) {
        template.update(SQL_DELETE_BY_LOGIN, id);
    }

    @Override
    public void update(User model) {}

    @Override
    public String getPasswordByLogin(String login) {
       return template.queryForObject(SQL_SELECT_PASSWORD_BY_LOGIN, new String[]{login}, String.class);
    }

    @Override
    public String getColumnByLogin(String columnName, String login) {
        //language=SQL
        String sql_select_column_by_login = "SELECT \"" + columnName + "\" FROM users WHERE login = ?";

        return template.queryForObject(sql_select_column_by_login, new String[]{login}, String.class);
    }

    @Override
    public String getLoginByEmail(String email) {
        //language=SQL
        String sql_select_login_by_password = "SELECT \"login\" FROM \"users\" WHERE \"email\" = ?";
        return template.queryForObject(sql_select_login_by_password, new String[]{email}, String.class);

    }

    @Override
    public boolean exists(String login) {
        Long id = template.queryForObject(SQL_CHECKING_USER_EXISTENCE, new String[]{login}, Long.class);
        return id != null;
    }

    @Override
    public boolean existingEmail(String email) {
        Long id = template.queryForObject(SQL_CHECKING_EMAIL_EXISTANCE,new String[]{email}, Long.class);
        return id != null;
    }

    @Override
    public boolean isAdmin(String login) {
        return template.queryForObject(SQL_SELECT_STATUS, new String[] {login}, Boolean.class);
    }

    @Override
    public void updateUsersData(String login, String changeableColumnName, String value) {
        //language=SQL
        String sql_update_users = "UPDATE users SET \"" + changeableColumnName + "\"=\'" + value + "\' WHERE login = ?";
        template.update(sql_update_users, login);

    }
}