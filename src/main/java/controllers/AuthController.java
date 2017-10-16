package controllers;

import cookies.Cookies;
import cookies.CookiesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sessions.Sessions;
import sessions.SessionsImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView entry(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Cookies cookies = new CookiesImpl();
        Cookie cookie = cookies.getCookie("login", request);
        Sessions sessions = new SessionsImpl();
        String session = (String) sessions.getSession("login", request);
        if((session != null && !session.equals("")) || (cookie != null && !cookie.getValue().equals(""))) {
            modelAndView.setViewName("redirect:/profile");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
