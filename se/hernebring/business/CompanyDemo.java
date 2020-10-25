package se.hernebring.business;
import java.util.Scanner;

public class CompanyDemo {
    public static void main(String[] args) {
        Company theKompanyr = new Company("The Kompanyr", 5562690310L, "Kim Kimzon");
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println(theKompanyr);
            System.out.println("Vill du (1) lägga till inkost/avgift (2) byta VD eller (3) avsluta");
            int choice = scan.nextInt();
            if(choice==3)
                break;
            else if(choice==1){
                System.out.println("Skriv in inkost/avgift:");
                int saldo= scan.nextInt();
                if(saldo>=0){
                    saldo+=theKompanyr.getTotalAssets();
                    theKompanyr.setTotalAssets(saldo);
                } else{
                    saldo+=theKompanyr.getTotalDebts();
                    theKompanyr.setTotalDebts(saldo);
                }
            } else if(choice==2){
                scan.nextLine();
                System.out.println("Skriv in nytt namn på VD:");
                theKompanyr.setNameCEO(scan.nextLine());
            }
            
        } while(true);
        scan.close();
    }
}
