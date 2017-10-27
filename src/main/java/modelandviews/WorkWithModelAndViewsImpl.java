package modelandviews;

import models.Country;
import models.News;
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
                          String image,
                          String viewName) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("login", login);
        modelAndView.addObject("name", name);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("bday", bday);
        modelAndView.addObject("city", city);
        modelAndView.addObject("telephone", telephone);
        modelAndView.addObject("email", email);
        modelAndView.addObject("image", image);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @Override
    public ModelAndView showUsersData(String login,
                                      String name,
                                      String lastname,
                                      String gender,
                                      String bday,
                                      String city,
                                      String telephone,
                                      String email,
                                      String image,
                                      String viewName) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("login", login);
        modelAndView.addObject("name", name);
        modelAndView.addObject("lastname", lastname);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("bday", bday);
        modelAndView.addObject("city", city);
        modelAndView.addObject("telephone", telephone);
        modelAndView.addObject("email", email);
        modelAndView.addObject("image", image);
        modelAndView.setViewName(viewName);
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
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @Override
    public ModelAndView addNews(String newsHeader, String newsText, String viewName) {
        return null;
    }

    @Override
    public ModelAndView showAllContent(List<News> newsList, List<News> articleList, List<News> blogList, String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("news", newsList);
        modelAndView.addObject("articles", articleList);
        modelAndView.addObject("blogs", blogList);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @Override
    public ModelAndView showPlayerInfo(String number, String position, String name, String lastname, String age, String club, String country, String photo, String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("number", number);
        modelAndView.addObject("position",  position);
        modelAndView.addObject("name", name);
        modelAndView.addObject("lastname", lastname);
        modelAndView.addObject("age", age);
        modelAndView.addObject("club", club);
        modelAndView.addObject("country", country);
        modelAndView.addObject("photo", photo);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    //    public ModelAndView showAllInformation(String name, String bday, String city, String gender, String email, String instagram) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("name", name);
//        modelAndView.addObject("bday", bday);
//        modelAndView.addObject("city", city);
//        modelAndView.addObject("gender", gender);
//        modelAndView.addObject("email", email);
//        modelAndView.addObject("instagram", instagram);
//        return modelAndView;
//    }
}
