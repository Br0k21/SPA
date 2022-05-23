package DataAccess.Race;

import DataAccess.SingletonConnexion;
import Model.Race;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RaceDBAccess implements IRaceAccess{
    private String raceName;
    @Override
    public String getRaceName(Integer raceID) {
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.race");
            ResultSet data = statement.executeQuery();

            while(data.next()) {
                if(data.getInt("race_id") == raceID)
                    raceName = data.getString("race_name");
            }
        }catch (SQLException sqlE) {
            System.out.println("Récupération des races impossible");
        }

        return raceName;
    }

    @Override
    public ArrayList<Race> getAllRaces() {
        ArrayList<Race> races = new ArrayList<>();
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.race");
            ResultSet data = statement.executeQuery();

            while(data.next()) {
                Race race = new Race(data.getInt("race_id"), data.getInt("species"), data.getString("race_name"));
                races.add(race);
            }
        }catch (SQLException sqlE) {
            System.out.println("Récupération des races impossible");
        }

        return races;
    }
}
