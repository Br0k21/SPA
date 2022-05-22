package Controller;

import Business.*;
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
}
