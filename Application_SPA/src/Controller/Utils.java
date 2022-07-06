package Controller;

import Business.*;
import DataAccess.Animal.AnimalDBAccess;
import Model.*;
import Model.Exceptions.AjoutException;
import Model.Exceptions.ConnectionException;
import Model.Exceptions.DeleteException;

import java.sql.SQLException;
import java.util.*;

public class Utils {

    public void getCountries(ArrayList<String> countries) throws ConnectionException {
        CountryManager country = new CountryManager();
        country.getCountries(countries);
    }

    public ArrayList<Person> getOwnersFrom(String country) throws ConnectionException {
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


    public ArrayList<Person> getPersonsFrom(String country) throws ConnectionException {
        return new PersonManager().getPersonsFrom( country);
    }

    public InCharge getInCharge(String personID) throws ConnectionException {
        return new InChargeManager().getInCharge(personID);
    }

    public Animal getAnimal(Integer animalID) throws ConnectionException {
        return new AnimalManager().getAnimal(animalID);
    }

    public Integer getFreeID() throws ConnectionException { return new AnimalManager().getFreeID();}

    public ArrayList<Integer> getAllID() throws ConnectionException {
        return new AnimalManager().getAllID();
    }

    public String getRaceName(Integer raceID) throws ConnectionException { return new RaceManager().getRaceName(raceID);}

    public ArrayList<Race> getAllRaces() throws ConnectionException {
        return new RaceManager().getAllRaces();
    }

    public void addAnimal(Animal animal) throws ConnectionException, AjoutException {
        new AnimalManager().addNewAnimal(animal);
    }

    public void deleteAnimal(Integer animalID) throws DeleteException, ConnectionException {
        new AnimalManager().deleteAnimal(animalID);
    }
    public void updateAnimal(Animal animal) throws DeleteException, ConnectionException, AjoutException {
        // Vérif si pas n'importe quoi
        deleteAnimal(animal.getAnimalID());
        addAnimal(animal);
    }

    public boolean verifyIDandPass(String id, int pass) throws ConnectionException {
        return new LoginManager().verifyIDandPass(id, pass);
    }

    public String getNom(String id) throws SQLException{
        return new PersonManager().getNom(id);
    }
}
