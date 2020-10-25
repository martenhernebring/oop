package se.hernebring.math;
import java.util.Scanner;

//Program som räknar n!
public class FactorialSequence{
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        int n = 21;
        while(n>20){
            System.out.print("Skriv in startvärde för fakulteten: ");
            n = scan.nextInt();
        }
        long result = 1L;
        
        for(int i=1;i<=n;++i){
            result*=i;
        }
        System.out.println("Fakulteten för "+n+" är "+result);
        scan.close();
    }
}