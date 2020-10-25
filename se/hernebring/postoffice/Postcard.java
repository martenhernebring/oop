package se.hernebring.postoffice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Postcard {
    private String greeting;
    private String address[];
    private List<String> styles;

    public Postcard(String greeting, String address[]) {
        this.greeting = greeting;
        this.address = address;
        styles = new ArrayList<>();
        styles.add("hashtag");
        styles.add("heart");
        styles.add("upcase");
    }

    public void printGreeting(String choice){
        char frame = ' ';
        boolean uppercase = false;
        switch(choice){
            case "hashtag": frame = '#'; break;
            case "heart": frame = '\u2661'; break;
            case "upcase": uppercase = true; break;
            default: break;
        }
        if(uppercase){
            greeting = greeting.toUpperCase();
        }
        int length = greeting.length();
        for(int a=0;a<address.length;a++){
            if(a>length){
                length = address[a].length();
            }
        }
        int padding1 = 4;
        int padding2 = 3;
        int m=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<2*length+padding1+padding2;j++){
                if(i==0||i==4){
                    if(j>=length+padding1){
                        break;
                    } else{
                        System.out.print(frame);
                    }
                } else if(i==1||i==3){
                    if(j==0 | j==length+padding1-1){
                        System.out.print(frame);
                    } else if(j>=length+padding1+padding2){
                        if(i==1){
                            System.out.print(address[0]);
                        } else{
                            System.out.print(address[2]);
                        }
                        break;
                    } else{
                        System.out.print(" ");
                    }
                }
                else if(i==2){
                    if(j==0 | j==length+padding1){
                        System.out.print(frame);
                    } else if(j==2){
                        System.out.print(greeting);
                    } else if(j>=length+padding1+padding2+1){
                        System.out.print(address[1]);
                        break;
                    } else{
                        if(m==0){
                            System.out.print(" ");
                        } else if(m>0 && m<=greeting.length()){
                            //do nothing
                        } else {
                            System.out.print(" ");
                        }
                        m++;
                    }
                }
            }
            System.out.println();
        }
    }

    public List<String> getStyles() {
        return Collections.unmodifiableList(styles);
    }

}
