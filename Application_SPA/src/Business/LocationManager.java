package Business;

import DataAccess.Location.*;
import Model.Exceptions.ConnectionException;
import Model.Location;

public class LocationManager {
    public Location getCountry(String postalCode, String city) throws ConnectionException {
        return new LocationDBAccess().getLocation(postalCode, city);
    }
}
