package UserInterface.MainPanel;

import javax.swing.*;
import java.awt.*;

public class CRUDPanel extends JPanel {
    public static final Color BUTTON_COLOR = new Color(131, 179, 186);
    private JButton create, read, update, delete;

    public CRUDPanel() {
        this.setLayout(new GridLayout(2,2));
        this.setBackground(BUTTON_COLOR);
        this.setSize(200,100);

        // Initi JButton
        create = new JButton("Ajouter animal");
        read = new JButton("Voir animal");
        update = new JButton("Modifier animal");
        delete = new JButton("Supprimer animal");

        // Ajout JButton
        this.add(create);
        this.add(update);
        this.add(delete);
        this.add(read);
    }
}
