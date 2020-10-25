package se.hernebring.biology;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> beeStages = new ArrayList<>();
        beeStages.add("ägg");
        beeStages.add("larv");
        beeStages.add("puppa");
        beeStages.add("imago");
        Arthropod bee = new Arthropod("bi",beeStages, true, false);
        beeStages.add("ägg");
        beeStages.add("nauplius");
        beeStages.add("vuxen");
        Arthropod krill = new Arthropod("krill",beeStages, false, true);
        Chordate människa = new Chordate("människa", 0, "haha", true);
        Chordate glasgrodd = new Chordate("glasgrodd", 4, "fnnt", true);

        List<Animal> animalList = new ArrayList<>();
   
        animalList.add(bee);
        animalList.add(krill);
        animalList.add(människa);
        animalList.add(glasgrodd);

        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }
}
