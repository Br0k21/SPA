package UserInterface.CRUD;

import Controller.Utils;
import Model.Animal;
import Model.Exceptions.IncompletFieldException;
import Model.Race;
import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class Formulaire extends JPanel {

    private JLabel animalID, cellnum, raceID, arrivedDate, birthDate, chipPlacementDate, tatooPlacementDate, euthanasiaDate, chipNum, chipLocalisation, tatooNum, euthanasiaReason, name, receptionID, veterinaryID, weight;
    private ButtonGroup sex, hairOrSkin;
    private JRadioButton male, female, hair, skin;
    private JCheckBox toIsolateCB, sterilisedCB;
    private String toIsolate, sterilised;
    private JTextField animalIDField, cellnumField, arrivedDateField, birthDateField, chipPlacementDateField, tatooPlacementDateField, euthanasiaDateField, chipNumField, chipLocalisationField, tatooNumField, euthanasiaReasonField, nameField, receptionIDField, veterinaryIDField, sexField, weightField;
    private CheckBoxListener CBlistenner;
    private JComboBox<String> raceIDField;

    public Formulaire() {
        this.setLayout(new GridLayout(19, 2, 5, 5));
        // init
        // labels
        animalID = new JLabel("Animal ID :");
        cellnum = new JLabel("Numéro de cellule :");
        raceID = new JLabel("Race :");
        arrivedDate = new JLabel("Date d'arrivée :");
        birthDate = new JLabel("Date de naissance :");
        chipPlacementDate = new JLabel("Date de placement de la puce :");
        tatooPlacementDate = new JLabel("Date de placement de la puce :");
        euthanasiaDate = new JLabel("Date d'euthanasie :");
        chipNum = new JLabel("Numéro de puce :");
        chipLocalisation = new JLabel("Position de la puce :");
        tatooNum = new JLabel("Numéro de tatouage :");
        euthanasiaReason = new JLabel("Raison de l'euthanasie :");
        name = new JLabel("Nom :");
        receptionID = new JLabel("Matricule réceptionniste :");
        veterinaryID = new JLabel("Matricule vétérinaire :");
        weight = new JLabel("Poids :");

        // Radio button
        male = new JRadioButton("Mâle", true);
        female = new JRadioButton("Femelle", false);

        hair = new JRadioButton("Pelage", true);
        skin = new JRadioButton("Peau", false);

        // CheckBox
        toIsolateCB = new JCheckBox("A isoler");

        sterilisedCB = new JCheckBox("Stérilisé");

        // JTextField

        animalIDField = new JTextField(); // Ajouter automtiquement un nouveau matricule libre
        animalIDField.setEnabled(false);
        cellnumField = new JTextField();
        raceIDField = new JComboBox<>();
        arrivedDateField = new JTextField();
        arrivedDateField.setEnabled(false);
        birthDateField = new JTextField();
        chipPlacementDateField = new JTextField();
        tatooPlacementDateField = new JTextField();
        euthanasiaDateField = new JTextField();
        chipNumField = new JTextField();
        chipLocalisationField = new JTextField();
        tatooNumField = new JTextField();
        euthanasiaReasonField = new JTextField();
        nameField = new JTextField();
        receptionIDField = new JTextField();
        veterinaryIDField = new JTextField();
        weightField = new JTextField();

        // Listener
        CBlistenner = new CheckBoxListener();

        // Button

        // Ajout des listener
        toIsolateCB.addItemListener(CBlistenner);
        sterilisedCB.addItemListener(CBlistenner);

        // Lier les bouton au groupe
        sex = new ButtonGroup();
        sex.add(male);
        sex.add(female);

        hairOrSkin = new ButtonGroup();
        hairOrSkin.add(hair);
        hairOrSkin.add(skin);

        // Ajout des éléments
        this.add(animalID);
        this.add(animalIDField);

        this.add(name);
        this.add(nameField);

        this.add(cellnum);
        this.add(cellnumField);

        this.add(raceID);
        this.add(raceIDField);

        this.add(weight);
        this.add(weightField);

        this.add(arrivedDate);
        this.add(arrivedDateField);

        this.add(birthDate);
        this.add(birthDateField);

        this.add(toIsolateCB);

        this.add(sterilisedCB);

        this.add(male);
        this.add(female);

        this.add(hair);
        this.add(skin);

        this.add(chipNum);
        this.add(chipNumField);

        this.add(chipLocalisation);
        this.add(chipLocalisationField);

        this.add(chipPlacementDate);
        this.add(chipPlacementDateField);

        this.add(tatooNum);
        this.add(tatooNumField);

        this.add(tatooPlacementDate);
        this.add(tatooPlacementDateField);

        this.add(euthanasiaReason);
        this.add(euthanasiaReasonField);

        this.add(euthanasiaDate);
        this.add(euthanasiaDateField);

        this.add(receptionID);
        this.add(receptionIDField);

        this.add(veterinaryID);
        this.add(veterinaryIDField);

    }

    public JTextField getAnimalIDField() {
        return animalIDField;
    }

    public void setAllEnable(boolean b) {
        nameField.setEnabled(b);

        raceIDField.setEnabled(b);

        weightField.setEnabled(b);

        cellnumField.setEnabled(b);

        arrivedDateField.setEnabled(b);

        birthDateField.setEnabled(b);

        toIsolateCB.setEnabled(b);

        sterilisedCB.setEnabled(b);

        female.setEnabled(b);
        male.setEnabled(b);

        hair.setEnabled(b);
        skin.setEnabled(b);

        chipNumField.setEnabled(b);

        chipLocalisationField.setEnabled(b);

        chipPlacementDateField.setEnabled(b);

        tatooNumField.setEnabled(b);

        tatooPlacementDateField.setEnabled(b);

        euthanasiaReasonField.setEnabled(b);

        euthanasiaDateField.setEnabled(b);

        receptionIDField.setEnabled(b);

        veterinaryIDField.setEnabled(b);
    }

    public void setAllEnable() {
        setAllEnable(false);
    }

    public Animal getNewAnimal() throws IncompletFieldException{
        Animal animal = new Animal();

        // Champ obligatoire
        if(mandatoryFieldMissing())
            throw new IncompletFieldException();
        else {
            animal.setAnimalID(parseInt(animalIDField.getText()));
            animal.setRaceID(raceIDField.getSelectedIndex() + 1);
            System.out.println(raceIDField.getSelectedIndex() + 1);
            animal.setCellnum(parseInt(cellnumField.getText()));
            animal.setArrivedDate(Date.valueOf(arrivedDateField.getText()));
            animal.setReceptionID(receptionIDField.getText());
            animal.setVeterinaryID(veterinaryIDField.getText());
            animal.setName(nameField.getText());
        }
        animal.setToIsolate(toIsolateCB.isSelected());
        animal.setSterilised(sterilisedCB.isSelected());
        animal.setSex(male.isSelected());
        animal.setHairOrSkin(hair.isSelected());

        // Champ non obligatoire
        animal.setWeight(weightField.getText().equals("") ? 0 : parseDouble(weightField.getText()));
        animal.setBirthDate(birthDateField.getText().equals("") ? null : Date.valueOf(birthDateField.getText()));
        animal.setChipNum(chipNumField.getText().equals("") ? null : chipNumField.getText());
        animal.setChipLocalisation(chipLocalisationField.getText().equals("")? null : chipLocalisationField.getText());
        animal.setChipPlacementDate(chipPlacementDateField.getText().equals("") ? null : Date.valueOf(chipPlacementDateField.getText()));
        animal.setTatooNum(tatooNumField.getText().equals("") ? null : tatooNumField.getText());
        animal.setTatooPlacementDate(tatooPlacementDateField.getText().equals("") ?  null : Date.valueOf(tatooPlacementDateField.getText()));
        animal.setEuthanasiaReason(euthanasiaReasonField.getText().equals("") ? null : euthanasiaReasonField.getText());
        animal.setEuthanasiaDate(euthanasiaDateField.getText().equals("") ? null : Date.valueOf(euthanasiaDateField.getText()));

        return animal;
    }

    private class CheckBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            toIsolate = toIsolateCB.isSelected() ? "true" : "false";
            sterilised = sterilisedCB.isSelected()? "true" : "false";
        }
    }

    private boolean mandatoryFieldMissing() {
        if(animalIDField.getText().equals(""))
            return true;
        if(raceIDField.getSelectedItem().toString().equals(""))
            return true;
        if(arrivedDateField.getText().equals(""))
            return true;
        if(receptionIDField.getText().equals(""))
            return true;
        if(veterinaryIDField.getText().equals(""))
            return true;

        return false;
    }
    public void setAnimalIDField(Integer animalID) {
        this.animalIDField.setText(animalID.toString());
    }

    public void setArrivedDateField(Date date) {
        this.arrivedDateField.setText(date.toString());
    }

    public void setCellnumField(Integer cellnumField) {
        this.cellnumField.setText(cellnumField == null ? "" : cellnumField.toString());
    }

    public void setRaceIDField(Integer raceIDField) {
        this.raceIDField.addItem(raceIDField == null ? "" : raceIDField.toString() + " - " + new Utils().getRaceName(raceIDField));
    }

    public void setRaceIDJCombobox() {
        ArrayList<Race> races = new Utils().getAllRaces();
        for(Race race : races)
            raceIDField.addItem(race.getRaceID()+" - "+race.getRaceName());
    }
    public void setRaceIDJComboboxUpdate(Integer raceID) {
        ArrayList<Race> races = new Utils().getAllRaces();
        for(Race race : races){
            raceIDField.addItem(race.getRaceID()+" - "+race.getRaceName());
            if(race.getRaceID().equals(raceID)) {raceIDField.setSelectedIndex(raceID-1);}
        }
    }

    public void setBirthDateField(java.sql.Date birthDateField) {
        this.birthDateField.setText(birthDateField == null ? "" : birthDateField.toString());
    }

    public void setChipPlacementDateField(java.sql.Date chipPlacementDateField) {
        this.chipPlacementDateField.setText(chipPlacementDateField == null ? "" : chipPlacementDateField.toString());
    }

    public void setChipNumField(String chipNumField) {
        this.chipNumField.setText(chipNumField == null ? "" : chipNumField);
    }

    public void setChipLocalisation(String chipLocalisation) {
        this.chipLocalisationField.setText(chipLocalisation == null ? "" : chipLocalisation);
    }

    public void setTatooPlacementDate(java.sql.Date tatooPlacementDate) {
        this.tatooPlacementDateField.setText(tatooPlacementDate == null ? "" : tatooPlacementDate.toString());
    }

    public void setTatooNumField(String tatooNumField) {
        this.tatooNumField.setText(tatooNumField == null ? "" : tatooNumField);
    }

    public void setEuthanasiaDateField(java.sql.Date euthanasiaDateField) {
        this.euthanasiaDateField.setText(euthanasiaDateField == null ? "" :euthanasiaDateField.toString());
    }

    public void setEuthanasiaReasonField(String euthanasiaReasonField) {
        this.euthanasiaReasonField.setText(euthanasiaReasonField == null ? "" : euthanasiaReasonField);
    }

    public void setNameField(String nameField) {
        this.nameField.setText(nameField);
    }

    public void setWeightField(Double weightField) {
        this.weightField.setText(weightField == null ? "" : weightField.toString());
    }

    public void setVeterinaryIDField(String veterinaryIDField) {
        this.veterinaryIDField.setText(veterinaryIDField);
    }

    public void setReceptionIDField(String receptionIDField) {
        this.receptionIDField.setText(receptionIDField);
    }

    public void setSexFields(Boolean b) {
        this.male.setSelected(b);
        this.female.setSelected(!b);
    }

    public void setHairOrSkin(Boolean b) {
        this.hair.setSelected(b);
        this.skin.setSelected(!b);
    }

    public void setToIsolateCB(Boolean b) {
        this.toIsolateCB.setSelected(b);
    }

    public void setSterilisedCB(Boolean b) {
        this.sterilisedCB.setSelected(b);
    }
}
