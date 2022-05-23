package UserInterface.CRUD;

import UserInterface.MainWindow;
import UserInterface.Template.DisplayAnimalPanel;
import UserInterface.Template.AnimalID;
import UserInterface.Template.EntryExitButtons;

public class AnimalIDRead extends AnimalID {

    public AnimalIDRead(MainWindow mainW) {
        super(mainW);

        buttons = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                mainW.changeCenterPanel(new DisplayAnimalRead(mainW, animals.getSelectedIndex() + 1, false));
            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };

        this.add(buttons);
    }

    public Integer getAnimalID() {
        return animals.getSelectedIndex()+1;
    }
}
