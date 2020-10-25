package se.hernebring.bank.exchange;
public class DKKExchange implements Exchange{

    @Override
    public int convertToCents(int fromCents) {
        // Convert to DKK cents from Swedish cents
        double dkkCents = 0.6724*fromCents*currencyAfterFees;
        return (int) dkkCents;
    }

    @Override
    public int convertFromCents(int toCents) {
        // Convert from DKK cents to Swedish cents
        double sekCents = 1.4871*toCents*currencyAfterFees;
        return (int) sekCents;
    }
    
}
