package services.usersservices;

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

    @Override
    public String getLoginByEmail(String email) {
        return usersDao.getLoginByEmail(email);
    }

    @Override
    public boolean exists(String login) {
        return usersDao.exists(login);
    }

    @Override
    public boolean existingEmail(String email) {
        return usersDao.existingEmail(email);
    }

    @Override
    public boolean isAdmin(String login) {
        return usersDao.isAdmin(login);
    }

    @Override
    public void updateUsersData(String login, String chandeableColumnName, String value) {
        usersDao.updateUsersData(login, chandeableColumnName, value);
    }

    @Override
    public String getLoginByPassword(String password) {
        return usersDao.getLoginByPassword(password);
    }
}
