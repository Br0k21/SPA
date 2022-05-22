package UserInterface.MainPanel;

import Controller.Utils;
import Model.*;
import Model.Exceptions.IncompletFieldException;
import UserInterface.*;
import UserInterface.Template.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AddPanel extends Crud {
    private MainWindow mainW;
    private Crud panels;
    private EntryExitButtons buttons;

    public AddPanel(MainWindow mainW) {
        super(mainW);
        this.setLayout(new BorderLayout());

        panels = new Crud(mainW);
        buttons = new EntryExitButtons() {
            @Override
            public void validate() {
                Animal animal = new Animal();
                System.out.println("Recu");
                try {
                    animal = getNewAnimal();
                } catch (IncompletFieldException iE) {
                    JOptionPane.showMessageDialog(null, iE.getMessage(), "Champ incomplet", JOptionPane.ERROR_MESSAGE);
                }

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
