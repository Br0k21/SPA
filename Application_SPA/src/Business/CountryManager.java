package Business;

import DataAccess.Country.CountryDBAcces;
import Model.Exceptions.ConnectionException;

import java.util.ArrayList;

public class CountryManager {
    private CountryDBAcces co = new CountryDBAcces();

    public void getCountries(ArrayList<String> countries) throws ConnectionException {
        co.getCountries(countries);
    }
}
