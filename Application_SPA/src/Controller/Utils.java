package Controller;

import DataAccess.CountryDBAcces;
import UserInterface.*;
import UserInterface.MainPanel.*;

import javax.swing.*;
import java.util.*;

public class Utils {
    public static Map<String, JPanel> setMainPanels(MainWindow window) {
        Map<String, JPanel> panels = new HashMap<>();

        // Ajout des panneaux
        panels.put("principale", new MainPanel());
        panels.put("heure", new HeurePanel(new GregorianCalendar()));
        // panels.put("proprietaire", new OwnerSearchPanel(window));

        return panels;
    }

    public static void setCountries(ArrayList<String> countries) {
        CountryDBAcces countryDBAcces = new CountryDBAcces();

        countryDBAcces.getAllCountries(countries);

        //for (String country: countries) { System.out.println("Je test les countries " +country);}
    }
}
