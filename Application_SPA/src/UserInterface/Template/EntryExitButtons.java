package UserInterface.Template;

import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class EntryExitButtons extends JPanel{
    protected JButton valide, exit;
    protected ButtonListener buttonListener;

    private EntryExitButtons(JButton valide, JButton exit) {
        this.valide = valide;
        this.exit = exit;
        this.buttonListener = new ButtonListener();
        this.setLayout(new FlowLayout());

        valide.addActionListener(buttonListener);
        exit.addActionListener(buttonListener);

        this.add(valide);
        this.add(exit);
    }

    public EntryExitButtons() {
        this(new JButton("Valider"), new JButton("Retour"));
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == valide) validate();
            if(e.getSource() == exit) out();
        }
    }

    public abstract void validate();
    public abstract void out();
}
