package UserInterface.MainPanel;

import UserInterface.MainWindow;
import UserInterface.Template.Crud;
import UserInterface.Template.EntryExitButtons;

import java.awt.*;
import java.util.ArrayList;

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
                System.out.println("Recu");
                mainW.changeCenterPanel();
            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };
        this.add(panels, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);

    }

}
