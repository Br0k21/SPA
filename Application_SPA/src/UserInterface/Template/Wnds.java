package UserInterface.Template;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

public abstract class Wnds extends JFrame {
    private Container container;
    private Map<String, JPanel> panelList;

    public Wnds(String title, int x, int y , int w, int h) {
        this.setTitle(title);
        this.setBounds(x,y,w,h);
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

        panelList = new HashMap<>();

        this.setVisible(true);

    }

    public Wnds(String title){
        this(title, 400, 20, 800, 800);
    }

    public Map<String, JPanel> getPanelList() {
        return panelList;
    }

    public void setPanelList(Map<String, JPanel> panelList) {
        this.panelList = panelList;
    }

    public void addPanel(String key, JPanel value){
        panelList.put(key,value);
    }

    public JPanel getPanel(String key) {
        return panelList.get(key);
    }

    public Container getContainer() {
        return container;
    }


}
