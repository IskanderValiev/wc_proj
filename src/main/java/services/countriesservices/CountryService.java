package services.countriesservices;

import models.Country;

import java.util.List;
import java.util.Map;

public interface CountryService {
    List<Country> getAllCountries();
    String getColumnByName(String columnName, String name);
}
