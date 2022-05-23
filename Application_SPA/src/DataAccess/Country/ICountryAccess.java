package DataAccess.Country;

import Model.Exceptions.ConnectionException;

import java.util.ArrayList;

public interface ICountryAccess {
    void getCountries(ArrayList<String> countries) throws ConnectionException;
}
