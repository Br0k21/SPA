package Business;

import DataAccess.InCharge.*;
import Model.Exceptions.ConnectionException;
import Model.InCharge;

public class InChargeManager {
    public InCharge getInCharge(String ownerID) throws ConnectionException {
        return new InChargeDBAccess().getInCharge(ownerID);
    }
}
