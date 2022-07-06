package DataAccess.Login;

import Model.Exceptions.ConnectionException;

public interface ILoginAccess {
    public boolean verifyIDandPass(String id, int pass) throws ConnectionException;
}
