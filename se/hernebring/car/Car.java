package se.hernebring.car;
import java.time.LocalDate;

/**
 * A class that describes cars.
 */
public class Car {
    /** Constants that describe what classifies as a classic car*/
    private static final int CLASSICDIFF=25;

    /** The instance variables for a Car*/
    private int reg,yrb,wgt, wts; 
    private String brn;

    /**Constructors */
    Car(){}
    Car(int regNmbr, String brand, int yearB, int weight, int watts){
        reg=regNmbr;
        brn=brand;
        yrb=yearB;
        wgt=weight;
        wts=watts; //hk hästkrafter
    }


    /** @return simply all instance variables with a space between them
    */
    public String getValues(){
        return reg+" "+brn+" "+yrb+" "+wgt+" "+wts;
    }

    /** @return simply a table with all instance variables with a new line between them
    */
    @Override
    public String toString(){
        String ts="";
        if(isClassic())
            ts="\n"+reg+" is a classic car\n";
        ts=ts+"Regnummer:\t\t"+reg+"\n";
        ts=ts+"Märke:\t\t\t"+brn+"\n";
        ts=ts+"Årsmodell:\t\t"+yrb+"\n";
        ts=ts+"Tjänstevikt(kg):\t"+wgt+"\n";
        ts=ts+"Hästkrafter(hk):\t"+wts+"\n";
        return ts;
    }

    //Om vi behöver formatera String /*public String toString() return String.format("Min data %d %.2f", bosonCount, energy);}

    /**@return simply true if the car is 25 years or older 2020. */
    public boolean isClassic(){
        int year = LocalDate.now().getYear();
        if(year-yrb>CLASSICDIFF)
            return true;
        else return false;
    }

    /**@return simply int the current year  */
    public static int getCurrentYear(){
        return LocalDate.now().getYear();
    }

    /**@return simply int car registration number */
    public int getregNmbr(){
        return reg;
    }

    /**@return simply int year built */
    public int getYearB(){
        return yrb;
    }

    /**@return simply int total mass of the car with a 75 kilo passenger */
    public int getWeight(){
        return wgt;
    }

    /**@return simply int Watts horsepowers (hk) */
    public int getWatts(){
        return wts;
    }

    /**@return simply String car brand */
    public String getBrand(){
        return brn;
    }

    /**@param regNmbr simply int registration number */
    public void setregNmbr(int regNmbr){
        reg= regNmbr;
    }

    /** @param yearB simply int year constructed */
    public void setYearB(int yearB){
        yrb= yearB;
    }

    /** @param weight simply int weight of the car + 75 kilo person */
    public void setWeight(int weight){
        wgt= weight;
    }

    /** @param watts simply int watts in horse power (hk) */
    public void setWatts(int watts){
        wts= watts;
    }

    /** @param brand simply String car brand */
    public void setBrand(String brand){
        brn= brand;
    }
}
