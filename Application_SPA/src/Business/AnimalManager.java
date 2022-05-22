package Business;

import DataAccess.Animal.AnimalDBAccess;
import DataAccess.InCharge.InChargeDBAccess;
import Model.Animal;
import Model.InCharge;

public class AnimalManager {
    public Animal getAnimal(Integer animalID) {
        return new AnimalDBAccess().getAnimal(animalID);
    }
    public Integer getFreeID() { return new AnimalDBAccess().getFreeID();}
}
