package Business;

import DataAccess.Race.RaceDBAccess;
import Model.*;

import java.util.ArrayList;

public class RaceManager {
    public String getRaceName(Integer raceID) { return new RaceDBAccess().getRaceName(raceID);}
    public ArrayList<Race> getAllRaces() { return new RaceDBAccess().getAllRaces();}
}
