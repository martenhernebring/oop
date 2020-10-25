package se.hernebring.math;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumShellAny {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        if (args.length != 0) {
            System.out.println("Mata in valfritt antal heltal och avsluta med 0:");
            boolean wasZero = false;
            while(!wasZero){
                int number = scan.nextInt();
                if(number == 0){
                    wasZero = true;
                } else{
                    numbers.add(number);
                }
            }
        
        } else{
            for (int i=0;i<args.length;i++) {
                numbers.add(Integer.parseInt(args[i]));
            }
        }
        System.out.println(sumArray(numbers));
        scan.close();
    }

    static int sumArray(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += (int) number;
        }
        return sum;
    }

}