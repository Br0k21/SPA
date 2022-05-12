package Controller;

import DataAccess.CountryDBAcces;
import UserInterface.*;
import UserInterface.MainPanel.*;
import UserInterface.OwnerResearch.OwnerSearchPanel;

import javax.swing.*;
import java.util.*;

public class Utils {
    public static Map<String, JPanel> setMainPanels(MainWindow window) {
        Map<String, JPanel> panels = new HashMap<>();

        // Ajout des panneaux
        panels.put("main", new MainPanel());
        panels.put("time", new HeurePanel(new GregorianCalendar()));
        panels.put("owner", new OwnerSearchPanel(window));

        return panels;
    }

    public static void setCountries(ArrayList<String> countries) {
        CountryDBAcces countryDBAcces = new CountryDBAcces();

        countryDBAcces.getAllCountries(countries);

        //for (String country: countries) { System.out.println("Je test les countries " +country);}
    }
}
