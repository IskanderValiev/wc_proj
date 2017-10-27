package services.countriesservices;

import dao.countriesdao.CountriesDao;
import lombok.AllArgsConstructor;
import models.Country;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountriesDao countriesDao;

    @Override
    public List<Country> getAllCountries() {
        return countriesDao.findALL();
    }

    @Override
    public String getColumnByName(String columnName, String name) {
        return countriesDao.getColumnByName(columnName, name);
    }


}
