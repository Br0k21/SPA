package UserInterface.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private CRUDPanel crudP;
    private JLabel welcomeMsg;

    public MainPanel() {
        this.setLayout(new GridLayout(8,1));

        // Init panels
        crudP = new CRUDPanel();
        welcomeMsg = new JLabel("Bonjour XXX.");

        // Ajout panels
        this.add(welcomeMsg);
        this.add(crudP);
    }
}
