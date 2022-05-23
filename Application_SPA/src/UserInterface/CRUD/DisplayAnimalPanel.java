package UserInterface.CRUD;

import Controller.Utils;
import Model.Animal;
import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayAnimalPanel extends JPanel {
    private MainWindow mainW;
    private JButton back;
    private Formulaire formulaire;
    private Integer animalID;

    public DisplayAnimalPanel(MainWindow mainW, Integer animalID) {
        this.setLayout(new BorderLayout());

        this.mainW = mainW;
        this.animalID = animalID;
        formulaire = new Formulaire();

        fillFormulaire();

        back = new JButton("Retour");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainW.changeCenterPanel();
            }
        });

        this.add(formulaire, BorderLayout.CENTER);
        this.add(back, BorderLayout.SOUTH);

    }

    private void fillFormulaire() {
        Animal animal = new Animal();
        animal = getAnimal();
        // Obligatoire
        formulaire.setAnimalIDField(animal.getAnimalID());
        formulaire.setArrivedDateField(animal.getArrivedDate());
        formulaire.setCellnumField(animal.getCellnum());
        formulaire.setRaceIDField(animal.getRaceID());
        formulaire.setReceptionIDField(animal.getReceptionID());
        formulaire.setVeterinaryIDField(animal.getVeterinaryID());
        // Peuvent etre vide
        formulaire.setBirthDateField(animal.getBirthDate());
        formulaire.setChipPlacementDateField(animal.getChipPlacementDate());
        formulaire.setChipNumField(animal.getChipNum());
        formulaire.setChipLocalisation(animal.getChipLocalisation());
        formulaire.setTatooPlacementDate(animal.getTatooPlacementDate());
        formulaire.setTatooNumField(animal.getTatooNum());
        formulaire.setEuthanasiaDateField(animal.getEuthanasiaDate());
        formulaire.setEuthanasiaReasonField(animal.getEuthanasiaReason());
        formulaire.setNameField(animal.getName());
        formulaire.setWeightField(animal.getWeight());

        formulaire.setAllEnable();
    }

    private Animal getAnimal() {
        return new Utils().getAnimal(animalID);
    }
}
