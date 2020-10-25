package se.hernebring.math;
public class MathFunctionsDemo {
    public static void main(String[] args) {
        int test1=1,test2=2;
        double test3=StrictMath.PI,test4=StrictMath.E;

        System.out.println("Störst bland test1 och test2 är "+MathFunctions.max(test1,test2));
        System.out.println("Minst bland test1 och test2 är "+MathFunctions.min(test1,test2));
        System.out.printf("Mellan test1 och test2 är %.2f.\n",MathFunctions.average(test1,test2));
        System.out.printf("Störst bland test3 och test4 är %.2f.\n",MathFunctions.max(test3,test4));
        System.out.printf("Minst bland test3 och test4 är %.2f.\n",MathFunctions.min(test3,test4));
        System.out.printf("Mellan test3 och test4 är %.2f.\n",MathFunctions.average(test3,test4));
        
       
    }
}
