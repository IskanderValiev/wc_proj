package services.newsservices;

import models.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();
    void addNews(News news);
}
