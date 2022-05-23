package DataAccess.InCharge;

import Model.Exceptions.ConnectionException;
import Model.InCharge;

public interface IInchargeAccess {
    InCharge getInCharge(String ownerID) throws ConnectionException;
}
