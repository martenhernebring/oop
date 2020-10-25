package se.hernebring.math;
public class MathFunctions {
    public static double max(double number1, double number2){
        if(number1>number2)
            return number1;
        else return number2;
    }
    public static double min(double number1, double number2){
        if(number1<number2)
            return number1;
        else return number2;
    }
    public static double average(double number1, double number2){
        return (number1+number2)/2;
    }
    public static int max(int number1, int number2){
        if(number1>number2)
            return number1;
        else return number2;
    }
    public static int min(int number1, int number2){
        if(number1<number2)
            return number1;
        else return number2;
    }
    public static double average(int number1, int number2){
        double temp = 0.0+number1+number2;
        return temp/2;
    }

}
