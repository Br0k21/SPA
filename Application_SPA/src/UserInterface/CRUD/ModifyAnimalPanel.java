package UserInterface.CRUD;

import Controller.Utils;
import Model.Animal;
import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModifyAnimalPanel extends JPanel {
    private MainWindow mainW;

    private Formulaire formulaire;
    private EntryExitButtons buttons;

    public ModifyAnimalPanel(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new BorderLayout());

        formulaire = new Formulaire();
        buttons = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                System.out.println("A voir");
            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };

        this.add(formulaire, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);

    }
}
