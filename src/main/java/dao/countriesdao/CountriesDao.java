package dao.countriesdao;

import dao.CrudDao;
import models.Country;
import java.util.List;

public interface CountriesDao extends CrudDao<Country, Long> {
    Country findCountryByName(String name);
    List<Country> findALL();
    String getColumnByName(String columnName, String name);
}
