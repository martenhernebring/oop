package se.hernebring.frequency.symbol;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Table {

    private Map<Character, Integer> symbolFrequencyTable = new TreeMap<>();

    @Override
    public String toString() {
        var tableBuilder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        for (Map.Entry<Character, Integer> entry : symbolFrequencyTable.entrySet()) {
            tableBuilder.append(entry.getKey() + ": " + entry.getValue() + newLine);
        }
        return tableBuilder.toString();
    }

    public Table(Collection<String> textCollection) {
        countSymbolFrequency(textCollection);
    }

    public Table(String textUnit) {
        countSymbolFrequency(textUnit);
    }

    public void countSymbolFrequency(Collection<String> textCollection) {
        for (String textUnit : textCollection) {
            countSymbolFrequency(textUnit);
        }
    }

    final static Logger logger = LoggerFactory.getLogger(Reader.class);

    public void countSymbolFrequency(String textUnit) {
        logger.atDebug().log("Text before split: " + textUnit);
        String[] words = textUnit.split("\\s+");
        logger.atDebug().log("Text after split: " + words);
        countIfSymbol(words);
    }

    private void countIfSymbol(String[] words) {
        if (words != null && words.length > 0) {
            countSymbolFrequency(words);
        } else {
            logger.atWarn().log("File may be deleted in Reader");
            throw new IllegalArgumentException("Text has no symbols and is blank!");
        }
    }

    private void countSymbolFrequency(String[] symbolWords) {
        for (String symbolWord : symbolWords) {
                countSymbolFrequency(symbolWord.toCharArray());
        }
    }

    private void countSymbolFrequency(char[] symbols) {
        for (char symbol : symbols) {
            countSymbolFrequency(symbol);
        }
    }

    // 1 (integer) looks too much like l (variable)
    private static final int ONE = 1;

    private void countSymbolFrequency(char symbol) {
        if (symbolFrequencyTable.containsKey(symbol)) {
            symbolFrequencyTable.put(symbol, symbolFrequencyTable.get(symbol) + ONE);
        } else {
            symbolFrequencyTable.put(symbol, ONE);
        }
    }

}
