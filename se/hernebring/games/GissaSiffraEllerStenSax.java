package se.hernebring.games;
import java.util.Scanner;

public class GissaSiffraEllerStenSax {
    
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        StenSax ss = new StenSax();
        GissaSiffra gs = new GissaSiffra();
        while(true){
            System.out.println("Välj alternativ: (1) Gissa siffra (2) Sten-sax (3) avsluta.");
            int spel=scan.nextInt();
            if(spel==3){
                break;
            } else if(spel==1){
                while(true){
                    ss.starta();
                    //System.out.println(ss.cheat()); Uncomment to cheat
                    System.out.println(StenSax.QUESTION);
                    String choice=scan.next().trim();
                    String play=ss.play(choice);
                    System.out.println(play);
                    if(play.equals("quit")){
                        break;
                    }
                }
            }
            else if(spel==2){
                gs.startaOm();
                while(true){
                    System.out.print(GissaSiffra.QUESTION);
                    boolean guess=gs.guess(scan.nextInt());
                    if(guess) 
                        break;
                    else 
                        System.out.println(gs.getClue());
                }
                System.out.println(GissaSiffra.SUCCESS);
            }
            
        }
        scan.close();
        
    }
}
