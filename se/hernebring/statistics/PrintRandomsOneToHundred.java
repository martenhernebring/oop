package se.hernebring.statistics;
import java.util.concurrent.ThreadLocalRandom;

public class PrintRandomsOneToHundred {
    static int[] getRandomArray(int length){
        int[] randomArray = new int[length];
        for(int i=0;i<length;i++){
            randomArray[i]=ThreadLocalRandom.current().nextInt(100)+1;
        }
        return randomArray;
    }

    public static void main(String[] args) {
        if(args.length>0){
            int input= Integer.valueOf(args[0]);
            int[] randomArray = getRandomArray(input);
            for(int random : randomArray){
                System.out.println(random);
            }
        }
    }
}
