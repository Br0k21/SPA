package UserInterface.Connexion;

import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;

public class ConnexionPanel extends JPanel {
    private JPanel connexionL;
    private EntryExitButtons connexionB;
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
