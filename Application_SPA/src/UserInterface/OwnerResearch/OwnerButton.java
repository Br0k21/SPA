package UserInterface.OwnerResearch;

import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

public class OwnerButton extends EntryExitButtons {

    public OwnerButton(MainWindow mainW) {
        super(mainW);
    }

    @Override
    public void valide() {
        // Afficher les propriétaires en question
        System.out.println("Afficher les proprietaires.");
    }

    @Override
    public void exit() {
        mainW.changeCenterPanel();
    }
}
