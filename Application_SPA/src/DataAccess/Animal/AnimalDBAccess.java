package DataAccess.Animal;

import DataAccess.SingletonConnexion;
import Model.Animal;
import Model.Exceptions.AjoutException;
import Model.Exceptions.ConnectionException;
import Model.Exceptions.DeleteException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalDBAccess implements IAnimalAccess{
    @Override
    public Animal getAnimal(Integer animalID) throws ConnectionException {
        Animal animal = new Animal();
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.animal where animal_id = ?");
            statement.setInt(1, animalID);
            ResultSet data = statement.executeQuery();

            while (data.next()) {
                // Obligatoire
                animal.setAnimalID(data.getInt("animal_id"));
                animal.setArrivedDate(data.getDate("arrived_date"));
                animal.setName(data.getString("name"));
                animal.setCellnum(data.getInt("cell_num"));
                animal.setRaceID(data.getInt("race_id"));
                animal.setReceptionID(data.getString("reception"));
                animal.setVeterinaryID(data.getString("veterinary"));
                animal.setSex(data.getBoolean("sex"));
                animal.setSterilised(data.getBoolean("sterilised"));
                animal.setToIsolate(data.getBoolean("to_isolate"));
                animal.setHairOrSkin(data.getBoolean("hair_or_skin"));
                // Peuvent etre vide
                animal.setBirthDate(data.getDate("birth_date"));
                animal.setChipPlacementDate(data.getDate("chip_placement_date"));
                animal.setChipNum(data.getString("chip_num"));
                animal.setChipLocalisation(data.getString("chip_location"));
                animal.setTatooPlacementDate(data.getDate("tatoo_placement_date"));
                animal.setTatooNum(data.getString("tatoo_num"));
                animal.setEuthanasiaDate(data.getDate("euthanasia_date"));
                animal.setEuthanasiaReason(data.getString("euthanasia_reason"));
                animal.setWeight(data.getDouble("weight"));
            }

        } catch (SQLException SQLe) {
            System.out.println("Impossible de récupérer les données de l'animal " + animalID);
        }
        return animal;
    }

    @Override
    public int getFreeID() throws ConnectionException {
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
    public ArrayList<Integer> getAllID() throws ConnectionException {
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

    @Override
    public void addNewAnimal(Animal animal) throws ConnectionException, AjoutException {
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("insert into spa.animal values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            statement.setInt(1,animal.getAnimalID());
            statement.setDate(2, animal.getArrivedDate());
            statement.setDate(3,animal.getBirthDate());
            statement.setString(4, animal.getChipNum());
            statement.setString(5, animal.getChipLocalisation());
            statement.setString(6, animal.getTatooNum());
            statement.setDate(7, animal.getTatooPlacementDate());
            statement.setBoolean(8, animal.getSex());
            statement.setBoolean(9, animal.getSterilised());
            statement.setBoolean(10, animal.getHairOrSkin());
            statement.setBoolean(11,animal.getToIsolate());
            statement.setDouble(12, animal.getWeight());
            statement.setDate(13, animal.getEuthanasiaDate());
            statement.setString(14, animal.getEuthanasiaReason());
            statement.setInt(15, animal.getCellNum());
            statement.setInt(16, animal.getRaceID());
            statement.setString(17, animal.getReceptionID());
            statement.setString(18, animal.getVeterinaryID());
            statement.setString(19, animal.getName());
            statement.setDate(20, animal.getChipPlacementDate());
            statement.executeUpdate();

        } catch (SQLException SQLe) {
            throw new AjoutException();
        }
    }

    public void deleteAnimal(Integer animalID) throws DeleteException, ConnectionException {
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("delete from spa.animal where animal_id = ?");
            statement.setInt(1, animalID);
            statement.executeUpdate();

        } catch (SQLException SQLe) {
            throw new DeleteException(getAnimal(animalID).getName());
        }
    }
}
