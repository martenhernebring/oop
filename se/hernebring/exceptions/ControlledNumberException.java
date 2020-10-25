package se.hernebring.exceptions;
public class ControlledNumberException extends Exception {
    String message;

    public ControlledNumberException(){
        
    }

    public ControlledNumberException(String message){
        super(message);
    }

    public ControlledNumberException(String message, Throwable cause){
        super(message, cause);
    }

    public ControlledNumberException(Throwable cause){
        super(cause);
    }
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
}
