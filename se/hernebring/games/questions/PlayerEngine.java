package se.hernebring.games.questions;
public class PlayerEngine {
    private String name;
    private int question, completed, thisTry, minTries, maxTries;
    private final String[] questions = { "Vad heter huvudstaden i Japan? (enter för att avsluta)", 
                                         "Vad heter huvudstaden i Sverige? (enter för att avsluta)",
                                         "Vad heter huvudstaden i Mongoliet? (enter för att avsluta)", };
    private final String[] correctAnswer = { "Tokyo", "Stockholm", "Ulaanbaatar" };

    public PlayerEngine(){
        question = completed= thisTry= maxTries= 0;
        minTries= Integer.MAX_VALUE;
        System.out.println("Vad heter du i förnamn?");
    }

    public void play() {
        System.out.println(questions[question]);
    }

    public boolean check(String answer) {
        if(answer.equals("")||answer.equals("\n"))
            return false;
        thisTry++;
        if (answer.equals(correctAnswer[question].trim())) {
            question++;
            if(thisTry>maxTries)
                maxTries=thisTry;
            if(thisTry<minTries)
                minTries=thisTry;
            System.out.println("Korrekt!");
            thisTry=0;
            return true;
        } else{
            System.out.println("Fel gissa igen!");
            return true;
        }
    }

    public void quit() {
        completed++;
        System.out.println("Du har spelat klart.");
        if(maxTries!=0){
            System.out.println(name + ", du har spelat " + completed + 
            " omgångar, som snabbast klarade du det på " + minTries+ " gissning.");
            System.out.println("Som sämst klarade du det på " + maxTries + " gissningar.");
        }
        System.out.println("Vill du spela igen? (ja/nej)");
    }

    public boolean want(String toContinue){
        if(toContinue.toLowerCase().trim().equals("nej"))
            return false;
        else return true;
    }

    public void bye(){
        System.out.println("Välkommen åter!");
    }

    public void setName(String name){
        this.name=name;
    }
}
