package DataAccess;

import Model.Exceptions.ConnectionException;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexion{
    private static Connection uniqueInstance;

    private SingletonConnexion() throws ConnectionException {
        this.uniqueInstance = getInstance();
    }

    public static Connection getInstance() throws ConnectionException {
        if (uniqueInstance == null) {
            try {
                uniqueInstance = DriverManager.getConnection("jdbc:mysql://localhost/spa", "root", "root");
            } catch (SQLException SQLe) {
                throw new ConnectionException();
            }


        }
        return uniqueInstance;
    }
}
