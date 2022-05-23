package DataAccess.Animal;

import Model.Animal;

import java.util.ArrayList;

public interface IAnimalAccess {
    Animal getAnimal(Integer animalID);
    int getFreeID();
    ArrayList<Integer> getAllID();
}
