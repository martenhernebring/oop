package se.hernebring.games;
public class GameDieDemo {
    public static void main(String[] args) {
        GameDie[] gd = new GameDie[6];
        gd[0] = new GameDie(4);
        gd[1] = new GameDie();
        gd[2] = new GameDie(8);
        gd[3] = new GameDie(10);
        gd[4] = new GameDie(12);
        gd[5] = new GameDie(20);

        for(int j=0;j<gd.length;j++){
            roll100(gd[j]);
            System.out.println(gd[j].average());
        }
        /*
        for(int j=0;j<gd.length;j++){
            int rolls= rollUntilMax(gd[j]);
            System.out.printf("Det tog "+rolls+" gånger med medelvärde %.2f.%n",gd[j].average());
        }*/
    }

    
    public static void roll100(GameDie gDie){
        for(int i=0;i<100;i++){
            gDie.roll();    
        }
    }

    public static int rollUntilMax(GameDie gDie){
        int max = gDie.getSides();
        int i,j;
        for(i=0,j=0;j!=max;i++){
            j=gDie.roll();
        }
        return i;
    }
    
}
