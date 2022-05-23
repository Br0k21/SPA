package Business;

import DataAccess.Country.CountryDBAcces;
import Model.Exceptions.ConnectionException;

import java.util.ArrayList;

public class CountryManager {
    public void getCountries(ArrayList<String> countries) throws ConnectionException {
        new CountryDBAcces().getCountries(countries);
    }
}
