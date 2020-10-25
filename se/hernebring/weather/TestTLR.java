package se.hernebring.weather;
public class TestTLR {
    public static void main(String[] args) {
        Observation b = new Observation();
    b.setId(8431);
    b.setHour(19);
    b.setMin(30);
    b.setTemp(12.5);
    b.setWindspeed(2.5);
    b.setWinddir(150);
    System.out.printf("Observationer kl. %d:%d var temperaturen: %.1f grader Celsius.\n", b.getHour(), b.getMin(), b.getTemp());
    System.out.println(b.getWinddir());
    }
}
