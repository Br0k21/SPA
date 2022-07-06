package UserInterface.CRUD;

import Controller.Utils;
import Model.Exceptions.ConnectionException;
import UserInterface.MainWindow;
import UserInterface.Template.DisplayAnimalPanel;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayAnimalRead extends DisplayAnimalPanel {
    private JButton exit;
    private ButtonListenner listenner;

    public DisplayAnimalRead(MainWindow mainW, Integer animalID, boolean modif) {
        super(mainW, animalID, modif);

        listenner = new ButtonListenner();

        exit = new JButton("Retour");
        //exit.setLayout(new FlowLayout());
        exit.addActionListener(listenner);

        this.add(exit, BorderLayout.SOUTH);

    }

    @Override
    public void setRaceID() {
        try {
            formulaire.setRaceIDField(new Utils().getAnimal(animalID).getRaceID());
        } catch (ConnectionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class ButtonListenner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == exit)
                mainW.changeCenterPanel();
        }
    }
}
