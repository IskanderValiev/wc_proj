package modelandviews;

import org.springframework.web.servlet.ModelAndView;

public interface WorkWithModelAndViews {

    ModelAndView addObject(String login,
                           String name,
                           String gender,
                           String bday,
                           String city,
                           String telephone,
                           String email,
                           String viewName);
}
