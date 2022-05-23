package UserInterface.CRUD;

import Controller.Utils;
import Model.Animal;
import Model.Exceptions.IncompletFieldException;
import UserInterface.MainWindow;
import UserInterface.Template.DisplayAnimalPanel;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;

public class DisplayAnimalUpdate extends DisplayAnimalPanel {
    private EntryExitButtons buttons;

    public DisplayAnimalUpdate(MainWindow mainW, Integer animalID, boolean modif) {
        super(mainW, animalID, modif);

        buttons = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                try {
                    Animal newAnimal = formulaire.getNewAnimal();
                    new Utils().updateAnimal(newAnimal);
                    JOptionPane.showMessageDialog(null, "Ajout effectué", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    mainW.changeCenterPanel();
                } catch(IncompletFieldException ifE) {
                    JOptionPane.showMessageDialog(null, ifE.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void out() {
                mainW.changeCenterPanel(new AnimalUpdate(mainW));
            }
        };

        this.add(buttons, BorderLayout.SOUTH);
    }

    @Override
    public void setRaceID() {
        formulaire.setRaceIDJComboboxUpdate(new Utils().getAnimal(animalID).getRaceID());
    }
}
