package se.hernebring.weather;
public class PrintWinddir {
    public static void main(String[] args) {
        var obs = new Observation();
        double HP = Observation.HALFPIECE;
        for (double i = HP; i < Observation.ALLDIRECTIONS+HP; i += HP) {
            obs.setWinddir(i);
            System.out.println(obs.getWinddir());
        }

        obs.setWinddir(371.2499999999999);
        System.out.println(obs.getWinddir());

    }
}
