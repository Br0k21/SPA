package Model.Exceptions;

public class IncompletFieldException extends Exception{
    public IncompletFieldException() {}

    @Override
    public String getMessage() {
        return "Compléter tous les champs obligatoire !";
    }
}
