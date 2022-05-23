package Business;

import DataAccess.Animal.*;
import Model.*;

import java.util.ArrayList;

public class AnimalManager {
    public Animal getAnimal(Integer animalID) {
        return new AnimalDBAccess().getAnimal(animalID);
    }
    public Integer getFreeID() { return new AnimalDBAccess().getFreeID();}
    public ArrayList<Integer> getAllID() { return new AnimalDBAccess().getAllID();}
    public void addNewAnimal(Animal animal) {new AnimalDBAccess().addNewAnimal(animal);}
    public void deleteAnimal(Integer animalID) {new AnimalDBAccess().deleteAnimal(animalID);}

}
