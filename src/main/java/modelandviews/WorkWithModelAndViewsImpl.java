package modelandviews;

import models.Country;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class WorkWithModelAndViewsImpl implements WorkWithModelAndViews {

    @Override
    public ModelAndView showUsersData(String login,
                          String name,
                          String gender,
                          String bday,
                          String city,
                          String telephone,
                          String email,
                          String view) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("login", login);
        modelAndView.addObject("name", name);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("bday", bday);
        modelAndView.addObject("city", city);
        modelAndView.addObject("telephone", telephone);
        modelAndView.addObject("email", email);
        modelAndView.setViewName(view);
        return modelAndView;
    }

    @Override
    public ModelAndView throwException(String message, String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @Override
    public ModelAndView showAllTeams(List<Country> countryList, String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("countries", countryList);
        modelAndView.setViewName("teams");
        return modelAndView;
    }
}
