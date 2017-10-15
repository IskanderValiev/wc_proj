package services.usersservices;

import models.User;

public interface UsersService {
    void addUser(User user);
    String getParameterByLogin(String paramName, String login);
    String getLoginByEmail(String email);
}
