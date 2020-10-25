package se.hernebring.bank.exchange;
public class EuroExchange implements Exchange{

    @Override
    public int convertToCents(int fromCents) {
        // Convert to Euro cents from Swedish cents
        double euroCents = 0.089*fromCents*currencyAfterFees;
        return (int) euroCents;
    }

    @Override
    public int convertFromCents(int toCents) {
        // Convert from Euro cents to Swedish cents
        double sekCents = 11.2345*toCents*currencyAfterFees;
        return (int) sekCents;
    }
    
}
