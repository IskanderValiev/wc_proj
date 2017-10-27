package dao.playersdao;

import dao.CrudDao;
import models.Player;

import java.util.List;

public interface PlayersDao extends CrudDao<Player, Long> {
    List<Player> findAllByClub(String club);
    List<Player> findAllByCountry(String country);
    String getClub(String club);
    String getColumnByName(String columnName, String name);
}
