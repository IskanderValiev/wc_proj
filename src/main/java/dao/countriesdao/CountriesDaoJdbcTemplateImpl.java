package dao.countriesdao;

import lombok.Getter;
import lombok.Setter;
import models.Country;
import models.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.*;

@Getter
@Setter

public class CountriesDaoJdbcTemplateImpl implements CountriesDao {

    //language=SQL
    private static final String SQL_SELECT_COUNTRY_BY_NAME =
            "SELECT * FROM country WHERE country_name = ?;";

    //language=SQL
    private static final String SQL_INSERT_COUNTRY =
            "INSERT INTO country(country_name, country_flag) VALUES (?, ?);";

    //language=SQL
    private static final String SQL_SELECT_ALL =
            "SELECT * FROM country;";

    //language=SQL
    private static final String SQL_SELECT_ALL_PLAYERS =
            "SELECT * FROM country LEFT JOIN players ON country.country_name = players.player_country;";

    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterTemplate;

    Map<String, Country> countries;

    public CountriesDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
        countries = new HashMap<>();
    }

    private RowMapper<Country> countryRowMapper = (resultSet, rowNumber) ->
      Country.builder()
              .name(resultSet.getString(1))
              .flag(resultSet.getString(2))
              .build();


    @Override
    public Country findCountryByName(String name) {
        template.queryForObject(SQL_SELECT_COUNTRY_BY_NAME, new String[]{"name"}, String.class);
        return null;
    }

    @Override
    public void save(Country model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                connection -> {
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(SQL_INSERT_COUNTRY, new String[]{"id"});
                    preparedStatement.setString(1, model.getName());
                    preparedStatement.setString(2, model.getFlag());
                    return preparedStatement;
                },
                keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Country find(String login) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Country model) {

    }

    @Override
    public List<Country> findALL() {
        return template.query(SQL_SELECT_ALL, countryRowMapper);
    }

    public List<Player> getAllPlayers() {
        return null;
    }
}
