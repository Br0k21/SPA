package DataAccess.Race;

import Model.Race;

import java.util.ArrayList;

public interface IRaceAccess {
    String getRaceName(Integer raceID);
    ArrayList<Race> getAllRaces();
}
