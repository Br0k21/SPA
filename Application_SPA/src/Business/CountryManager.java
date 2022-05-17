package Business;

import DataAccess.Country.CountryDBAcces;

import java.util.ArrayList;

public class CountryManager {
    public void getCountries(ArrayList<String> countries) {
        new CountryDBAcces().getCountries(countries);
    }
}
