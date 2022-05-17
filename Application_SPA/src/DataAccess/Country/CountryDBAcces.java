package DataAccess.Country;

import DataAccess.SingletonConnexion;

import java.sql.*;
import java.util.ArrayList;

public class CountryDBAcces implements ICountryAccess{
    @Override
    public void getCountries(ArrayList<String > countries) {
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.country");
            ResultSet data = statement.executeQuery();
            while(data.next()) {
                String tmp = data.getString("country_name");

                countries.add(data.getString("country_name"));
            }
        } catch (SQLException SQLe) {
            System.out.println("Récupération des pays impossible");
        }
    }
}
