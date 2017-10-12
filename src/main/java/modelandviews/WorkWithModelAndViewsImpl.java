package modelandviews;

import org.springframework.web.servlet.ModelAndView;

public class WorkWithModelAndViewsImpl implements WorkWithModelAndViews {
    @Override
    public ModelAndView addObject(String login,
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
}
