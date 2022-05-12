package UserInterface.Connexion;

import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ConnexionWindow extends JFrame {
    private Container cont;
    private ConnexionPanel coP;
    private MainWindow mainW;

    public ConnexionWindow() {
        super("Connexion");
        this.setLayout(new FlowLayout());
        this.setBounds(550,300,300,150);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        cont = new Container();
        cont = this.getContentPane();

        coP = new ConnexionPanel(this);

        cont.add(coP);

        this.setVisible(true);
    }
}
