package dao.clubsdao;

import dao.CrudDao;
import models.Club;

public interface ClubsDao extends CrudDao<Club, Long> {

    String getLogo(String clubName);
}
