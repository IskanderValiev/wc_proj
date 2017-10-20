package services.newsservices;

import dao.newsdao.NewsDao;
import lombok.AllArgsConstructor;
import models.News;

import java.util.List;

@AllArgsConstructor
public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao;

    @Override
    public List<News> getAllNews() {
        return newsDao.getAllNews();
    }

    @Override
    public List<News> getAllArticles() {
        return newsDao.getAllArticles();
    }

    @Override
    public List<News> getAllBlogs() {
        return newsDao.getAllBlogs();
    }

    @Override
    public void addNews(News news) {
        newsDao.save(news);
    }
}
