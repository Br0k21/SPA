package Business;

import DataAccess.Login.ILoginAccess;
import DataAccess.Login.LoginAcces;
import Model.Exceptions.ConnectionException;

public class LoginManager{
    private LoginAcces lo = new LoginAcces();

    public boolean verifyIDandPass(String id, int pass) throws ConnectionException {
        return lo.verifyIDandPass(id,pass);
    }
}
