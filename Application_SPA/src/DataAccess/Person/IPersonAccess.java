package DataAccess.Person;

import Model.*;

import java.util.ArrayList;

public interface IPersonAccess {
    void getPersons(ArrayList<Person> persons);
    ArrayList<Person> getPersonsFrom(String country);
}

