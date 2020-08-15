package application;

/**
 *
 * @author Bruno Prestes
 */
public class AgendaCheiaException extends Exception{

    @Override
    public String getMessage() {
        return "Agenda já está cheia";
    }
    
    
}
