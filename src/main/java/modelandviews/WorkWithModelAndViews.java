package modelandviews;

import models.Country;
import models.News;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface WorkWithModelAndViews {

    ModelAndView showUsersData(String login,
                           String name,
                           String gender,
                           String bday,
                           String city,
                           String telephone,
                           String email,
                           String viewName);

    ModelAndView throwException(String message, String viewName);

    ModelAndView showAllTeams(List<Country> countryList, String viewName);

    ModelAndView addNews(String newsHeader, String newsText, String viewName);

    ModelAndView showAllContent(List<News> newsList, List<News> articleList, List<News> blogList, String viewName);

//    ModelAndView showArcticles(List<News> newsList, String viewName);

//    ModelAndView showBlogs(List<News> newsList, String viewName);
}
