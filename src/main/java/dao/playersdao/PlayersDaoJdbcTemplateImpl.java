package dao.playersdao;

import models.Player;
import models.User;
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

public class PlayersDaoJdbcTemplateImpl implements PlayersDao {

    //language=SQL
    private static final String SQL_INSERT_PLAYER =
            "INSERT INTO players (player_number, player_position, player_name, player_lastname, player_age, player_club, player_country) VALUES (?, ?, ?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_PLAYER_BY_LOGIN =
            "SELECT * FROM players WHERE login = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_BY_CLUB =
            "SELECT * FROM players WHERE club = :club";

    //language=SQL
    private static final String SQL_SELECT_PASSWORD_BY_LOGIN =
            "SELECT password FROM users WHERE login = ?";

    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterTemplate;

    Map<Long, Player> players;

    public PlayersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
        players = new HashMap<>();
    }

    private RowMapper<Player> playerRowMapper = (resultSet, rowNumber) -> {
        // смотрим id текущего пользователя
        Long currentPlayerId = resultSet.getLong(1);
        // если такой пользователь еще не был зарегистрирован - кладем его в map
        if (players.get(currentPlayerId) == null) {
            players.put(currentPlayerId,Player.builder()
                    .id(currentPlayerId)
                    .number(resultSet.getInt(2))
                    .position(resultSet.getString(3))
                    .name(resultSet.getString(4))
                    .lastname(resultSet.getString(5))
                    .age(resultSet.getInt(6))
                    .club(resultSet.getString(7))
                    .country(resultSet.getString(8))
                    .build());
        }
        return players.get(currentPlayerId);
    };

    @Override
    public List<Player> findAllByClub(String club) {
        Map<String, Object> params = new HashMap<>();
        params.put("club", club);
        return namedParameterTemplate.query(SQL_SELECT_ALL_BY_CLUB,
                params, playerRowMapper);
    }

    @Override
    public void save(Player model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                connection -> {
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(SQL_INSERT_PLAYER, new String[]{"id"});
                    preparedStatement.setInt(1, model.getNumber());
                    preparedStatement.setString(2, model.getPosition());
                    preparedStatement.setString(3, model.getName());
                    preparedStatement.setString(4, model.getLastname());
                    preparedStatement.setInt(5, model.getAge());
                    preparedStatement.setString(6, model.getClub());
                    preparedStatement.setString(7, model.getCountry());
                    return preparedStatement;
                },
                keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Player find(String login) {
        Player player = template.query(SQL_SELECT_PLAYER_BY_LOGIN, new String[]{login}, playerRowMapper).get(0);
        players.clear();
        return player;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void update(Player model) {
    }

    @Override
    public String getPasswordByLogin(String login) {
        return template.queryForObject(SQL_SELECT_PASSWORD_BY_LOGIN, new String[]{login}, String.class);
    }

    @Override
    public String getColumnByLogin(String columnName, String login) {
        String sql_select_column_by_login = "SELECT " + columnName + " FROM players WHERE login = ?";
        return template.queryForObject(sql_select_column_by_login, new String[]{login}, String.class);
    }
}
