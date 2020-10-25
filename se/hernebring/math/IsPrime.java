package se.hernebring.math;
public class IsPrime{

    private static boolean isPrime(int number){
        for(int i=2;i<=number/2;i++){
            if(number%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        for(int j=3;j<100;j+=2){
            if(isPrime(j))
                System.out.println(j);
        }
    }
}