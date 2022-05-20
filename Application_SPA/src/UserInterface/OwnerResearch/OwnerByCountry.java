package UserInterface.OwnerResearch;

import Model.*;
import Controller.*;
import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OwnerByCountry extends JPanel {
    private JLabel countryL, firstName,lastName,phoneNum,streetNum,streetName,city,animalID,startDate, name;
    private ArrayList<Person> owners;
    private ArrayList<Animal> animals;
    private ArrayList<InCharge> inCharges;
    private MainWindow mainW;
    private JButton backButton;

    private Utils utils;

    public OwnerByCountry(String country, MainWindow mainW) {
        this.mainW = mainW;
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

        backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainW.changeCenterPanel(mainW.getPanel(Constant.OWNER));
            }
        });

        owners = utils.getOwnersFrom(country);
        animals = new ArrayList<>();
        inCharges = new ArrayList<>();

        completeArrays();
        this.setLayout(new BorderLayout());
        this.add(countryL, BorderLayout.NORTH);

        this.add(generateLegende(), BorderLayout.NORTH);
        this.add(generateCenterPanel(), BorderLayout.CENTER);
        this.add(backButton, BorderLayout.SOUTH);
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
