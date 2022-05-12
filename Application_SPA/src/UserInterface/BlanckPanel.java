package UserInterface;

import javax.swing.*;
import java.awt.*;

public class BlanckPanel extends JPanel {
    private JLabel blank;

    public BlanckPanel () {
        this.setLayout(new BorderLayout());
        blank = new JLabel("");
        this.add(blank, BorderLayout.CENTER);
    }
}
