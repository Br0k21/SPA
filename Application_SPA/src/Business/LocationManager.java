package Business;

import DataAccess.Location.*;
import Model.Location;

public class LocationManager {
    public Location getCountry(String postalCode, String city) {
        return new LocationDBAccess().getLocation(postalCode, city);
    }
}
