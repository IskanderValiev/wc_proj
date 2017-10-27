package services.playersservices;

import models.Player;

import java.util.List;

public interface PlayersService {
    List<Player> getAllPlayersByCountry(String country);
    String getClub(String club);
    String getColumnByName(String columnName, String name);
}
