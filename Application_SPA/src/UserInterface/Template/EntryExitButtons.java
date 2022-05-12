package UserInterface.Template;

import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class EntryExitButtons extends JPanel{
    protected MainWindow mainW;
    protected JButton valide, exit;
    protected ButtonListener buttonListener;

    private EntryExitButtons(MainWindow mainW, JButton valide, JButton exit) {
        this.mainW = mainW;
        this.valide = valide;
        this.exit = exit;
        this.buttonListener = new ButtonListener();
        this.setLayout(new FlowLayout());

        valide.addActionListener(buttonListener);
        exit.addActionListener(buttonListener);

        this.add(valide);
        this.add(exit);
    }

    public EntryExitButtons(MainWindow mainW) {
        this(mainW, new JButton("valider"), new JButton("Retour"));
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == valide) valide();
            if(e.getSource() == exit) exit();
        }
    }

    public abstract void valide();
    public abstract void exit();
}
