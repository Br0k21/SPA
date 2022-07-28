package UserInterface.TreatmentForm;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class TreatmentLabels extends JPanel {
    private JLabel startDate, endDate;
    private JSpinner startD, endD;
    private GregorianCalendar today;
    private SpinnerDateModel modelStart, modelEnd;
    private JPanel debut, fin;

    public TreatmentLabels() {
        this.setLayout(new GridLayout(2,1));
        startDate = new JLabel("Date de début : ");
        endDate = new JLabel("Date de fin : ");

        today = new GregorianCalendar();
        modelStart = new SpinnerDateModel();
        modelEnd = new SpinnerDateModel();

        startD = new JSpinner(modelStart);
        startD.setValue(today.getTime());
        endD = new JSpinner(modelEnd);
        endD.setValue(today.getTime());

        debut = new JPanel();
        debut.setLayout(new FlowLayout());
        debut.add(startDate);
        debut.add(startD);

        fin = new JPanel();
        fin.setLayout(new FlowLayout());
        fin.add(endDate);
        fin.add(endD);


        this.add(debut);
        this.add(fin);
    }

    public JSpinner getStartD() {
        return startD;
    }

    public JSpinner getEndD() {
        return endD;
    }
}
