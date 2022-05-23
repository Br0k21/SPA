package UserInterface.CRUD;

import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRUDPanel extends JPanel {
    private MainWindow mainW;

    public static final Color BUTTON_COLOR = new Color(131, 179, 186);
    private JButton create, read, update, delete;
    private CRUDListener crudListener;

    public CRUDPanel(MainWindow mainW) {
        this.mainW = mainW;

        this.setLayout(new GridLayout(2,2));
        this.setBackground(BUTTON_COLOR);
        this.setSize(200,100);

        crudListener = new CRUDListener();

        // Initi JButton
        create = new JButton("Ajouter animal");
        read = new JButton("Voir animal");
        update = new JButton("Modifier animal");
        delete = new JButton("Supprimer animal");

        // Ajout des listener
        create.addActionListener(crudListener);
        read.addActionListener(crudListener);
        update.addActionListener(crudListener);
        delete.addActionListener(crudListener);

        // Ajout JButton
        this.add(create);
        this.add(update);
        this.add(delete);
        this.add(read);
    }

    private class CRUDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == create){
                mainW.changeCenterPanel(new CreatePanel(mainW));
            } if(e.getSource() == update){
                mainW.changeCenterPanel(new AnimalUpdate(mainW));
            } if(e.getSource() == delete) {
                mainW.changeCenterPanel(new AnimalDelete(mainW));
            } if(e.getSource() == read) {
                mainW.changeCenterPanel(new AnimalIDRead(mainW));
            }
        }
    }
}
