package UserInterface.OwnerResearch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OwnerLabels extends JPanel {
    private ArrayList<String> countries;

    private JComboBox<String> country;
    private JLabel countriesL;

    public OwnerLabels() {
        this.setLayout(new FlowLayout());

        countries = new ArrayList<>();
        Controller.Utils.setCountries(countries);

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
