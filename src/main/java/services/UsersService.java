package services;

import models.User;

public interface UsersService {
    void addUser(User user);
    String getParameterByLogin(String paramName, String login);
}
