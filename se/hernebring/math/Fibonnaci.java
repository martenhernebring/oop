package se.hernebring.math;
import java.util.ArrayList;
import java.util.List;

public class Fibonnaci {

    static List<Integer> getFibonnaci(int length) {
        List<Integer> fibonnaci = new ArrayList<>();
        int firstNumber = 0;
        int secondNumber = 1;
        fibonnaci.add(secondNumber);
        int thirdNumber;
        for (int i = 1; i < length; i++) {
            thirdNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            fibonnaci.add(thirdNumber);
        }
        return fibonnaci;
    }

    public static void main(String[] args) {
        int n = 10;
        List<Integer> fibo = getFibonnaci(n);
        for (int i = fibo.size() - 1; i >= 0; i--) {
            System.out.println(fibo.get(i));
        }
    }
}
