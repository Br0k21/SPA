package Business;

import DataAccess.InCharge.*;
import Model.Exceptions.ConnectionException;
import Model.InCharge;

public class InChargeManager {
    private InChargeDBAccess in = new InChargeDBAccess();

    public InCharge getInCharge(String ownerID) throws ConnectionException {
        return in.getInCharge(ownerID);
    }
}
