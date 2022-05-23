package UserInterface.CRUD;

import Controller.Utils;
import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AnimalIDSearch extends JPanel {
    private MainWindow mainW;
    private JPanel labelsPanels;
    private JLabel IDAnimal;
    private ArrayList<Integer> animalsID;
    private JComboBox<String> animals;
    private EntryExitButtons buttons;

    public AnimalIDSearch(MainWindow mainW) {
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

        buttons = new EntryExitButtons() {
            @Override
            public void validate() {
                mainW.changeCenterPanel(new DisplayAnimalPanel(mainW, animals.getSelectedIndex() + 1));
            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };

        this.add(labelsPanels);
        this.add(buttons);
    }
}
