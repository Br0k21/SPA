package Business;

import DataAccess.Person.PersonDBAccess;
import Model.Person;

import java.util.ArrayList;

public class PersonManager {
    public void getPersons(ArrayList<Person> persons) {
        new PersonDBAccess().getPersons(persons);
    }

    public ArrayList<Person> getPersonsFrom(String country) {
        return new PersonDBAccess().getPersonsFrom(country);
    }


}
