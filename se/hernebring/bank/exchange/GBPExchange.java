package se.hernebring.bank.exchange;
public class GBPExchange implements Exchange{
    @Override
    public int convertToCents(int fromCents) {
        // Convert to GBP cents from Swedish cents
        double gbpCents = 0.0816*fromCents*currencyAfterFees;
        return (int) gbpCents;
    }

    @Override
    public int convertFromCents(int toCents) {
        // Convert from GBP cents to Swedish cents
        double sekCents = 12.2485*toCents*currencyAfterFees;
        return (int) sekCents;
    }
}
