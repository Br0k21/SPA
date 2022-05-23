package Controller;

import Business.*;
import DataAccess.Animal.AnimalDBAccess;
import Model.*;

import java.util.*;

public class Utils {

    public void getCountries(ArrayList<String> countries) {
        CountryManager country = new CountryManager();
        country.getCountries(countries);
    }

    public ArrayList<Person> getOwnersFrom(String country) {
        ArrayList<Person> owners = new ArrayList<>();
        // Récupère toutes les personnes présentes en BD
        ArrayList<Person> persons = getPersonsFrom(country);
        // Sélectionne uniquement ceux qui ont un lien in_charge
        for(Person person : persons) {
            InCharge inCharge = getInCharge(person.getNationalRegisterNum());
            if(inCharge.getAnimalID() != null) owners.add(person);
        }

        return owners;
    }


    public ArrayList<Person> getPersonsFrom(String country) {
        return new PersonManager().getPersonsFrom( country);
    }

    public InCharge getInCharge(String personID) {
        return new InChargeManager().getInCharge(personID);
    }

    public Animal getAnimal(Integer animalID){
        return new AnimalManager().getAnimal(animalID);
    }

    public Integer getFreeID(){ return new AnimalManager().getFreeID();}

    public ArrayList<Integer> getAllID() {
        return new AnimalManager().getAllID();
    }

    public String getRaceName(Integer raceID) { return new RaceManager().getRaceName(raceID);}

    public ArrayList<Race> getAllRaces() {
        return new RaceManager().getAllRaces();
    }

    public void addAnimal(Animal animal) {
        new AnimalManager().addNewAnimal(animal);
    }

    public void deleteAnimal(Integer animalID) {
        new AnimalManager().deleteAnimal(animalID);
    }
    public void updateAnimal(Animal animal) {
        // Vérif si pas n'importe quoi
        deleteAnimal(animal.getAnimalID());
        addAnimal(animal);
    }
}
