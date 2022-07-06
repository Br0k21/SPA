package UserInterface.Template;

import Controller.Utils;
import Model.Exceptions.ConnectionException;
import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class AnimalID extends JPanel {
    protected MainWindow mainW;
    protected JPanel labelsPanels;
    protected JLabel IDAnimal;
    protected ArrayList<Integer> animalsID;
    protected JComboBox<String> animals;
    protected EntryExitButtons buttons;

    public AnimalID(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new GridLayout(15,1));

        IDAnimal = new JLabel("ID de l'animal : ");
        IDAnimal.setHorizontalAlignment(SwingConstants.RIGHT);
        try {
            animalsID = new Utils().getAllID();
            animals = new JComboBox<>();
            for(Integer id : animalsID)
                animals.addItem(id +" - "+ new Utils().getAnimal(id).getName());
            labelsPanels = new JPanel();
            labelsPanels.setLayout(new FlowLayout());
            labelsPanels.add(IDAnimal);
            labelsPanels.add(animals);
            //labelsPanels.add(buttons);

            this.add(labelsPanels);
        } catch (ConnectionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }


    }
    public Integer getAnimalID() {
        return animalsID.get(animals.getSelectedIndex());
    }
}
