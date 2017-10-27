package services.clubsservices;

import dao.clubsdao.ClubsDao;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private ClubsDao clubsDao;

    @Override
    public String getLogoByName(String name) {
        return clubsDao.getLogo(name);
    }
}
