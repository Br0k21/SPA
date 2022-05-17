package UserInterface.TreatmentForm;

import UserInterface.MainWindow;

import javax.swing.*;
import java.awt.*;

public class TreatmentPanel extends JPanel {
    private TreatmentLabels treatmentL;
    private TreatmentButtons treatmentB;
    private MainWindow mainW;

    public TreatmentPanel(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new GridLayout(7,1));

        treatmentL = new TreatmentLabels();
        treatmentB = new TreatmentButtons(mainW);

        this.add(treatmentL);
        this.add(treatmentB);

    }
}
