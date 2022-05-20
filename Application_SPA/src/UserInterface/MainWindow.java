package UserInterface;

import Model.*;

import Controller.ThreadHeure;
import UserInterface.MainPanel.HeurePanel;
import UserInterface.MainPanel.MainPanel;
import UserInterface.OwnerResearch.OwnerSearchPanel;
import UserInterface.Template.Wnds;
import UserInterface.TreatmentForm.TreatmentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MainWindow extends Wnds {
    private JPanel currentPanel; // peut etre retirer

    private ThreadHeure heure;

    private JMenuBar menuBar;
    private JMenu app, search, stat, info;
    private JMenuItem exit, owner, treatmentForm, species, personal, spa;

    private MenuListener menuListener;

    public MainWindow() {
        super("S.P.A.");

        setJMenuBar();
        setListener();
        setMain();
        setTime();

        this.setVisible(true);
    }

    // Listener
    private class MenuListener implements ActionListener     {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == owner) {
                changeCenterPanel(getPanelList().get(Constant.OWNER));
            }
            if(e.getSource() == treatmentForm){
                changeCenterPanel(getPanelList().get(Constant.TF));
            }
            if (e.getSource() == species) {

            }
        }
    }


    // Fonctions
    public void updateTime() {
        getContainer().remove(getPanelList().get(Constant.TIME));
        getPanelList().remove(Constant.TIME);
        getPanelList().put(Constant.TIME, new HeurePanel(new GregorianCalendar()));
        getContainer().add(getPanelList().get(Constant.TIME),BorderLayout.SOUTH);
        getContainer().validate();
    }

    public void changeCenterPanel(JPanel newPanel) {
        getContainer().removeAll();
        getContainer().add(newPanel, BorderLayout.CENTER);
        getContainer().add(getPanelList().get(Constant.TIME), BorderLayout.SOUTH);
        getContainer().validate();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void changeCenterPanel() {
        changeCenterPanel(getPanelList().get(Constant.MAIN));
    }

    private void setMain() {
        // Init Panels
        setPanelList(initMainPanels(this));
        // Ajout du panneaux principal
        getContainer().add(getPanelList().get(Constant.MAIN), BorderLayout.CENTER);
        currentPanel = getPanelList().get(Constant.MAIN);
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

    private void setListener() {
        //Init Listener
        menuListener = new MenuListener();
        // Ajout des listener
        //MenuListener
        // Recherche
        owner.addActionListener(menuListener);
        treatmentForm.addActionListener(menuListener);
        // Application
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void setTime() {
        // Thread heure
        heure = new ThreadHeure(this);
        getContainer().add(getPanelList().get(Constant.TIME),BorderLayout.SOUTH);
        heure.start();
    }

    // Getters & setters
    public Map<String, JPanel> getPanelList() {
        return super.getPanelList();
    }

    public  Map<String, JPanel> initMainPanels(MainWindow window) {
        Map<String, JPanel> panels = new HashMap<>();

        // Ajout des panneaux
        panels.put("main", new MainPanel());
        panels.put("time", new HeurePanel(new GregorianCalendar()));
        panels.put("owner", new OwnerSearchPanel(window));
        panels.put("treatmentForm", new TreatmentPanel(window));

        return panels;
    }
}
