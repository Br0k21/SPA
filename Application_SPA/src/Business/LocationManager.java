package Business;

import DataAccess.Location.*;
import Model.Exceptions.ConnectionException;
import Model.Location;

public class LocationManager {
    private LocationDBAccess lo = new LocationDBAccess();

    public Location getCountry(String postalCode, String city) throws ConnectionException {
        return lo.getLocation(postalCode, city);
    }
}
