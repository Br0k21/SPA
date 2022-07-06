package DataAccess.Login;

import DataAccess.SingletonConnexion;
import Model.Exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAcces implements ILoginAccess{
    @Override
    public boolean verifyIDandPass(String id, int pass) throws ConnectionException {
        boolean accesGranted = false;
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.logins");
            ResultSet data = statement.executeQuery();

            while(data.next()){
                if(data.getString("employee_id").equals(id))
                    accesGranted = Integer.parseInt(data.getString("employee_password")) == pass;
            }

        } catch (SQLException SQLe) {
            System.out.println("Id inexistant");
        }

        return accesGranted;
    }
}
