package controllers;

import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import models.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.newsservices.NewsService;
import validators.NewsValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Controller
public class NewsController {

    private NewsService newsService;

    @RequestMapping(value = "/addnews", method = RequestMethod.POST)
    public ModelAndView addNews(HttpServletRequest request) {
        ModelAndView modelAndView;
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
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
        modelAndView = workWithModelAndViews.addNews(newsHeader, newsText, "adminnews");
        return modelAndView;
    }
}
