package se.hernebring.math;
import java.util.Scanner;

public class CountNumbers {
    private static int countNumber(long number){
        int count= (int) StrictMath.log10(number);
        return count+1;
    }

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        long choosenNumber=0L;
        do{
            System.out.println("Skriv in ett tal:");
            if(scan.hasNextLong()){
                choosenNumber=scan.nextLong();
                break;
            }
            else
                scan.nextLine();
        } while (true);
        System.out.println("Talet består av "+countNumber(choosenNumber)+" siffror.");
        scan.close();
    }
}
