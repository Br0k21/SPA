package Business;

import DataAccess.Animal.*;
import Model.*;
import Model.Exceptions.AjoutException;
import Model.Exceptions.ConnectionException;
import Model.Exceptions.DeleteException;

import java.util.ArrayList;

public class AnimalManager {
    public Animal getAnimal(Integer animalID) throws ConnectionException {
        return new AnimalDBAccess().getAnimal(animalID);
    }
    public Integer getFreeID() throws ConnectionException { return new AnimalDBAccess().getFreeID();}
    public ArrayList<Integer> getAllID() throws ConnectionException { return new AnimalDBAccess().getAllID();}
    public void addNewAnimal(Animal animal) throws ConnectionException, AjoutException {new AnimalDBAccess().addNewAnimal(animal);}
    public void deleteAnimal(Integer animalID) throws DeleteException, ConnectionException {new AnimalDBAccess().deleteAnimal(animalID);}

}
