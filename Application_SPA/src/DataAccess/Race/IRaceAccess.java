package DataAccess.Race;

import Model.Exceptions.ConnectionException;
import Model.Race;

import java.util.ArrayList;

public interface IRaceAccess {
    String getRaceName(Integer raceID) throws ConnectionException;
    ArrayList<Race> getAllRaces() throws ConnectionException;
}
