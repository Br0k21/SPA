package UserInterface.CRUD;

import Controller.Utils;
import Model.Exceptions.ConnectionException;
import UserInterface.MainWindow;
import UserInterface.Template.DisplayAnimalPanel;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;

public class DisplayAnimalRead extends DisplayAnimalPanel {
    private EntryExitButtons buttons;

    public DisplayAnimalRead(MainWindow mainW, Integer animalID, boolean modif) {
        super(mainW, animalID, modif);

        buttons = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                System.out.println("Validé");
            }

            @Override
            public void out() {
                mainW.changeCenterPanel(new AnimalIDRead(mainW));
            }
        };

        this.add(buttons, BorderLayout.SOUTH);

    }

    @Override
    public void setRaceID() {
        try {
            formulaire.setRaceIDField(new Utils().getAnimal(animalID).getRaceID());
        } catch (ConnectionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
