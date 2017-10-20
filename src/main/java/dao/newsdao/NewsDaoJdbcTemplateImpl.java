package dao.newsdao;

import models.News;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsDaoJdbcTemplateImpl implements NewsDao {

    //language=SQL
    private static final String SQL_INSERT_NEWS =
            "INSERT INTO news(news_header, news_content, news_image, news_date, news_type) VALUES (?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_ALL_NEWS =
            "SELECT * FROM news WHERE news_type = :news_type";

    //language=SQL
    private static final String SQL_SELECT_ALL_ARTICLES =
            "SELECT * FROM news WHERE news_type = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_BLOGS =
            "SELECT * FROM news WHERE news_type = ?";

    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterTemplate;

    Map<String, News> news;

    public NewsDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
        news = new HashMap<>();
    }

    private RowMapper<News> newsRowMapper = (resultSet, rowNumber) ->
            News.builder()
                    .id(resultSet.getLong(6))
                    .header(resultSet.getString(1))
                    .content(resultSet.getString(2))
                    .image(resultSet.getString(3))
                    .date(resultSet.getDate(4))
                    .type(resultSet.getString(5))
                    .build();

    @Override
    public void save(News model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                connection -> {
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(SQL_INSERT_NEWS, new String[]{"news_id"});
                    preparedStatement.setString(1, model.getHeader());
                    preparedStatement.setString(2, model.getContent());
                    preparedStatement.setString(3, model.getImage());
                    preparedStatement.setDate(4, model.getDate());
                    preparedStatement.setString(5, model.getType());
                    return preparedStatement;
                },
                keyHolder);
        model.setId(keyHolder.getKey().longValue());
//        template.update(SQL_INSERT_NEWS, new Object[] {
//                model.getHeader(),
//                model.getContent(),
//                model.getImage(),
//                model.getDate(),
//                model.getType()
//        });
    }

    @Override
    public News find(String login) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(News model) {

    }

    @Override
    public List<News> getAllNews() {
        Map<String, Object> params = new HashMap<>();
        params.put("news_type", "News");
        return namedParameterTemplate.query(SQL_SELECT_ALL_NEWS, params, newsRowMapper);
    }

    @Override
    public List<News> getAllArticles() {
        Map<String, Object> params = new HashMap<>();
        params.put("news_type", "Article");
        return namedParameterTemplate.query(SQL_SELECT_ALL_NEWS, params, newsRowMapper);
    }

    @Override
    public List<News> getAllBlogs() {
        Map<String, Object> params = new HashMap<>();
        params.put("news_type", "Blog");
        return namedParameterTemplate.query(SQL_SELECT_ALL_NEWS, params, newsRowMapper);
    }
}
