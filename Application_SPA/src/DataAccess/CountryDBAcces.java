package DataAccess;

import java.sql.*;
import java.util.ArrayList;

public class CountryDBAcces implements ICountryAccess{
    @Override
    public void getAllCountries(ArrayList<String > countries) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/spa", "root", "root");
            int cpt = 0;

            PreparedStatement statement = connection.prepareStatement("select * from spa.country");
            ResultSet data = statement.executeQuery();
            while(data.next()) {
                String tmp = data.getString("country_name");

                countries.add(data.getString("country_name"));
            }
        } catch (SQLException SQLe) {
            System.out.println("Connexion échouée");
        }
        /*try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/spa", "root", "root");

            PreparedStatement statement = connection.prepareStatement("select * from spa.country");
            ResultSet data = statement.executeQuery();
            while(data.next()) {
                String tmp = data.getString("country_name");
                System.out.println(tmp);
            }
        } catch (SQLException SQLe) {
            System.out.println("Connexion échouée");
        }*/
    }
}
