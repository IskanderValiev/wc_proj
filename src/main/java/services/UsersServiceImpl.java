package services;

import dao.usersdao.UsersDao;
import lombok.AllArgsConstructor;
import models.User;

@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    @Override
    public void addUser(User user) {
        usersDao.save(user);
    }

    @Override
    public String getParameterByLogin(String paramName, String login) {
        return usersDao.getColumnByLogin(paramName, login);
    }
}
