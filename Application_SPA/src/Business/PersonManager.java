package Business;

import DataAccess.Person.PersonDBAccess;
import Model.Exceptions.ConnectionException;
import Model.Person;

import java.util.ArrayList;

public class PersonManager {
    public void getPersons(ArrayList<Person> persons) throws ConnectionException {
        new PersonDBAccess().getPersons(persons);
    }

    public ArrayList<Person> getPersonsFrom(String country) throws ConnectionException {
        return new PersonDBAccess().getPersonsFrom(country);
    }


}
