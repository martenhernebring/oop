package se.hernebring.bank.account.advanced;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

import se.hernebring.exceptions.InsufficientBalanceException;

public class SavingsAccount extends BankAccount{
    private BigDecimal balance;
    private int savedYear;

    public SavingsAccount(BigDecimal initialBalance) {
        super();
        if (initialBalance.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("A created account can only have positive values: "+initialBalance);
        } else {
            balance = initialBalance;
        }
        savedYear = LocalDate.now().getYear();
    }

    private void yearlyInterest() {
        BigDecimal interest = new BigDecimal("1.01");
        int year = LocalDate.now().getYear();
        while(year > savedYear){
            balance.multiply(interest);
            savedYear++;
        }
        if(year < savedYear){
            throw new DateTimeException("Time goes backwards!");
        }
    }

    public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
        yearlyInterest();
        if (amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Only positive values can be withdrawn: "+amount);
        } else if ((balance.subtract(amount).compareTo(BigDecimal.ZERO) == -1)) {
            String message = String.format("Not enough balance! Balance: %s, Amount: %s", balance.toString(),
                    amount.toString());
            throw new InsufficientBalanceException(message);
        } else {
            balance = balance.subtract(amount);
        }
    }

    public void deposit(BigDecimal amount) {
        yearlyInterest();
        if (amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Only positive values can be deposited: "+amount);
        } else {
            balance.add(amount);
        }
    }

    public BigDecimal getBalance() {
        yearlyInterest();
        return balance;
    }

    @Override
    public String toString() {
        yearlyInterest();
        return String.format("Account Number: %s Balance: %s", super.getAccountNumber(), balance);
    }
}