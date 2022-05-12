package UserInterface.Template;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

public abstract class Window extends JFrame {
    private Container container;
    private Map<String, JPanel> panelList;

    public Window(String title){
        this.setTitle(title);
        this.setBounds(400,50,800,500);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Conteneur
        container = new Container();
        container = this.getContentPane();
        container.setLayout(new BorderLayout());


        this.setVisible(true);
    }
}
