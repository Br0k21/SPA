package UserInterface.Connexion;

import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnexionButtons extends JPanel {
    private JButton valide, exit;
    private JFrame w;
    private ButtonListener listener;

    public ConnexionButtons(JFrame w) {
        this.setLayout(new FlowLayout());

        this.w = w;

        // Listener
        listener = new ButtonListener();
        // Initialisation des JButton
        valide = new JButton("Valider");
        exit = new JButton("Quitter");

        // Ajout des évènement
        valide.addActionListener(listener);
        exit.addActionListener(listener);

        // Ajout des bouttons
        this.add(valide);
        this.add(exit);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == valide) {
                MainWindow mainW = new MainWindow();
                w.dispose();
            }
            if(e.getSource() == exit){
                System.exit(0);
            }
        }
    }
}
