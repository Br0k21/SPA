package Controller;

import UserInterface.MainWindow;

public class ThreadHeure extends Thread{
    private MainWindow mainW;

    public ThreadHeure(MainWindow mainW){
        this.mainW = mainW;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                mainW.updateTime();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur dans le thread");
            }
        }
    }

}
