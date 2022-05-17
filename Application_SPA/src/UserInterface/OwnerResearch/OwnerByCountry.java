package UserInterface.OwnerResearch;

import Model.*;
import Controller.*;
import UserInterface.BlanckPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OwnerByCountry extends JPanel {
    private JLabel countryL, firstName,lastName,phoneNum,streetNum,streetName,city,animalID,startDate, name;
    private ArrayList<Person> owners;
    private ArrayList<Animal> animals;
    private ArrayList<InCharge> inCharges;

    private Utils utils;

    public OwnerByCountry(String country) {
        utils = new Utils();
        countryL = new JLabel(country);
        firstName = new JLabel("Prénom");
        lastName = new JLabel("Nom de famille");
        phoneNum = new JLabel("numéro de tel");
        streetNum = new JLabel("Numéro");
        streetName = new JLabel("Rue");
        city = new JLabel("Ville");
        animalID = new JLabel("ID animal");
        startDate = new JLabel("Date adoption");
        name = new JLabel("Animal name");

        System.out.println(country);
        owners = utils.getOwnersFrom(country);
        animals = new ArrayList<>();
        inCharges = new ArrayList<>();


        // Ajouter une exception
        if(!owners.isEmpty()) {
            System.out.println("L'array list owner n'est pas vide");

            for(Person owner : owners) System.out.println(owner.getNationalRegisterNum());

            completeArrays();
            this.setLayout(new BorderLayout());
            this.add(countryL, BorderLayout.NORTH);

            this.add(generateLegende(), BorderLayout.NORTH);
            this.add(generateCenterPanel(), BorderLayout.CENTER);

            } else {System.out.println("c vide");}

    }

    private void completeArrays() {
        for(int iOwner =0; iOwner < owners.size(); iOwner++){
            inCharges.add(utils.getInCharge(owners.get(iOwner).getNationalRegisterNum()));
            animals.add(utils.getAnimal(inCharges.get(iOwner).getAnimalID()));
        }
    }

    private JPanel generateCenterPanel() {
        JPanel centerP = new JPanel();
        centerP.setLayout(new GridLayout(owners.size()+5,1));
        for (int iOwner = 0; iOwner < owners.size(); iOwner++)
            centerP.add(new OwnerDisplay(owners.get(iOwner), inCharges.get(iOwner), animals.get(iOwner)));
        return centerP;
    }

    private JPanel generateLegende() {
        JPanel legend = new JPanel();
        legend.setLayout(new GridLayout(1,9));
        legend.add(firstName);
        legend.add(lastName);
        legend.add(phoneNum);
        legend.add(streetNum);
        legend.add(streetName);
        legend.add(city);
        legend.add(animalID);
        legend.add(startDate);
        legend.add(name);

        return legend;
    }
}
