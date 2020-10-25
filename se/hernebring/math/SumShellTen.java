package se.hernebring.math;
import java.util.Scanner;

public class SumShellTen {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        if (args.length != 10) {
            System.out.println("Mata in 10 st heltal med enter emellan:");
            int[] numbers10 = new int[10];
            for (int i=0;i<numbers10.length;i++) {
                numbers10[i] = scan.nextInt();
            }
            System.out.println(sumArray(numbers10));
        } else{
            int[] numbers = new int[10];
            for (int i=0;i<args.length;i++) {
                numbers[i]=Integer.parseInt(args[i]);
            }
            System.out.println(sumArray(numbers));
        }
        scan.close();
    }

    static int sumArray(int ... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}