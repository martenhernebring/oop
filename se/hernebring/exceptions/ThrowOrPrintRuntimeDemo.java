package se.hernebring.exceptions;
public class ThrowOrPrintRuntimeDemo{
    public static void main(String[] args) {
        try{
            throw new RuntimeException("bra felmeddelande");
        } catch (RuntimeException ex){
            ex.printStackTrace();
        }
    }
}