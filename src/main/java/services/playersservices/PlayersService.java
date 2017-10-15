package services.playersservices;

import models.Player;

import java.util.List;

public interface PlayersService {
    List<Player> getAllPlayersByCountry(String country);
}
