package UserInterface.Connexion;

import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;

public class ConnexionPanel extends JPanel {
    private ConnexionLabels connexionL;
    private EntryExitButtons connexionB;
    private ConnexionWindow coW;

    public ConnexionPanel(ConnexionWindow coW) {
        this.setLayout(new FlowLayout());

        this.coW = coW;

        // Initialisation panels
        connexionL = new ConnexionLabels();
        connexionB = new ConnexionButtons(coW);

        // Ajout dans le panneau
        this.add(connexionL);
        this.add(connexionB);

        this.setVisible(true);
    }
}
