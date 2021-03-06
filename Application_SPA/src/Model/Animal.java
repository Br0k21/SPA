package Model;

import com.mysql.cj.result.LocalDateTimeValueFactory;

import java.sql.Date;

public class Animal {
    private Integer animalID, cellnum, raceID;
    private Date arrivedDate, birthDate, chipPlacementDate, tatooPlacementDate, euthanasiaDate;
    private String chipNum, chipLocalisation, tatooNum, euthanasiaReason, name, receptionID, veterinaryID;
    private Double weight;
    private Boolean toIsolate, sterilised, sex, hairOrSkin;


    public Animal() {}

    // Constructeur avec info min pour l'arrivée d'un animal
    public Animal(Boolean sex, Boolean hairOrSkin, Boolean toIsolate, Integer cellnum, Integer raceID, String receptionID, String veterinaryID){
        setNewAnimalId();
        this.arrivedDate = new java.sql.Date(System.currentTimeMillis());
        setSex(sex);
        setHairOrSkin(hairOrSkin);
        setToIsolate(toIsolate);
        setCellnum(cellnum);
        setRaceID(raceID);
        setReceptionID(receptionID);
        setVeterinaryID(veterinaryID);
    }

    private void setNewAnimalId() {
        // création nouvel id unique
        // = dernier id + 1
    }

    public void setAnimalID(Integer animalID) {
        this.animalID = animalID;
    }

    public void setArrivedDate(java.sql.Date arrivedDate) {
        this.arrivedDate = arrivedDate;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCellnum(Integer cellnum) {
        this.cellnum = cellnum;
    }

    public void setChipLocalisation(String chipLocalisation) {
        this.chipLocalisation = chipLocalisation;
    }

    public void setChipNum(String chipNum) {
        this.chipNum = chipNum;
    }

    public void setChipPlacementDate(java.sql.Date chipPlacementDate) {
        this.chipPlacementDate = chipPlacementDate;
    }

    public void setEuthanasiaDate(java.sql.Date euthanasiaDate) {
        this.euthanasiaDate = euthanasiaDate;
    }

    public void setRaceID(Integer raceID) {
        this.raceID = raceID;
    }

    public void setEuthanasiaReason(String euthanasiaReason) {
        this.euthanasiaReason = euthanasiaReason;
    }

    public void setHairOrSkin(Boolean hairOrSkin) {
        this.hairOrSkin = hairOrSkin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTatooNum(String tatooNum) {
        this.tatooNum = tatooNum;
    }

    public void setReceptionID(String receptionID) {
        this.receptionID = receptionID;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public void setTatooPlacementDate(java.sql.Date tatooPlacementDate) {
        this.tatooPlacementDate = tatooPlacementDate;
    }

    public void setSterilised(Boolean sterilised) {
        this.sterilised = sterilised;
    }

    public void setVeterinaryID(String veterinaryID) {
        this.veterinaryID = veterinaryID;
    }

    public void setToIsolate(Boolean toIsolate) {
        this.toIsolate = toIsolate;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getAnimalID() {
        return animalID;
    }

    public java.sql.Date getArrivedDate() {
        return arrivedDate;
    }

    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public java.sql.Date getChipPlacementDate() {
        return chipPlacementDate;
    }

    public Integer getCellNum() {
        return cellnum == null ? 0 : cellnum;
    }

    public java.sql.Date getEuthanasiaDate() {
        return euthanasiaDate;
    }

    public java.sql.Date getTatooPlacementDate() {
        return tatooPlacementDate;
    }

    public Integer getRaceID() {
        return raceID;
    }

    public String getChipLocalisation() {
        return chipLocalisation;
    }

    public String getChipNum() {
        return chipNum;
    }

    public Boolean getSterilised() {
        return sterilised;
    }

    public Boolean getToIsolate() {
        return toIsolate;
    }

    public String getEuthanasiaReason() {
        return euthanasiaReason;
    }

    public Double getWeight() {
        return weight == null ? 0 : weight;
    }

    public Boolean getHairOrSkin() {
        return hairOrSkin;
    }

    public String getName() {
        return name;
    }

    public String getReceptionID() {
        return receptionID;
    }

    public Boolean getSex() {
        return sex;
    }

    public String getTatooNum() {
        return tatooNum;
    }

    public String getVeterinaryID() {
        return veterinaryID;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "animalID=" + animalID +
                ", cellnum=" + cellnum +
                ", raceID=" + raceID +
                ", arrivedDate=" + arrivedDate +
                ", birthDate=" + birthDate +
                ", chipPlacementDate=" + chipPlacementDate +
                ", tatooPlacementDate=" + tatooPlacementDate +
                ", euthanasiaDate=" + euthanasiaDate +
                ", chipNum='" + chipNum + '\'' +
                ", chipLocalisation='" + chipLocalisation + '\'' +
                ", tatooNum='" + tatooNum + '\'' +
                ", euthanasiaReason='" + euthanasiaReason + '\'' +
                ", name='" + name + '\'' +
                ", receptionID='" + receptionID + '\'' +
                ", veterinaryID='" + veterinaryID + '\'' +
                ", weight=" + weight +
                ", toIsolate=" + toIsolate +
                ", sterilised=" + sterilised +
                ", sex=" + sex +
                ", hairOrSkin=" + hairOrSkin +
                '}';
    }
}
