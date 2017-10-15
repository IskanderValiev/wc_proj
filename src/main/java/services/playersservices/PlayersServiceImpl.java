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
}
