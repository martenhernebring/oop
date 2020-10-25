package se.hernebring.weather;
import java.time.LocalTime;

public class Station {

    public static final int START = 0;
    private static final double[] temp = WeatherData.temperature;
    private static final double[] wspeed = WindVelocityData.windvel;
    private static final int[] winddir = WindDirData.winddir;
    private static LocalTime lt;
    private static int hour = -1, minute = -1;
    private static Observation ob;
    private static int id;

    public static void main(String[] args) {

        Observation b;
        for (int i = 0; i < 100; i++) {
            b = nextObservation();
            System.out.printf("Observationer kl. %d:%d. Temperaturen var: %.1f grader Celsius.\n", b.getHour(),
                    b.getMin(), b.getTemp());
            System.out.println("Vindhastigheten var "+b.getWindspeed()+" m/s med riktning "+b.getWinddir()+"\n");
            sleep(61000); //sleep 61 seconds
        }
    }

    public static Observation nextObservation() {
        LocalTime lt = LocalTime.now();
        int h = lt.getHour();
        int m = lt.getMinute();
        if (m != minute || m == minute && h!= hour) {
            hour = h;
            minute = m;
            if (ob == null) {
                id = START;
            } else {
                id++;
            }
            ob = new Observation();
            ob.setId(id);
            ob.setHour(h);
            ob.setMin(m);
            ob.setTemp(temp[id]);
            ob.setWindspeed(wspeed[id]);
            ob.setWinddir(winddir[id]);
        }
        return ob;
    }

    public static void printTime() {
        lt = LocalTime.now();
        hour = lt.getHour();
        minute = lt.getMinute();
        System.out.printf("%d:%d", hour, minute);
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms); // sov i 61 sekunder (61000 millisekunder)
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
