package UserInterface.CRUD;

import Controller.Utils;
import Model.Exceptions.ConnectionException;
import Model.Exceptions.DeleteException;
import UserInterface.MainWindow;
import UserInterface.Template.AnimalID;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;

public class AnimalDelete extends AnimalID {
    private EntryExitButtons buttons;

    public AnimalDelete(MainWindow mainW) {
        super(mainW);

        buttons = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                try {
                    new Utils().deleteAnimal(getAnimalID());
                    JOptionPane.showMessageDialog(null, "Suppression effectuée", "Confirmer", JOptionPane.INFORMATION_MESSAGE);
                    mainW.changeCenterPanel();
                } catch (DeleteException | ConnectionException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(),"Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };

        this.add(buttons);
    }
}
