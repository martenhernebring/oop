package se.hernebring.weather;
public class Observation {
    private int id, hour, min;
    private double temp, windspeed, winddir;
    public static final double ALLDIRECTIONS = 360;
    private static final String[] WD = { "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W",
            "WNW", "NW", "NNW", "N"};
    public static final double PIECE = ALLDIRECTIONS / WD.length; //22.5 degrees
    public static final double HALFPIECE = PIECE/2; //11.25 degrees
    private static final String ERR = "ERROR";

    public String getWinddir() {
        double i = HALFPIECE; //min 11.25
        for (int j = 0; i < (ALLDIRECTIONS + HALFPIECE); i += PIECE, j++) { //max 371.2_4999_9999_9999
            if (winddir >= i && winddir < i + PIECE) {
                return WD[j];
            }
        }
        return ERR; //will never happen
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public void setWinddir(double winddir) {
        this.winddir= winddir % ALLDIRECTIONS; // direction -360 exclusive to 360 exclusive
        if (this.winddir < HALFPIECE) {
            this.winddir += ALLDIRECTIONS; // direction 0 exclusive to 371.2_4999_9999_9999 inclusive
        }
        if (this.winddir < HALFPIECE) {
            this.winddir += ALLDIRECTIONS; // direction 11.25 inclusive to 371.2_4999_9999_9999 inclusive
        }
    }
}