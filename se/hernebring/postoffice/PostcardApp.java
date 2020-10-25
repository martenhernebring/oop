package se.hernebring.postoffice;
import java.util.List;

import se.hernebring.utils.ShellUtils;

public class PostcardApp {
    public static void main(String[] args) {
        System.out.println("Skriv in meddelande:");
        String message = ShellUtils.scan.nextLine();

        String[] address = new String[3];
        System.out.println("Skriv in adress");
        int i;
        for (i = 0; i < address.length; i++) {
            address[i] = ShellUtils.scan.nextLine();
        }
        Postcard pc = new Postcard(message, address);

        System.out.println("Välj stil:");
        List<String> styles = pc.getStyles();
        for (i = 1; i <= styles.size(); i++) {
            System.out.println("("+i+") " + styles.get(i-1));
        }
        int styleChoice = ShellUtils.scan.nextInt()-1;
        ShellUtils.scan.nextLine();
        String style = styles.get(styleChoice);
        pc.printGreeting(style);
        
    }
}
