package UserInterface.Connexion;

import javax.swing.*;
import java.awt.*;

public class ConnexionPanel extends JPanel {
    private ConnexionLabels connexionL;
    private ConnexionButtons connexionB;
    private JFrame mainW;

    public ConnexionPanel(JFrame mainW) {
        this.setLayout(new BorderLayout());

        this.mainW = mainW;

        // Initialisation panels
        connexionL = new ConnexionLabels();
        connexionB = new ConnexionButtons(mainW);

        // Ajout dans le panneau
        this.add(connexionL, BorderLayout.CENTER);
        this.add(connexionB, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
