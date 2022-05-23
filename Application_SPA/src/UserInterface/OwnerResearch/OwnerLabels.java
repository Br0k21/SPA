package UserInterface.OwnerResearch;

import Model.Exceptions.ConnectionException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OwnerLabels extends JPanel {
    private ArrayList<String> countries;

    private Controller.Utils utils;

    private JComboBox<String> country;
    private JLabel countriesL;

    public OwnerLabels() throws ConnectionException {
        this.setLayout(new FlowLayout());
        utils = new Controller.Utils();

        countries = new ArrayList<>();
        utils.getCountries(countries);

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
