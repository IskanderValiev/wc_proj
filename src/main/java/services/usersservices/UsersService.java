package services.usersservices;

import models.User;

public interface UsersService {
    void addUser(User user);
    String getParameterByLogin(String paramName, String login);
    String getLoginByEmail(String email);
    boolean exists(String login);
    boolean existingEmail(String email);
    boolean isAdmin(String login);
    void updateUsersData(String login, String chandeableColumnName, String value);
    String getLoginByPassword(String password);
}
