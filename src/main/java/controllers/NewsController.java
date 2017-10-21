package controllers;

import comparators.DateComporator;
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
import java.util.List;

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

        List<News> news = newsService.getAllNews();
        System.out.println(news.toString());
        news.sort(new DateComporator());

        System.out.println(news.toString());

        List<News> articles = newsService.getAllArticles();
        articles.sort(new DateComporator());

        List<News> blogs = newsService.getAllBlogs();
        blogs.sort(new DateComporator());
        if (usersService.isAdmin(login)) {
            modelAndView = workWithModelAndViews.showAllContent(news, articles, blogs, "admin/adminnews");
        } else {
            modelAndView = workWithModelAndViews.showAllContent(news, articles, blogs, "news");
        }
        return modelAndView;
    }
}
