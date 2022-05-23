package UserInterface.OwnerResearch;

import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;

public class OwnerSearchPanel extends JPanel {
    private MainWindow mainW;
    private OwnerLabels search;
    private EntryExitButtons button;
    private String country;

    public OwnerSearchPanel(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new GridLayout(8,1));

        search = new OwnerLabels();
        button = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                setCountry();
                mainW.changeCenterPanel(new OwnerByCountry(country, mainW));
            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };

        this.add(search);
        this.add(button);
    }

    public void setCountry() {
        this.country = search.getCountry();
    }

    public MainWindow getMainW() {
        return mainW;
    }

    public String getCountry() {
        return country;
    }
}
