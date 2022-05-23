package UserInterface.Connexion;

import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;
import com.sun.tools.javac.Main;

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
        connexionB = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                MainWindow w = new MainWindow();
                coW.dispose();
            }

            @Override
            public void out() {
                System.exit(0);
            }
        };

        // Ajout dans le panneau
        this.add(connexionL);
        this.add(connexionB);

        this.setVisible(true);
    }
}
