package Business;

import DataAccess.Race.RaceDBAccess;
import Model.*;
import Model.Exceptions.ConnectionException;

import java.util.ArrayList;

public class RaceManager {
    public String getRaceName(Integer raceID) throws ConnectionException { return new RaceDBAccess().getRaceName(raceID);}
    public ArrayList<Race> getAllRaces() throws ConnectionException { return new RaceDBAccess().getAllRaces();}
}
