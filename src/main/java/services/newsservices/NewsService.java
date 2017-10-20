package services.newsservices;

import models.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();
    List<News> getAllArticles();
    List<News> getAllBlogs();
    void addNews(News news);
}
