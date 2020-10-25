package se.hernebring.print;
import java.util.Scanner;

public class OddCross {
    public static void main(String[] args) {
        int number=0;
        final Scanner scan = new Scanner(System.in);
        System.out.println("Skriv in ett tal:");
        number = scan.nextInt();
        while (number%2==0){
            System.out.println("Skriv in ett udda tal, tack:");
            number = scan.nextInt();
        }
        for(int i=0;i<number;i++){
            for(int j=0;j<number;j++){
                if(i==j||i==number-j-1)
                    System.out.print("*");
                else
                System.out.print(" ");
            }
            System.out.println();
        }
        scan.close();
    }
}
