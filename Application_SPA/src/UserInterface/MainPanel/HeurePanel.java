package UserInterface.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HeurePanel extends JPanel {
    private JLabel heureL;

    public HeurePanel(GregorianCalendar heureNouv) {
        this.setLayout(new GridLayout(2,1));

        String heure, minute;
        heure = String.valueOf(heureNouv.get(Calendar.HOUR_OF_DAY));
        minute = String.valueOf(heureNouv.get(Calendar.MINUTE));
        heureL = new JLabel((heureNouv.get(Calendar.HOUR_OF_DAY) < 10 ? "0" : "" ) + heure + ":" + (heureNouv.get(Calendar.MINUTE) < 10 ? "0" : "")+minute);

        heureL.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(heureL);

    }
}
