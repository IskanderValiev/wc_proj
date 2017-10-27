package controllers;

import cookies.Cookies;
import cookies.CookiesImpl;
import encoders.Encoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sessions.Sessions;
import sessions.SessionsImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView entry(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession(true);
        Cookies cookies = new CookiesImpl();
        Cookie cookie = cookies.getCookie("login", request, response);
        String cookieDecryption = "";
        if (cookie != null && !cookie.getValue().equals("guest")) {
            cookieDecryption = Encoder.decryptCookie("iskander", cookie.getValue());
        }
        Sessions sessions = new SessionsImpl();
        String session = (String) sessions.getSession("login", request);
        if((session != null && !session.equals("")) || (cookieDecryption != null && !cookieDecryption.equals(""))) {
            modelAndView.setViewName("redirect:/profile");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
