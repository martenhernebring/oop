package se.hernebring.bank.exchange;
public interface Exchange {

    double currencyAfterFees = 0.99; //Currency conversion fees are usually about 1 percent

    int convertToCents(int fromCents);
    int convertFromCents(int toCents);
}
