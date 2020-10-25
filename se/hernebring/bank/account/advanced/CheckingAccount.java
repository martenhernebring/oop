package se.hernebring.bank.account.advanced;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

import se.hernebring.exceptions.InsufficientBalanceException;

public class CheckingAccount extends BankAccount{
    private BigDecimal balance;
    private int savedYear;
    private int savedMonth;

    public CheckingAccount(BigDecimal initialBalance) {
        super();
        if (initialBalance.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("A created account can only have positive values: "+initialBalance);
        } else {
            balance = initialBalance;
        }
        savedYear = LocalDate.now().getYear();
        savedMonth = LocalDate.now().getMonthValue();
    }

    private void monthlyFee() throws InsufficientBalanceException {
        int fee = 0;
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        if(year != savedYear){
            fee += 10*12*(year-savedYear);
            savedYear = year;
        }
        if(month != savedMonth){
            fee += 10*(month-savedMonth);
            savedMonth = month;
        }
        if(fee < 0){
            throw new DateTimeException("Time goes backwards!");
        } else{
            BigDecimal checkingFee = new BigDecimal(""+fee);
            balance.subtract(checkingFee);
            if(balance.compareTo(BigDecimal.ZERO) == -1){
                throw new InsufficientBalanceException("Account is minus after fees subtracted");
            }
        }
    }

    public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
        monthlyFee();
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
        try {
            monthlyFee();
        } catch (InsufficientBalanceException e) {
            throw new IllegalStateException(this.toString(), e);
        }
        if (amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Only positive values can be deposited: "+amount);
        } else {
            balance.add(amount);
        }
    }

    public BigDecimal getBalance() {
        try {
            monthlyFee();
        } catch (InsufficientBalanceException e) {
            throw new IllegalStateException(this.toString(), e);
        }
        return balance;
    }

    @Override
    public String toString() {
        try {
            monthlyFee();
        } catch (InsufficientBalanceException e) {
            throw new IllegalStateException(this.toString(), e);
        }
        return String.format("Account Number: %s Balance: %s", super.getAccountNumber(), balance);
    }
}