package DataAccess.Animal;

import Model.Animal;
import Model.Exceptions.AjoutException;
import Model.Exceptions.ConnectionException;
import Model.Exceptions.DeleteException;

import java.util.ArrayList;

public interface IAnimalAccess {
    Animal getAnimal(Integer animalID) throws ConnectionException;
    int getFreeID() throws ConnectionException;
    ArrayList<Integer> getAllID() throws ConnectionException;
    void addNewAnimal(Animal animal) throws AjoutException, ConnectionException;
    void deleteAnimal(Integer animalID) throws DeleteException, ConnectionException;
}
