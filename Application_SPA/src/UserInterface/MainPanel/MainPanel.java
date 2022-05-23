package UserInterface.MainPanel;

import UserInterface.CRUD.CRUDPanel;
import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private MainWindow mainW;

    private CRUDPanel crudP;
    private JLabel welcomeMsg;

    public MainPanel(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new GridLayout(8,1));

        // Init panels
        crudP = new CRUDPanel(mainW);
        welcomeMsg = new JLabel("Bonjour XXX.");

        // Ajout panels
        this.add(welcomeMsg);
        this.add(crudP);
    }
}
