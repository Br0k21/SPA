package DataAccess.Animal;

import DataAccess.SingletonConnexion;
import Model.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalDBAccess implements IAnimalAccess{
    @Override
    public Animal getAnimal(Integer animalID) {
        Animal animal = new Animal();
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.animal");
            ResultSet data = statement.executeQuery();

            while (data.next()) {
                if(data.getInt("animal_id") == animalID){
                    animal.setAnimalID(data.getInt("animal_id"));
                    animal.setArrivedDate(data.getDate("arrived_date"));
                    animal.setName(data.getString("name"));
                }

            }

        } catch (SQLException SQLe) {
            System.out.println("Impossible de récupérer les données de l'animal " + animalID);
        }
        return animal;
    }

    @Override
    public int getFreeID() {
        Animal animal = new Animal();
        int highestID = 0;
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.animal");
            ResultSet data = statement.executeQuery();

            while (data.next()) {
                if(data.getInt("animal_id") > highestID){
                    highestID = data.getInt("animal_id");
                }
            }

        } catch (SQLException SQLe) {
            System.out.println("Impossible de récupérer le nouvgel ID animal ");
        }

        return ++highestID;
    }

    @Override
    public ArrayList<Integer> getAllID() {
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.animal");
            ResultSet data = statement.executeQuery();

            while(data.next())
                ids.add(data.getInt("animal_id"));

        } catch (SQLException SQLe) {
            System.out.println("Impossible de récupérer le nouvgel ID animal ");
        }

        return ids;
    }
}
