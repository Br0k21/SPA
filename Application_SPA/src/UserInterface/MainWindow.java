package UserInterface;

import Model.*;

import Controller.ThreadHeure;
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

        // Panels
        panelList = Controller.Utils.setMainPanels(this);

        setContainer();

        setTimeThread();

        setJMenuBar();

        setListener();

        mainC.add(panelList.get(Constant.MAIN), BorderLayout.CENTER);
        currentPanel = panelList.get(Constant.MAIN);

        this.setVisible(true);
    }

// Listener
    private class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == owner) {
                changeCenterPanel(panelList.get(Constant.OWNER));
            }
            if(e.getSource() == treatmentForm){

            }
            if (e.getSource() == species) {

            }
        }
    }

// Fonctions
    public void updateTime() {
        mainC.remove(panelList.get(Constant.TIME));
        panelList.remove(Constant.TIME);
        panelList.put(Constant.TIME, new HeurePanel(new GregorianCalendar()));
        mainC.add(panelList.get(Constant.TIME),BorderLayout.SOUTH);
        mainC.validate();
    }

    public void changeCenterPanel(JPanel newPanel) {
        mainC.removeAll();
        mainC.add(newPanel, BorderLayout.CENTER);
        mainC.add(panelList.get(Constant.TIME), BorderLayout.SOUTH);
        mainC.validate();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void changeCenterPanel() {
        changeCenterPanel(panelList.get(Constant.MAIN));
    }

    private void setJMenuBar() {
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
    }

    private void setTimeThread() {
        // Thread heure
        heure = new ThreadHeure(this);
        mainC.add(panelList.get(Constant.TIME),BorderLayout.SOUTH);
        heure.start();
    }

    private void setListener() {
        //Init Listener
        menuListener = new MenuListener();

        // Ajout des listener
        //MenuListener
        owner.addActionListener(menuListener);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void setContainer() {
        // Conteneur
        mainC = new Container();
        mainC = this.getContentPane();
        mainC.setLayout(new BorderLayout());
    }

// Getters & setters
    public Map<String, JPanel> getPanelList() {
        return panelList;
    }
}
