package se.hernebring.bank.account.advanced;
import java.math.BigDecimal;

public class AccountShell {
    public static void main(String[] args) {
        BigDecimal hundred = new BigDecimal("100.00");
        SavingsAccount savingsAccount = new SavingsAccount(hundred);
        CheckingAccount checkingAccount = new CheckingAccount(hundred);
        System.out.println(savingsAccount.toString());
        System.out.println(checkingAccount.toString());
    }

}
