package UserInterface.Connexion;

import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;


public class ConnexionButtons extends EntryExitButtons {
    private ConnexionWindow coW;

    public ConnexionButtons(ConnexionWindow coW) {
        super();
        this.coW = coW;
    }

    @Override
    public void valide() {
        MainWindow w = new MainWindow();
        coW.dispose();
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
