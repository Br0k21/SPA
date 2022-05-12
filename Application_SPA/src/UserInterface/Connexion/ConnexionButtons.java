package UserInterface.Connexion;

import UserInterface.MainWindow;
import UserInterface.Template.EntryExitButtons;
import UserInterface.Template.Wnds;


public class ConnexionButtons extends EntryExitButtons {
    private Wnds coW;

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
