package se.hernebring.exceptions;
public class CatchArrayIndexNullPointerAritmeticDemo {
    public static void main(String[] args) {
        int badint = 0;
        try{
            badint = imBadYouKnowIt(5);
        } catch(ArrayIndexOutOfBoundsException ioob){
            System.out.println("Index must be within array: "+ioob.getMessage()+" ");
            ioob.printStackTrace();
        }
        
        catch (NullPointerException np){
            System.out.println("Null value is not allowed: "+np.getMessage()+" ");
            np.printStackTrace();
        }
        catch (ArithmeticException a){
            System.out.println("Division by zero not allowed: "+a.getMessage()+" ");
            a.printStackTrace();
        }
        System.out.println(badint);
    }

    private static int imBadYouKnowIt(int value) {
        Integer[] arr = { Integer.valueOf(0), null, Integer.valueOf(2) };
        int i = (int) (Math.random() * 5);
        return value / arr[i];
    }
}
