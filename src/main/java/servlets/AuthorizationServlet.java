package servlets;

import cookies.Cookies;
import dao.UsersDao;
import dao.UsersDaoJdbcImpl;
import dao.UsersDoaJdbcTemplateImpl;
import exceptions.DbException;
import exceptions.DuplicateEntryException;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.applet.Applet;
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

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new IllegalArgumentException(e);
//        }
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/wc_proj_users");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("BVB09");
//        usersDao = new UsersDoaJdbcTemplateImpl(dataSource);
//    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context = (ApplicationContext)config.getServletContext().getAttribute("context");
        usersDao = (UsersDao) context.getBean("usersDao");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("signup") != null) {

            login = req.getParameter("login");
            password = req.getParameter("pass");
            String cpassword = req.getParameter("cpassword");
            name = req.getParameter("name");
            lastname = req.getParameter("lname");
            gender = req.getParameter("gender");
            bday = req.getParameter("bday") + " " + req.getParameter("bmon") + " " + req.getParameter("byear");
            city = req.getParameter("city");
            email = req.getParameter("email");
            telephone = req.getParameter("phone");

            if (    login != null &&
                    password != null &&
                    password.equals(cpassword) &&
                    name != null &&
                    lastname != null &&
                    gender != null &&
                    bday != null &&
                    city != null &&
                    email != null &&
                    telephone != null
                    ) {
//                try {
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
                    return;
//                } catch (DbException ex) {
//                    req.setAttribute("message", "Error with DB was occured.");
//                }
//                catch (DuplicateEntryException ex) {
//                    req.setAttribute("message", "User with such login already exists.");
//                }
            } else {
                super.forward("/worldcup/authorization.jsp", req, resp);
                req.setAttribute("message", "You have to fill all fields.");
            }
        } else {
            if (req.getParameter("signin") != null) {
                enterLogin = req.getParameter("enterlogin");
                enterPass = req.getParameter("enterpass");
                if (usersDao.getPasswordByLogin(enterLogin).equals(enterPass)) {
//                    Cookies login = new Cookies();
//                    login.addCookie("login", enterLogin, resp);
//                    String loginValue = login.getCookie("login", req).getValue();
//                    req.setAttribute("loginCookie", loginValue);

                    Cookie login = new Cookie("loginCookie", enterLogin);
                    login.setMaxAge(60*60);
                    resp.addCookie(login);

                    super.forward("/worldcup/profile.jsp", req, resp);
                }
            }
        }
    }
}

