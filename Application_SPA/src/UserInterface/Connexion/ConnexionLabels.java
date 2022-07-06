package UserInterface.Connexion;

import javax.swing.*;
import java.awt.*;

public class ConnexionLabels extends JPanel{
    private JLabel employeeIDL, passwordL;
    private JTextField employeeID;
    private JPasswordField password;

    public ConnexionLabels() {
        this.setLayout(new GridLayout(2,2,5,5));

        // Initialisation des J
        // JLabel
        employeeIDL = new JLabel("Matricule : ");
        passwordL = new JLabel("Mot de passe : ");
        // JTextField
        employeeID = new JTextField();
        // JPasswordField
        password = new JPasswordField();

        // Ajout des labels
        this.add(employeeIDL);
        this.add(employeeID);
        this.add(passwordL);
        this.add(password);
    }

    public JTextField getEmployeeID() {
        return employeeID;
    }

    public JPasswordField getPassword() {
        return password;
    }
}
