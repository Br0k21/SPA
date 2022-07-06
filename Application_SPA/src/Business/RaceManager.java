package Business;

import DataAccess.Race.RaceDBAccess;
import Model.*;
import Model.Exceptions.ConnectionException;

import java.util.ArrayList;

public class RaceManager {
    private RaceDBAccess race = new RaceDBAccess();
    public String getRaceName(Integer raceID) throws ConnectionException { return race.getRaceName(raceID);}
    public ArrayList<Race> getAllRaces() throws ConnectionException { return race.getAllRaces();}
}
