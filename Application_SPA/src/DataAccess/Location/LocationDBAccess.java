package DataAccess.Location;

import DataAccess.SingletonConnexion;
import Model.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDBAccess implements ILocationAccess{
    @Override
    public Location getLocation(String postalCode, String city){
        Location loc = new Location();
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.location");
            ResultSet data = statement.executeQuery();

            while(data.next()) {
                if (data.getString("city").equals(city)) {
                    loc.setCity(city);
                    loc.setPostalCode(postalCode);
                    loc.setCountry(data.getString("country"));
                    System.out.println("Location concernée : " + city + " " +postalCode);
                    System.out.println("Location concernée : " + data.getString("city")+ " " +data.getString("postal_code") + " " + loc.getCountry());
                    return loc;
                }
            }
        } catch (SQLException SQLe) {
            System.out.println("Réuperation du pays contenant " + city + " " + postalCode + " impossible");
        }
        return loc;
    }
}
