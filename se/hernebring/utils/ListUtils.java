package se.hernebring.utils;
import java.util.ArrayList;
import java.util.List;

// make InsertionSort reusable by introducing utility class
public class ListUtils {
    public static List<Integer> insertionSort(List<Integer> numbers) {
        List<Integer> newList = new ArrayList<Integer>();
        for (Integer number : numbers) {
            if (newList.isEmpty()) {
                newList.add(number);
                System.out.print("isEmpty: " + number + "\t");
            } else {
                for (int i = 0; i < newList.size(); i++) {
                    Integer current = newList.get(i);
                    if (current > number) {
                        newList.add(i, number);
                        System.out.println(newList);
                        break;
                    }
                }
            }
        }
        System.out.println("");
        return newList;
    }
    
    static int lowestPositive(List<Integer> integers) {
        int lowestPositive = Integer.MAX_VALUE; // no positive values
        for (Integer intgr : integers) {
            if (intgr > 0 && intgr < lowestPositive) {
                lowestPositive = intgr;
            }
        }
        return lowestPositive;
    }

    static int digitSum(List<Integer> integers) {
        int sum = 0; // disregard positive and negative numbers
        for (Integer intgr : integers) {
            for (int i = 1_000_000_000; i > 0; i /= 10) {
                sum += intgr / i;
                intgr = intgr % i;
            }
        }
        return sum;
    }

    static List<Integer> getNegatives(List<Integer> integers){
        List<Integer> negatives = new ArrayList<>();
        for(Integer ntgr: integers){
            if(ntgr<0){
                negatives.add(ntgr);
            }
        }
        return negatives;
    }
    
    static int evenSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                // only adds even numbers to sum
                sum += number;
            }
        }
        return sum;
    }
}
