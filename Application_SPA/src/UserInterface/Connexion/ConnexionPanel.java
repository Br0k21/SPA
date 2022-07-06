package UserInterface.Connexion;

import Model.Exceptions.ConnectionException;
import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;
import Controller.Utils;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class ConnexionPanel extends JPanel {
    private ConnexionLabels connexionL;
    private EntryExitButtons connexionB;
    private ConnexionWindow coW;
    private Utils utils = new Utils();

    public ConnexionPanel(ConnexionWindow coW) {
        this.setLayout(new FlowLayout());

        this.coW = coW;

        // Initialisation panels
        connexionL = new ConnexionLabels();
        connexionB = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                boolean connexionAccepted;
                String matricule;
                int password;

                matricule = connexionL.getEmployeeID().getText();
                password = new String(connexionL.getPassword().getPassword()).hashCode();
                try {
                    if (utils.verifyIDandPass(matricule, password))
                        connexion();
                    else
                        JOptionPane.showMessageDialog(null, "Matricule ou mot de passe inccorect", "Connexion refusé", JOptionPane.ERROR_MESSAGE);
                } catch (ConnectionException coE) {
                    JOptionPane.showMessageDialog(null, "Erreur");
                }
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

    private void connexion() {
        MainWindow w = new MainWindow();
        coW.dispose();
    }
}


