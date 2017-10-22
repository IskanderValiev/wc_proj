package controllers;

import cookies.Cookies;
import cookies.CookiesImpl;
import encoders.Encoder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.usersservices.UsersService;
import sessions.Sessions;
import sessions.SessionsImpl;
import validators.UsersValidator;

import javax.security.auth.login.LoginException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

@Controller
@AllArgsConstructor
@Getter
public class UsersController {

    private UsersService usersService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView openPage(HttpServletRequest request) {
        ModelAndView modelAndView;
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        Cookies cookies = new CookiesImpl();
        Cookie cookie = cookies.getCookie("login", request);
        String login = Encoder.decryptCookie("iskander", cookie.getValue());
        String name = usersService.getParameterByLogin("name", login) + " " + usersService.getParameterByLogin("lastname", login);
        String gender = usersService.getParameterByLogin("gender", login);
        String bday = usersService.getParameterByLogin("bday", login);
        String city = usersService.getParameterByLogin("city", login);
        String telephone = usersService.getParameterByLogin("telephone", login);
        String email = usersService.getParameterByLogin("email", login);
        String image = usersService.getParameterByLogin("photo", login);
        modelAndView = workWithModelAndViews.showUsersData(login, name, gender, bday, city, telephone, email, image, "profile");
        return modelAndView;
    }


    @RequestMapping(value = "/profile", method = {RequestMethod.POST})
    public ModelAndView entrance(@RequestParam(value = "signin", required = false) String signin, HttpServletRequest request, HttpServletResponse response) throws LoginException, NoSuchAlgorithmException{

        ModelAndView modelAndView = new ModelAndView();
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();

        if (signin != null) {

            String enterlogin = request.getParameter("enterlogin");
            String enterpassword = Encoder.encrypt(usersService.getParameterByLogin("salt", enterlogin) + request.getParameter(  "enterpass"));
//            String enterpassword = request.getParameter("enterpass");
            String email = usersService.getParameterByLogin("email", enterlogin);

            if (enterpassword.equals(usersService.getParameterByLogin("password", enterlogin)) &&
                    enterlogin.equals(usersService.getLoginByPassword(enterpassword))) {

                Cookies cookies = new CookiesImpl();
                cookies.addCookie("login", Encoder.encryptCookie("iskander", enterlogin), response, 365*24*60*60);

                if (request.getParameter("remember") != null) {
                    Sessions sessions = new SessionsImpl();
                    sessions.addSession("login", enterlogin, request);
                }

                String name = usersService.getParameterByLogin("name", enterlogin) + " " + usersService.getParameterByLogin("lastname", enterlogin);
                String gender = usersService.getParameterByLogin("gender", enterlogin);
                String bday = usersService.getParameterByLogin("bday", enterlogin);
                String city = usersService.getParameterByLogin("city", enterlogin);
                String telephone = usersService.getParameterByLogin("telephone", enterlogin);
                String image = usersService.getParameterByLogin("photo", enterlogin);

                modelAndView = workWithModelAndViews.showUsersData(enterlogin, name, gender, bday, city, telephone, email, image, "profile");
                modelAndView.setViewName("redirect:/profile");
            } else {
                modelAndView = workWithModelAndViews.throwException("Login or password is incorrect.", "index");
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam(value = "signup", required = false) String signup, HttpServletRequest request, HttpServletResponse response) throws LoginException, NoSuchAlgorithmException{
        ModelAndView modelAndView = new ModelAndView();
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        if (signup != null) {

            String login = request.getParameter("login");
            String password = request.getParameter("pass");
            String cpassword = request.getParameter("cpassword");
            String name = request.getParameter("name");
            String lastname = request.getParameter("lname");
            String gender = request.getParameter("gender");
            String bday = request.getParameter("bday") + " " + request.getParameter("bmon") + " " + request.getParameter("byear");
            String city = request.getParameter("city");
            String email = request.getParameter("email");
            String telephone = request.getParameter("phone");

            String salt = Encoder.salt();

            if(UsersValidator.isCorrect(login, password, cpassword, name, lastname, gender, bday, city, email, telephone)) {
//                if (!usersService.exists(login)) {
//                    if (!usersService.existingEmail(email)) {
                        usersService.addUser(User.builder()
                                .login(login)
                                .password(Encoder.encrypt(salt + password))
                                .name(name)
                                .lastname(lastname)
                                .gender(gender)
                                .bday(bday)
                                .city(city)
                                .telephone(telephone)
                                .email(email)
                                .salt(salt)
                                .build());
                        modelAndView.setViewName("success");
//                    } else {
//                        modelAndView = workWithModelAndViews.throwException("User with such email already exists", "index");
//                    }
//                } else {
//                    modelAndView = workWithModelAndViews.throwException("User with such login already exists", "index");
//                }
            } else {
                modelAndView = workWithModelAndViews.throwException("You have to fill all fields", "index");
            }
        }
        return modelAndView;
    }
}
