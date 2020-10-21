package se.hernebring.bank;

import java.math.BigDecimal;

public class WithdrawDemo {

    public static void main(String[] args) {
        BigDecimal initialFunds = new BigDecimal("100.00");
        BigDecimal withdraw1 = new BigDecimal("50.00");
        BigDecimal withdraw2 = new BigDecimal("50.01");
        BigDecimal minusOne = new BigDecimal("-1.00");
        SavingsAccount savingsAccount = new SavingsAccount(initialFunds);
        System.out.println("Before withdrawal. Balance: " + savingsAccount.balance());
        try {
            System.out.println("Withdraw 50.00");
            savingsAccount.withdraw(withdraw1);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("After withdrawal. Balance: " + savingsAccount.balance());
        try {
            System.out.println("Withdraw 50.01");
            savingsAccount.withdraw(withdraw2);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Final state of Balance: " + savingsAccount.balance());
        System.out.println("Creating an account with negative amount.");
        try {
            @SuppressWarnings("unused")
            SavingsAccount savingsAccount2 = new SavingsAccount(minusOne);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Withdraw with negative amount.");
        try {
            savingsAccount.withdraw(minusOne);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Deposit with negative amount.");
        try {
            savingsAccount.deposit(minusOne);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Before withdrawal: Balance: 100.00 Withdraw 50.00 After withdrawal: Balance:
     * 50.00 Withdraw 50.01 Couldn't withdraw: Current balance: 50.0 requested
     * withdrawal amount: 50.01 Final state of a: Balance: 50.00
     * 
     * Creating account with a negative amount Negative amount: -1.0 Deposit of a
     * negative amount Can't deposit a negative amount: -1.0 Withdrawal of a
     * negative amount Can't withdraw a negative amount: -1.0
     */

}
