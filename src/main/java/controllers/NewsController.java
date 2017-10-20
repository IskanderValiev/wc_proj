package controllers;

import cookies.CookiesImpl;
import encoders.Encoder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import models.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.newsservices.NewsService;
import services.usersservices.UsersService;
import validators.NewsValidator;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Controller
@AllArgsConstructor
@Getter
public class NewsController {

    private NewsService newsService;
    private UsersService usersService;

    @RequestMapping(value = "/addnews", method = RequestMethod.POST)
    public ModelAndView addNews(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String newsHeader = request.getParameter("header");
        String newsText = request.getParameter("text");
        String newsImage = request.getParameter("imagePath");
        String newsType = request.getParameter("type");
        if (NewsValidator.isCorrect(newsHeader, newsText, newsImage, newsType)) {
            newsService.addNews(News.builder()
                                    .header(newsHeader)
                                    .content(newsText)
                                    .image(newsImage)
                                    .date(new Date(System.currentTimeMillis()))
                                    .type(newsType)
                                    .build());
        }
        modelAndView.setViewName("redirect:/news");
        return modelAndView;
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ModelAndView showNews(HttpServletRequest request) {
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        ModelAndView modelAndView;
        String login = Encoder.decryptCookie("iskander", new CookiesImpl().getCookie("login", request).getValue());
        if (usersService.isAdmin(login)) {
            modelAndView = workWithModelAndViews.showAllContent(newsService.getAllNews(), newsService.getAllArticles(), newsService.getAllBlogs(), "admin/adminnews");
        } else {
            modelAndView = workWithModelAndViews.showAllContent(newsService.getAllNews(), newsService.getAllArticles(), newsService.getAllBlogs(), "news");
        }
        return modelAndView;
    }
}
