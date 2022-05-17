package Business;

import DataAccess.InCharge.*;
import Model.InCharge;

public class InChargeManager {
    public InCharge getInCharge(String ownerID) {
        return new InChargeDBAccess().getInCharge(ownerID);
    }
}
