package UserInterface.TreatmentForm;

import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;

import javax.swing.*;
import java.awt.*;

public class TreatmentPanel extends JPanel {
    private TreatmentLabels treatmentL;
    private EntryExitButtons treatmentB;
    private MainWindow mainW;

    public TreatmentPanel(MainWindow mainW) {
        this.mainW = mainW;
        this.setLayout(new GridLayout(7,1));

        treatmentL = new TreatmentLabels();
        treatmentB = new EntryExitButtons() {
            @Override
            public void buttonValide() {
                System.out.println("Treatment valider");
                System.out.println("Date de début : " + treatmentL.getStartD());
                System.out.println("Date de fin : " + treatmentL.getEndD().getValue());
            }

            @Override
            public void out() {
                mainW.changeCenterPanel();
            }
        };

        this.add(treatmentL);
        this.add(treatmentB);
    }
}
