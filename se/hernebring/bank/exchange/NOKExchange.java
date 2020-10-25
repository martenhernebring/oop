package se.hernebring.bank.exchange;
public class NOKExchange implements Exchange{

    @Override
    public int convertToCents(int fromCents) {
        // Convert to NOK cents from Swedish cents
        double nokCents = 1.0028*fromCents*currencyAfterFees;
        return (int) nokCents;
    }

    @Override
    public int convertFromCents(int toCents) {
        // Convert from NOK cents to Swedish cents
        double sekCents = 0.9972*toCents*currencyAfterFees;
        return (int) sekCents;
    }
    
}
