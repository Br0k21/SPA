package Business;

import DataAccess.Person.PersonDBAccess;
import Model.Exceptions.ConnectionException;
import Model.Person;

import java.sql.SQLException;
import java.util.ArrayList;

public class PersonManager {
    private PersonDBAccess pers = new PersonDBAccess();
    public void getPersons(ArrayList<Person> persons) throws ConnectionException {
        pers.getPersons(persons);
    }

    public ArrayList<Person> getPersonsFrom(String country) throws ConnectionException {
        return pers.getPersonsFrom(country);
    }

    public String getNom(String id) throws SQLException {
        return pers.getNom(id);
    }


}
