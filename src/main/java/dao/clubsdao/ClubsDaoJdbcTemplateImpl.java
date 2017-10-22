package dao.clubsdao;

import lombok.AllArgsConstructor;
import models.Club;
import models.Country;
import models.News;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class ClubsDaoJdbcTemplateImpl implements ClubsDao {


    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterTemplate;

    Map<String, Club> clubs;

    public ClubsDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
        clubs = new HashMap<>();
    }

    private RowMapper<Club> clubRowMapper = (resultSet, rowNumber) ->
            Club.builder()
                    .id(resultSet.getLong(1))
                    .name(resultSet.getString(2))
                    .country(resultSet.getString(3))
                    .logo(resultSet.getString(4))
                    .build();

    @Override
    public void save(Club model) {

    }

    @Override
    public Club find(String login) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Club model) {

    }

    @Override
    public String getLogo(String clubName) {
        return null;
    }
}
