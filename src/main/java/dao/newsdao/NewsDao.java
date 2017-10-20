package dao.newsdao;

import dao.CrudDao;
import models.News;

import java.util.List;

public interface NewsDao extends CrudDao<News, Long> {

    List<News> getAllNews();

    List<News> getAllArticles();

    List<News> getAllBlogs();
}
