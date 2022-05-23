package DataAccess.Person;

import Model.*;
import Model.Exceptions.ConnectionException;

import java.util.ArrayList;

public interface IPersonAccess {
    void getPersons(ArrayList<Person> persons) throws ConnectionException;
    ArrayList<Person> getPersonsFrom(String country) throws ConnectionException;
}

