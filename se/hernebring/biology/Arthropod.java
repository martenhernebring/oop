package se.hernebring.biology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arthropod extends Animal {
    private static List<String> stages;
    private boolean canFly, canSwim;


    public Arthropod(String name, List<String> stages, boolean canFly, boolean canSwim) {
        super(name);
        Arthropod.stages = new ArrayList<>();
        Arthropod.stages.addAll(stages);
        this.canFly = canFly;
        this.canSwim = canSwim;
    }

    public static List<String> getStage() {
        //List<String> rList = List.copyOf(stages); add not possible
        //List<String> rList = Collections.unmodifiableList(stages); //add gives exception
        return Collections.unmodifiableList(stages);
    }

    public boolean canFly() {
        return canFly;
    }

    public boolean canSwim() {
        return canSwim;
    }

}
