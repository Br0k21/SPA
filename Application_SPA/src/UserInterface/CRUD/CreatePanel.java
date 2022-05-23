package UserInterface.CRUD;

import Controller.Utils;
import Model.Animal;
import SuperClass.Formulaire;
import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;

public class CreatePanel extends JPanel {
    private MainWindow mainW;
    private Formulaire panels;
    private EntryExitButtons buttons;

    public CreatePanel(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new BorderLayout());

        panels = new Formulaire(mainW);
        buttons = new EntryExitButtons() {
            @Override
            public void validate() {
                Animal animal = new Animal();
                System.out.println("Recu");
                /*try {
                    animal = getNewAnimal();
                } catch (IncompletFieldException iE) {
                    JOptionPane.showMessageDialog(null, iE.getMessage(), "Champ incomplet", JOptionPane.ERROR_MESSAGE);
                }*/

            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };
        panels.setAnimalIDField(new Utils().getFreeID());
        panels.setArrivedDateField(new GregorianCalendar());
        this.add(panels, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);
    }



}
