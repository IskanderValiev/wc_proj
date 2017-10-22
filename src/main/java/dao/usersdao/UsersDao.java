package dao.usersdao;

import dao.CrudDao;
import models.User;

/**
 * Created by isko on 9/25/17.
 */
public interface UsersDao extends CrudDao<User, Long> {

    String getPasswordByLogin(String login);
    String getColumnByLogin(String columnName, String login);
    String getLoginByEmail(String email);
    boolean exists(String login);
    boolean existingEmail(String email);
    boolean isAdmin(String login);
    void updateUsersData(String login, String changeableColumnName , String value);
    String getLoginByPassword(String password);
}
