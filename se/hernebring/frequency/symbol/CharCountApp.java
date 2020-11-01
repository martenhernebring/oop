package se.hernebring.frequency.symbol;

public class CharCountApp {
    public static void main(String[] args) {
        var textFileSymbolFreqency = new LineReader(args);
        System.out.println(textFileSymbolFreqency);
    }
}
