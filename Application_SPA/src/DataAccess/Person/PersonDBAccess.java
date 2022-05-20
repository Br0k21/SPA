package DataAccess.Person;

import Business.*;
import DataAccess.SingletonConnexion;
import Model.Person;

import java.sql.*;
import java.util.ArrayList;

public class PersonDBAccess implements IPersonAccess{
    @Override
    public void getPersons(ArrayList<Person> persons) {
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.person");
            ResultSet data = statement.executeQuery();

            while(data.next()) {
                persons.add(implementPerson(data));
            }
        } catch (SQLException SQLe) {
            System.out.println("Connexion échouée");
        }
    }

    @Override
    public ArrayList<Person> getPersonsFrom(String country) {
        ArrayList<Person> persons = new ArrayList<>();
        try {
            Connection connection = SingletonConnexion.getInstance();
            LocationManager loc = new LocationManager();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM spa.person p, spa.location l where p.pers_city = l.city AND p.pers_postal_code = l.postal_code");
            ResultSet data = statement.executeQuery();

            while(data.next()) {
                if(data.getString("country").equals(country))
                    persons.add(implementPerson(data));
            }
        } catch (SQLException SQLe) {
            System.out.println("Récupération des personnes venant de " + country + " impossible");
        }

        return persons;
    }

    private Person implementPerson(ResultSet data) {
        Person pers = new Person();
        try {pers.setNationalRegisterNum(data.getString("national_register_num"));
            pers.setPhoneNum(data.getString("phone_num"));
            pers.setLastName(data.getString("last_name"));
            pers.setFirstName(data.getString("first_name"));
            pers.seteMail(data.getString("e_mail"));
            pers.setHouseNum(data.getString("street_number"));
            pers.setStreet(data.getString("street_name"));
            pers.setPostalCode(data.getString("pers_postal_code"));
            pers.setCity(data.getString("pers_city"));
        }catch(SQLException SQLe) {
            System.out.println("Probleme lors de la récupération de la personne" );
        }

        return pers;
    }
}
