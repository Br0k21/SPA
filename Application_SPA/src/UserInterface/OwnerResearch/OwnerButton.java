package UserInterface.OwnerResearch;

import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

public class OwnerButton extends EntryExitButtons {
    private OwnerSearchPanel parent;

    public OwnerButton(OwnerSearchPanel parent) {
        this.parent = parent;
    }

    @Override
    public void validate() {
        parent.setCountry();
        parent.getMainW().changeCenterPanel(new OwnerByCountry(parent.getCountry()));
    }

    @Override
    public void out() {
        parent.getMainW().changeCenterPanel();
    }
}
