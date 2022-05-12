package UserInterface.OwnerResearch;

import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;

public class OwnerSearchPanel extends JPanel {
    private MainWindow mainW;
    private SearchOwner search;
    private OwnerButton button;

    public OwnerSearchPanel(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new GridLayout(8,1));

        search = new SearchOwner();
        button = new OwnerButton(this.mainW);

        this.add(search);
        this.add(button);
    }

    public void ownerResearch() {
        System.out.println("Pays choisis : "+search.getCountry());
    }
}
