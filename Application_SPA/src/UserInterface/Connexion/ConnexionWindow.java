package UserInterface.Connexion;

import Model.Constant;
import UserInterface.MainWindow;
import UserInterface.Template.Wnds;

public class ConnexionWindow extends Wnds {
    private MainWindow mainW;

    public ConnexionWindow() {
        super("Connexion", 500, 100, 250,150);


        setPanel(Constant.CO,new ConnexionPanel(this));

        getContainer().add(getPanel(Constant.CO));

        this.setVisible(true);
    }
}
