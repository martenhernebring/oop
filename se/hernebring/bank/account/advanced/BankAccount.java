package se.hernebring.bank.account.advanced;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import se.hernebring.exceptions.InsufficientBalanceException;

public abstract class BankAccount {
    private long accountNumber;
    private static List<Long> accounts = new ArrayList<>();

    public BankAccount() {
        generateNumber();
    }

    private void generateNumber() {
        accountNumber = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        while(accounts.contains(accountNumber) == true){
            accountNumber = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        }
        accounts.add(accountNumber);
    }

    public abstract void withdraw(BigDecimal amount) throws InsufficientBalanceException;

    public abstract void deposit(BigDecimal amount);

    public abstract BigDecimal getBalance();

    @Override
    public abstract String toString();

    public long getAccountNumber() {
        return accountNumber;
    }
}