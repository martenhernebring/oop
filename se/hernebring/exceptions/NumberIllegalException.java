package se.hernebring.exceptions;
public class NumberIllegalException extends RuntimeException{
    String message;

    public NumberIllegalException(){
        
    }

    public NumberIllegalException(String message){
        super(message);
    }

    public NumberIllegalException(String message, Throwable cause){
        super(message, cause);
    }

    public NumberIllegalException(Throwable cause){
        super(cause);
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
}
