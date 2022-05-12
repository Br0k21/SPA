package UserInterface;

import Controller.ThreadHeure;
import Controller.Utils;
import UserInterface.MainPanel.HeurePanel;
import UserInterface.OwnerResearch.OwnerSearchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.Map;

public class MainWindow extends JFrame {
    private Container mainC;
    private JPanel currentPanel;
    private Map<String,JPanel> panelList;

    private ThreadHeure heure;

    private JMenuBar menuBar;
    private JMenu app, search, stat, info;
    private JMenuItem exit, owner, treatmentForm, species, personal, spa;

    private MenuListener menuListener;

    public MainWindow() {
        super("S.P.A.");
        this.setBounds(400,50,800,500);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Thread heure
        heure = new ThreadHeure(this);

        //Listener
        menuListener = new MenuListener();

        // Conteneur
        mainC = new Container();
        mainC = this.getContentPane();
        mainC.setLayout(new BorderLayout());


        // Barre de menu

        // Application
        exit = new JMenuItem("Quitter");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));

        app = new JMenu("Application");
        app.setMnemonic('A');
        app.add(exit);

        // Recherche
        owner = new JMenuItem("Propriétaire");
        treatmentForm = new JMenuItem("Fiche soin");
        species = new JMenuItem("Espèce");

        search = new JMenu("Recherche");
        search.setMnemonic('R');
        search.add(owner);
        search.addSeparator();
        search.add(treatmentForm);
        search.addSeparator();
        search.add(species);

        // Statistique
        stat = new JMenu("Statistique");
        stat.setMnemonic('S');

        // Informations
        personal = new JMenuItem("Personnelle");
        spa = new JMenuItem("S.P.A.");

        info = new JMenu("Informations");
        info.setMnemonic('I');
        info.add(personal);
        info.addSeparator();
        info.add(spa);

        // MenuBar
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menuBar.add(app);
        menuBar.add(search);
        menuBar.add(stat);
        menuBar.add(info);

        // Ajout des listener
        //MenuListener
        owner.addActionListener(menuListener);

        // Panels
        panelList = Utils.setMainPanels(this);


        mainC.add(panelList.get("principale"), BorderLayout.CENTER);
        currentPanel = panelList.get("principale");
        mainC.add(panelList.get("heure"),BorderLayout.SOUTH);
        heure.start();

        this.setVisible(true);
    }

// Listener
    private class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == owner) {
                changeCenterPanel(new OwnerSearchPanel(MainWindow.this));
            }
            if(e.getSource() == treatmentForm){

            }
            if (e.getSource() == species) {

            }
        }
    }

// Fonctions
    public void updateTime() {
        mainC.remove(panelList.get("heure"));
        panelList.remove("heure");
        panelList.put("heure", new HeurePanel(new GregorianCalendar()));
        mainC.add(panelList.get("heure"),BorderLayout.SOUTH);
        mainC.validate();
    }

    public void changeCenterPanel(JPanel newPanel) {
        mainC.removeAll();
        mainC.add(newPanel, BorderLayout.CENTER);
        mainC.add(panelList.get("heure"), BorderLayout.SOUTH);
        mainC.validate();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void changeCenterPanel() {
        changeCenterPanel(panelList.get("principale"));
    }

// Getters & setters
    public Map<String, JPanel> getPanelList() {
        return panelList;
    }
}
