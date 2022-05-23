package DataAccess.Location;

import DataAccess.SingletonConnexion;
import Model.Exceptions.ConnectionException;
import Model.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDBAccess implements ILocationAccess{
    @Override
    public Location getLocation(String postalCode, String city) throws ConnectionException {
        Location loc = new Location();
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.location where postal_code = ? AND city = ?");
            statement.setString(1, postalCode);
            statement.setString(2, city);
            ResultSet data = statement.executeQuery();

            loc.setCity(city);
            loc.setPostalCode(postalCode);
            loc.setCountry(data.getString("country"));

        } catch (SQLException SQLe) {
            System.out.println("Réuperation du pays contenant " + city + " " + postalCode + " impossible");
        }
        return loc;
    }
}
