package UserInterface.TreatmentForm;

import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

public class TreatmentButtons extends EntryExitButtons {
    private MainWindow mainW;

    public TreatmentButtons(MainWindow mainW) {
        this.mainW = mainW;
    }

    @Override
    public void validate() {

    }

    @Override
    public void out() {
        mainW.changeCenterPanel();
    }
}
