package UserInterface.Template;

import Controller.Utils;
import Model.Animal;
import Model.Exceptions.ConnectionException;
import UserInterface.CRUD.Formulaire;
import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class DisplayAnimalPanel extends JPanel {
    protected MainWindow mainW;
    protected Formulaire formulaire;
    protected Integer animalID;
    protected boolean modif;

    public DisplayAnimalPanel(MainWindow mainW, Integer animalID, boolean modif) {
        this.setLayout(new BorderLayout());
        this.modif = modif;
        this.mainW = mainW;
        this.animalID = animalID;
        formulaire = new Formulaire();

        fillFormulaire(modif);

        this.add(formulaire, BorderLayout.CENTER);
    }

    protected void fillFormulaire(boolean modif) {
        Animal animal = new Animal();
        animal = getAnimal();
        // Obligatoire
        formulaire.setAnimalIDField(animal.getAnimalID());
        formulaire.setArrivedDateField(animal.getArrivedDate());
        formulaire.setCellnumField(animal.getCellNum());
        setRaceID();
        formulaire.setReceptionIDField(animal.getReceptionID());
        formulaire.setVeterinaryIDField(animal.getVeterinaryID());
        formulaire.setSexFields(animal.getSex());
        formulaire.setToIsolateCB(animal.getToIsolate());

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
        formulaire.setSterilisedCB(animal.getSterilised());

        formulaire.setAllEnable(modif);
    }

    public Animal getAnimal() {
        Animal animal = new Animal();
        try {
            animal = new Utils().getAnimal(animalID);
        } catch (ConnectionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return animal;
    }
    public abstract void setRaceID();
}
