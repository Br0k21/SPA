package DataAccess.Location;

import Model.Location;

public interface ILocationAccess {
    Location getLocation(String postalCode, String city);
}
