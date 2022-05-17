package UserInterface.TreatmentForm;

import javax.swing.*;
import java.awt.*;

public class TreatmentLabels extends JPanel {
    private JLabel startDate, endDate;
    private JSpinner startD, endD;

    public TreatmentLabels() {
        this.setLayout(new GridLayout(2,2));
        startDate = new JLabel("Date de début : ");
        endDate = new JLabel("Date de fin : ");
        startD = new JSpinner();
        endD = new JSpinner();

        this.add(startDate);
        this.add(startD);
        this.add(endDate);
        this.add(endD);
    }
}
