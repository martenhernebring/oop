package se.hernebring.bank.account;

import static org.junit.jupiter.api.Assertions.*;
import se.hernebring.exceptions.InsufficientBalanceException;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
    private SavingsAccount accountWithHundred;
    
    @BeforeEach
    void initEach() {
        BigDecimal initialFunds = new BigDecimal("100.00");
        accountWithHundred = new SavingsAccount(initialFunds);
    }

    @Test
    void withdrawTooMuch() {
        BigDecimal tooMuch = new BigDecimal("100.01");
        try {
            accountWithHundred.withdraw(tooMuch);
            fail("Exception was NOT thrown!");
        } catch (InsufficientBalanceException ex) {
            System.out.println("Took out one cent too much, OK!");
        } 
        
    }
    
    @Test
    void withdrawAll() {
        //BigDecimal fifty = new BigDecimal("50.00");
        BigDecimal all = new BigDecimal("100.00");
        BigDecimal zero = new BigDecimal("0.00");
        try {
            accountWithHundred.withdraw(all);
            System.out.println("Withdrawing all");
            assertEquals(zero,accountWithHundred.balance());
        } catch (InsufficientBalanceException ex) {
            fail("Unexpected exception thrown");
            System.out.println(ex.getMessage());
        }  
    }

}
