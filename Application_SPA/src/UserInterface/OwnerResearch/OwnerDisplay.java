package UserInterface.OwnerResearch;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class OwnerDisplay extends JPanel {
    private JLabel firstName, lastName, phoneNumber, streetNum, streetName, city, animalID, startDate, animalName;

    public OwnerDisplay(Person owner, InCharge inCharge, Animal animal) {
        this.setLayout(new GridLayout(1,9));

        firstName = new JLabel(owner.getFirstName());
        lastName = new JLabel(owner.getLastName());
        phoneNumber = new JLabel(owner.getPhoneNum());
        streetNum = new JLabel(owner.getHouseNum().toString());
        streetName = new JLabel(owner.getStreet());
        city = new JLabel(owner.getCity());
        animalID = new JLabel(animal.getAnimalID().toString());
        animalName = new JLabel(animal.getName());
        setStartDate(inCharge.getStartDate());

        this.add(firstName);
        this.add(lastName);
        this.add(phoneNumber);
        this.add(streetNum);
        this.add(streetName);
        this.add(city);
        this.add(animalID);
        this.add(startDate);
        this.add(animalName);
    }

    public void setStartDate(Date date) {
        // à revoir
        startDate = new JLabel(date.toString());
    }
}
