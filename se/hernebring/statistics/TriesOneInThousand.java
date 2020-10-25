package se.hernebring.statistics;
import java.util.Random;

public class TriesOneInThousand {
    public static void main(String[] args) {
        Random randgen = new Random();
        int magicNumber=0;
        int count=0;
        do{
            magicNumber= randgen.nextInt(999)+1;
            count++;
        } while(magicNumber!=123);
        System.out.println("Det tog oss "+count+" gånger innan slumpen gav oss talet 123.");
    }
}
