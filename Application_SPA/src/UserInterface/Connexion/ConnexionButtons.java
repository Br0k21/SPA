package UserInterface.Connexion;

import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;
import UserInterface.Template.Wnds;


public class ConnexionButtons extends EntryExitButtons {
    private ConnexionWindow coW;

    public ConnexionButtons(ConnexionWindow coW) {
        this.coW = coW;
    }

    @Override
    public void validate() {
        MainWindow w = new MainWindow();
        coW.dispose();
    }

    @Override
    public void out() {
        System.exit(0);
    }
}
