package controllers;

import cookies.Cookies;
import cookies.CookiesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sessions.Sessions;
import sessions.SessionsImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ExitController {

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public ModelAndView exit(HttpServletResponse response, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Cookies cookies = new CookiesImpl();
        cookies.addCookie("login", "", response, 0);
        HttpSession session = request.getSession();
        session.invalidate();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
