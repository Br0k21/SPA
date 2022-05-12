package UserInterface.Connexion;

import javax.swing.*;
import java.awt.*;

public class ConnexionPanel extends JPanel {
    private ConnexionLabels connexionL;
    private ConnexionButtons connexionB;
    private ConnexionWindow coW;

    public ConnexionPanel(ConnexionWindow coW) {
        this.setLayout(new BorderLayout());

        this.coW = coW;

        // Initialisation panels
        connexionL = new ConnexionLabels();
        connexionB = new ConnexionButtons(coW);

        // Ajout dans le panneau
        this.add(connexionL, BorderLayout.CENTER);
        this.add(connexionB, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
