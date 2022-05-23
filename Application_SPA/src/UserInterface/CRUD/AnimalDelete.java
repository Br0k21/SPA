package UserInterface.CRUD;

import Controller.Utils;
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
                new Utils().deleteAnimal(animals.getSelectedIndex() + 1);
                JOptionPane.showMessageDialog(null, "Suppression effectuée", "Confirmer", JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };

        this.add(buttons, BorderLayout.SOUTH);
    }
}
