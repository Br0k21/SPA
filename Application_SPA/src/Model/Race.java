package Model;

public class Race {
    private Integer raceID, speciesID;
    private String raceName;

    public Race(){}

    public Race(Integer raceID, Integer speciesID, String raceName) {
        this.raceID = raceID;
        this.raceName = raceName;
        this.speciesID = speciesID;
    }

    public String getRaceName() {
        return raceName;
    }

    public Integer getRaceID() {
        return raceID;
    }
}
