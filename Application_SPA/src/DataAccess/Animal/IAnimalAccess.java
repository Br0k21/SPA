package DataAccess.Animal;

import Model.Animal;

public interface IAnimalAccess {
    Animal getAnimal(Integer animalID);
    int getFreeID();
}
