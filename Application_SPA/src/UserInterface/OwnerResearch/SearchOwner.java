package UserInterface.OwnerResearch;

import Controller.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchOwner extends JPanel {
    private ArrayList<String> countries;

    private JComboBox<String> country;
    private JLabel countriesL;

    public SearchOwner() {
        this.setLayout(new FlowLayout());

        countries = new ArrayList<>();
        Utils.setCountries(countries);

        country = new JComboBox<>();
        for(String s: countries) {
            country.addItem(s);
        }

        countriesL = new JLabel("Pays : ");

        this.add(countriesL);
        this.add(country);
    }

    public String getCountry() {
        return country.getSelectedItem().toString();
    }
}
