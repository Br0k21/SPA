package UserInterface.CRUD;

import Controller.Utils;
import Model.Animal;
import Model.Exceptions.AjoutException;
import Model.Exceptions.ConnectionException;
import Model.Exceptions.IncompletFieldException;
import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.GregorianCalendar;

public class CreatePanel extends JPanel {
    private MainWindow mainW;
    private Formulaire panels;
    private EntryExitButtons buttons;
    private long millis=System.currentTimeMillis();

    public CreatePanel(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new BorderLayout());

        panels = new Formulaire();
        panels.setRaceIDJCombobox();
        buttons = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                Animal animal = new Animal();
                try {
                    animal = panels.getNewAnimal();
                    new Utils().addAnimal(animal);
                    JOptionPane.showMessageDialog(null,"Ajout effectué !", "Confirmer", JOptionPane.INFORMATION_MESSAGE);
                    mainW.changeCenterPanel();
                } catch (IncompletFieldException | ConnectionException | AjoutException iE) {
                    JOptionPane.showMessageDialog(null, iE.getMessage(), "Champ incomplet", JOptionPane.ERROR_MESSAGE);
                    panels.changeMandatoryFieldColor();
                }

            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };
        try {
            panels.setAnimalIDField(new Utils().getFreeID());
        } catch (ConnectionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        panels.setArrivedDateField(new java.sql.Date(millis));
        this.add(panels, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);
    }



}
