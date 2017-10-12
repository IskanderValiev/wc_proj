package controllers;

import cookies.Cookies;
import cookies.CookiesImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@AllArgsConstructor
@Getter
public class UsersController {

    private UsersService usersService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView openPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        Cookies cookies = new CookiesImpl();
        String login = cookies.getCookie("login", request).getValue();
        String name = usersService.getParameterByLogin("name", login) + " " + usersService.getParameterByLogin("lastname", login);
        String gender = usersService.getParameterByLogin("gender", login);
        String bday = usersService.getParameterByLogin("bday", login);
        String city = usersService.getParameterByLogin("city", login);
        String telephone = usersService.getParameterByLogin("telephone", login);
        String email = usersService.getParameterByLogin("email", login);
        modelAndView = workWithModelAndViews.addObject(login, name, gender, bday, city, telephone, email, "profile");
        return modelAndView;
    }


    @RequestMapping(value = "/profile", method = {RequestMethod.POST})
    public ModelAndView entrance(@RequestParam(value = "signin", required = false) String signin, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        if (signin != null) {
            String enterlogin = request.getParameter("enterlogin");
            String enterpassword = request.getParameter("enterpass");
            if (enterpassword.equals(usersService.getParameterByLogin("password", enterlogin))) {
                Cookies cookies = new CookiesImpl();
                cookies.addCookie("login", enterlogin, response, 20*60);
                String login = cookies.getCookie("login", request).getValue();
                String name = usersService.getParameterByLogin("name", login) + " " + usersService.getParameterByLogin("lastname", login);
                String gender = usersService.getParameterByLogin("gender", login);
                String bday = usersService.getParameterByLogin("bday", login);
                String city = usersService.getParameterByLogin("city", login);
                String telephone = usersService.getParameterByLogin("telephone", login);
                String email = usersService.getParameterByLogin("email", login);
                modelAndView = workWithModelAndViews.addObject(login, name, gender, bday, city, telephone, email, "profile");
                System.out.println(login);
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam(value = "signup", required = false) String signup) {
        if (signup != null) {
            System.out.println("sign up button was pressed");
        }
        System.out.println("finished work");
        return new ModelAndView("redirect:/success");
    }
}
