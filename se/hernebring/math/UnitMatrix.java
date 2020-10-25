package se.hernebring.math;
import java.util.Scanner;

public class UnitMatrix {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.print("Vilken storlek på din enhetsmatris? ");
        int storlek= scan.nextInt();
        for(int i=0;i<storlek;i++){
            for(int j=0;j<storlek;j++){
                if(i==j)
                    System.out.print(1+" ");
                else
                    System.out.print(0+" ");
            }
            System.out.println();
        }
        scan.close();
    }
}
