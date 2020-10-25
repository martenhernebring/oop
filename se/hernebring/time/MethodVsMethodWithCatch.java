package se.hernebring.time;
public class MethodVsMethodWithCatch {

    public static void main(String[] args) {
        long pre = System.currentTimeMillis();
        doImportantStuff();
        long after = System.currentTimeMillis();
        System.out.println(after-pre+" millisekunder tog metoden.");
    }

    public static void doImportantStuff() {
        int roll = 100 / (int) (Math.random() * 3);
        try {
            for (int i = 0; i < roll; ++i) {
                System.out.println("Rolling...");
            }
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
