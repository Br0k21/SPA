package Model.Exceptions;

public class DeleteException extends Exception{
    private String animalName;
    public DeleteException(String animalName) {
        this.animalName = animalName;
    }

    @Override
    public String getMessage() {
        return "Suppression de l'animal [" + animalName + "] impossible";
    }
}
