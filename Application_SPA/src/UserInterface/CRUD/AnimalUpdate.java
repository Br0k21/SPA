package UserInterface.CRUD;

import Controller.Utils;
import UserInterface.MainWindow;
import UserInterface.Template.AnimalID;
import UserInterface.Template.DisplayAnimalPanel;
import UserInterface.Template.EntryExitButtons;

public class AnimalUpdate extends AnimalID {

    public AnimalUpdate(MainWindow mainW) {
        super(mainW);
        buttons = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                System.out.println(animals.getSelectedIndex() + 1);
                mainW.changeCenterPanel(new DisplayAnimalUpdate(mainW, animals.getSelectedIndex() + 1, true));
            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };
        this.add(buttons);
    }
}
