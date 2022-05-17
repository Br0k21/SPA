package Model;

import java.util.Date;

public class InCharge {
    private Integer animalID;
    private String owner;
    private Date startDate,endDate;

    public InCharge(Integer animalID, String owner, Date startDate) {
        this.animalID = animalID;
        this.owner = owner;
        this.startDate = startDate;
    }

    public InCharge() {}

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getAnimalID() {
        return animalID;
    }

    public void setAnimalID(Integer animalID) {
        this.animalID = animalID;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }
}
