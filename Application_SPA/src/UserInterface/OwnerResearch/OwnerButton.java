package UserInterface.OwnerResearch;

import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerButton extends JPanel {
    private MainWindow mainW;
    private OwnerSearchPanel ownsp;
    private JButton valide, back;

    private ButtonListener buttonListener;

    public OwnerButton(MainWindow mainW, OwnerSearchPanel ownsp) {
        this.mainW = mainW;
        this.ownsp = ownsp;
        this.setLayout(new FlowLayout());

        buttonListener = new ButtonListener();

        valide = new JButton("Valider");
        back = new JButton("Retour");

        valide.addActionListener(buttonListener);
        back.addActionListener(buttonListener);

        this.add(valide);
        this.add(back);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == valide) {
                ownsp.ownerResearch();
                //Ajouter les propriétaire qui ont été trouvé
            }
            if(e.getSource() == back) {
                // Changement de panneau
                mainW.changeCenterPanel();
            }
        }
    }
}
