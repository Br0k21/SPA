package Model.Exceptions;

public class AjoutException extends Exception{
    @Override
    public String getMessage() {
        return "Impossible d'ajouter l'animal a la base de données";
    }
}
