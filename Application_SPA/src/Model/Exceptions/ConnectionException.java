package Model.Exceptions;

public class ConnectionException extends Exception{
    @Override
    public String getMessage() {
        return "Connexion à la BD impossible";
    }
}
