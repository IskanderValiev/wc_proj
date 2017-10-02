package servlets;

import cookies.Cookies;
import dao.UsersDao;
import dao.UsersDoaJdbcTemplateImpl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by isko on 9/23/17.
 */
public class AuthorizationServlet extends DispatcherServlet {
    private String login;
    private String password;
    private String name;
    private String lastname;
    private String gender;
    private String bday;
    private String city;
    private String email;
    private String telephone;

    private String enterLogin;
    private String enterPass;

    private UsersDao usersDao;

    private Cookies cookies;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/wc_proj_users");
        dataSource.setUsername("postgres");
        dataSource.setPassword("BVB09");
        usersDao = new UsersDoaJdbcTemplateImpl(dataSource);

        cookies = new Cookies();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("signup") != null) {

            login = req.getParameter("login");
            password = req.getParameter("pass");
            name = req.getParameter("name");
            lastname = req.getParameter("lname");
            gender = req.getParameter("gender");
            bday = req.getParameter("bday") + " " + req.getParameter("bmon") + " " + req.getParameter("byear");
            city = req.getParameter("city");
            email = req.getParameter("email");
            telephone = req.getParameter("phone");

            User user = User.builder()
                    .login(login)
                    .password(password)
                    .name(name)
                    .lastname(lastname)
                    .gender(gender)
                    .bday(bday)
                    .city(city)
                    .telephone(telephone)
                    .email(email)
                    .build();

            usersDao.save(user);
            super.forward("/worldcup/success.jsp", req, resp);
        } else {
            if (req.getParameter("signin") != null) {

                enterLogin = req.getParameter("enterlogin");
                enterPass = req.getParameter("enterpass");

                if (usersDao.getPasswordByLogin(enterLogin).equals(enterPass)) {
                    cookies.addCookie("login", enterLogin, resp);
                    cookies.addCookie("password", enterPass, resp);
                    super.forward("/worldcup/profile.jsp", req, resp);
                }
            } else {
                if (usersDao.getPasswordByLogin(cookies.getCookie("login", req).getValue()).equals(cookies.getCookie("password", req).getValue())) {
                    super.forward("/worldcup/profile.jsp", req, resp);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (usersDao.getPasswordByLogin(cookies.getCookie("login", req).getValue()).equals(cookies.getCookie("password", req).getValue())) {
            super.forward("/worldcup/profile.jsp", req, resp);
        }
    }
}

