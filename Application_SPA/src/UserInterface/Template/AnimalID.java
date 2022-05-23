package UserInterface.Template;

import Controller.Utils;
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
        this.setLayout(new GridLayout(10,1));

        IDAnimal = new JLabel("ID de l'animal : ");
        animalsID = new Utils().getAllID();
        animals = new JComboBox<>();
        for(Integer id : animalsID)
            animals.addItem(id +" - "+ new Utils().getAnimal(id).getName());
        labelsPanels = new JPanel();
        labelsPanels.setLayout(new GridLayout(1,2));
        labelsPanels.add(IDAnimal);
        labelsPanels.add(animals);

        this.add(labelsPanels);

    }
}
