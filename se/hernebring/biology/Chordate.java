package se.hernebring.biology;

public class Chordate extends Animal {
    private int tailLength;
    private String sound;
    private boolean canSwim;

    public Chordate(String name, int tailLength, String sound, boolean canSwim) {
        super(name);
        this.tailLength = tailLength;
        this.sound = sound;
        this.canSwim = canSwim;
    }

    public double getTailLength() {
        return tailLength;
    }

    @Override
    public String toString() {
        return name + ":  Tail length: "+tailLength+" (mm)\tSound: " + sound + "\tCan swim: " + canSwim;
    }

    boolean canSwim() {
        return canSwim;
    }

    String sound() {
        return sound;
    }

}
