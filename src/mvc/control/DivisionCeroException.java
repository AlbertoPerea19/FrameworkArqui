package mvc.control;

public class DivisionCeroException extends Exception{
    public DivisionCeroException(String mensaje){
        super(mensaje);
    }
}