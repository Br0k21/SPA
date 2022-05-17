package DataAccess.InCharge;

import DataAccess.SingletonConnexion;
import Model.InCharge;
import Model.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InChargeDBAccess implements IInchargeAccess{
    @Override
    public InCharge getInCharge(String ownerID) {
        InCharge inCharge = new InCharge();
        try {
            Connection connection = SingletonConnexion.getInstance();

            PreparedStatement statement = connection.prepareStatement("select * from spa.in_charge");
            ResultSet data = statement.executeQuery();
            while(data.next()) {
                if(data.getString("owner").equals(ownerID)){
                    if(data.getDate("end_date") != null)
                        inCharge.setEndDate(data.getDate("end_date"));
                    inCharge.setAnimalID(data.getInt("animal"));
                    inCharge.setOwner(data.getString("owner"));
                    inCharge.setStartDate(data.getDate("start_date"));
                }
            }
        } catch (SQLException SQLe) {
            System.out.println("Impossible de récupérer in charge pour le propriétaire " + ownerID);
        }
        return inCharge;
    }
}
