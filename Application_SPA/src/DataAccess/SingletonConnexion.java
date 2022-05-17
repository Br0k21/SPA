package DataAccess;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexion{
    private static Connection uniqueInstance;

    private SingletonConnexion() throws SQLException{
        this.uniqueInstance = getInstance();
    }

    public static Connection getInstance() {
        if (uniqueInstance == null) {
            try {
                uniqueInstance = DriverManager.getConnection("jdbc:mysql://localhost/spa", "root", "root");
            } catch (SQLException SQLe) {
                System.out.println("Connexion à la base de données échouée");
            }


        }
        return uniqueInstance;
    }
}
