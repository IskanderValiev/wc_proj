package controllers;

import cookies.Cookies;
import cookies.CookiesImpl;
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
import services.countriesservices.CountryService;
import services.countriesservices.CountryServiceImpl;
import services.usersservices.UsersService;
import sessions.Sessions;
import sessions.SessionsImpl;
import validators.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String login = cookies.getCookie("login", request).getValue();
        String name = usersService.getParameterByLogin("name", login) + " " + usersService.getParameterByLogin("lastname", login);
        String gender = usersService.getParameterByLogin("gender", login);
        String bday = usersService.getParameterByLogin("bday", login);
        String city = usersService.getParameterByLogin("city", login);
        String telephone = usersService.getParameterByLogin("telephone", login);
        String email = usersService.getParameterByLogin("email", login);
        modelAndView = workWithModelAndViews.showUsersData(login, name, gender, bday, city, telephone, email, "profile");
        return modelAndView;
    }


    @RequestMapping(value = "/profile", method = {RequestMethod.POST})
    public ModelAndView entrance(@RequestParam(value = "signin", required = false) String signin, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();

        if (signin != null) {

            String enterlogin = request.getParameter("enterlogin");
            String enterpassword = request.getParameter("enterpass");
            String email = usersService.getParameterByLogin("email", enterlogin);

            if (enterpassword.equals(usersService.getParameterByLogin("password", enterlogin)) &&
                    enterlogin.equals(usersService.getLoginByEmail(email))) {

                Cookies cookies = new CookiesImpl();
                cookies.addCookie("login", enterlogin, response, 20*60);

                Sessions sessions = new SessionsImpl();
                sessions.addSession("login", enterlogin, request);

                String name = usersService.getParameterByLogin("name", enterlogin) + " " + usersService.getParameterByLogin("lastname", enterlogin);
                String gender = usersService.getParameterByLogin("gender", enterlogin);
                String bday = usersService.getParameterByLogin("bday", enterlogin);
                String city = usersService.getParameterByLogin("city", enterlogin);
                String telephone = usersService.getParameterByLogin("telephone", enterlogin);

                modelAndView = workWithModelAndViews.showUsersData(enterlogin, name, gender, bday, city, telephone, email, "profile");
                modelAndView.setViewName("redirect:/profile");
            } else {
                modelAndView = workWithModelAndViews.throwException("Login or password is incorrect.", "index");
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam(value = "signup", required = false) String signup, HttpServletRequest request, HttpServletResponse response) {
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

            if(Validator.isCorrect(login, password, cpassword, name, lastname, gender, bday, city, email, telephone)) {
                usersService.addUser(User.builder()
                        .login(login)
                        .password(password)
                        .name(name)
                        .lastname(lastname)
                        .gender(gender)
                        .bday(bday)
                        .city(city)
                        .telephone(telephone)
                        .email(email)
                        .build());
                modelAndView.setViewName("success");
            } else {
                modelAndView = workWithModelAndViews.throwException("You have to fill all fields", "index");
            }
        }
        return modelAndView;
    }
}
