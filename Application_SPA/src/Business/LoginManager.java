package Business;

import DataAccess.Login.ILoginAccess;
import DataAccess.Login.LoginAcces;
import Model.Exceptions.ConnectionException;

public class LoginManager{
    public boolean verifyIDandPass(String id, int pass) throws ConnectionException {
        return new LoginAcces().verifyIDandPass(id,pass);
    }
}
