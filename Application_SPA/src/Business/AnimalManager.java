package Business;

import DataAccess.Animal.*;
import Model.*;
import Model.Exceptions.AjoutException;
import Model.Exceptions.ConnectionException;
import Model.Exceptions.DeleteException;

import java.util.ArrayList;

public class AnimalManager {
    private AnimalDBAccess an = new AnimalDBAccess();

    public Animal getAnimal(Integer animalID) throws ConnectionException {
        return an.getAnimal(animalID);
    }
    public Integer getFreeID() throws ConnectionException { return an.getFreeID();}
    public ArrayList<Integer> getAllID() throws ConnectionException { return an.getAllID();}
    public void addNewAnimal(Animal animal) throws ConnectionException, AjoutException {an.addNewAnimal(animal);}
    public void deleteAnimal(Integer animalID) throws DeleteException, ConnectionException {an.deleteAnimal(animalID);}

}
