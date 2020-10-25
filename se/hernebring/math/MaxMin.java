package se.hernebring.math;
import java.util.Scanner;

//Ett program som matar in två heltal och 
//där väljaren får välja om de vill se det minsta eller största.
public class MaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv in ett heltal:");
        int number1 = scanner.nextInt();
        System.out.println("Skriv in ett till heltal:");
        int number2 = scanner.nextInt();
        System.out.println("Vad vill du veta om heltalen (min/max):");
        String choice = scanner.next();
        switch(choice.toLowerCase()){
            case "min":
                if(number1<number2)
                    System.out.println("Minsta talet är "+number1+".");
                else if(number2==number1)
                    System.out.println("Talen är lika stora.");
                else System.out.println("Minsta talet är "+number2+".");
                break;
            case "max":
                if(number1<number2)
                    System.out.println("Största talet är "+number2+".");
                else if(number2==number1)
                    System.out.println("Talen är lika stora.");
                else System.out.println("Största talet är "+number1+".");
                break;
            default:
                System.out.println("Ogiltigt val.");
                System.exit(1);//error
        }
        /*System.out.print("Är du glad? (ja/nej):");
        String answer = scanner.next();
        Exempel switch med sträng
        switch(answer.toLowerCase()){ //omvandlar stora bokstäver till små
            case "ja": 
                System.out.println("Vad bra att du är glad!");
                break;
            case "nej":
                System.out.println("Vad synd att du inte är glad. :(");
                break;
            default:
                System.out.println("Jag förstod dig inte, hoppas du är glad ändå...");
        }*/
        scanner.close();
    }
}
