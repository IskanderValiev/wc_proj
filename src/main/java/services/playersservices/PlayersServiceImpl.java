package services.playersservices;

import dao.playersdao.PlayersDao;
import lombok.AllArgsConstructor;
import models.Player;

import java.util.List;

@AllArgsConstructor
public class PlayersServiceImpl implements PlayersService {

    private PlayersDao playersDao;

    @Override
    public List<Player> getAllPlayersByCountry(String country) {
        return playersDao.findAllByCountry(country);
    }

    @Override
    public String getClub(String club) {
        return playersDao.getClub(club);
    }

    @Override
    public String getColumnByName(String columnName, String name) {
        return playersDao.getColumnByName(columnName, name);
    }
}
