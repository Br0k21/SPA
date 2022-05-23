package DataAccess.Location;

import Model.Exceptions.ConnectionException;
import Model.Location;

public interface ILocationAccess {
    Location getLocation(String postalCode, String city) throws ConnectionException;
}
