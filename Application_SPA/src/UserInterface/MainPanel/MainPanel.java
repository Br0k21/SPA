package UserInterface.MainPanel;

import Controller.Utils;
import UserInterface.CRUD.CRUDPanel;
import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MainPanel extends JPanel {
    private MainWindow mainW;
    private String idConnexion, nom;
    private Utils utils = new Utils();

    private CRUDPanel crudP;
    private JLabel welcomeMsg;

    public MainPanel(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new GridLayout(8,1));

        idConnexion = mainW.getIdConnexion();
        try {
            nom = utils.getNom(idConnexion);
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        }

        // Init panels
        crudP = new CRUDPanel(mainW);
        welcomeMsg = new JLabel("Bonjour " + nom + ".");

        // Ajout panels
        this.add(welcomeMsg);
        this.add(crudP);
    }
}
