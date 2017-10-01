package servlets;

import dao.UsersDao;
import dao.UsersDoaJdbcTemplateImpl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import users.User;

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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("login");
        password = req.getParameter("pass");
        name = req.getParameter("name");
        lastname = req.getParameter("lname");
        gender = req.getParameter("gender");
        bday = req.getParameter("bday") + " " + req.getParameter("bmon") + " " + req.getParameter("byear");
        city = req.getParameter("city");
        email = req.getParameter("email");
        telephone = req.getParameter("phone");

        enterLogin = req.getParameter("enterlogin");
        enterPass = req.getParameter("enterpass");

        if (req.getParameter("signup") != null) {

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
                if (usersDao.getPasswordByLogin(enterLogin).equals(enterPass)) {
//                    Cookie loginCookie = new Cookie("login", enterLogin);
//                    loginCookie.setMaxAge(365*24*60*60);
//                    resp.addCookie(loginCookie);
//
//                    Cookie passwordCookie = new Cookie("password", enterPass);
//                    passwordCookie.setMaxAge(365*24*60*60);
//                    resp.addCookie(passwordCookie);
//
//                    Cookie[] cookies = req.getCookies();
//
//                    Cookie loginCookie1 = null;
//                    for(int i = 0; i < cookies.length; i++) {
//                        String cookieName = cookies[i].getName();
//                        if (cookieName.equals("login")) {
//                            loginCookie1 = cookies[i];
//                            break;
//                        }
//                    }
//
//                    Cookie passwordCookie1 = null;
//                    for(int i = 0; i < cookies.length; i++) {
//                        String cookieName = cookies[i].getName();
//                        if (cookieName.equals("password")) {
//                            passwordCookie1 = cookies[i];
//                            break;
//                        }
//                    }
                    super.forward("/worldcup/profile.jsp", req, resp);
                }
            }
        }
    }
}

