package se.hernebring.frequency.symbol;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Table {

    private Map<Character, Integer> frequencyTable = new LinkedHashMap<>();
    final static Logger logger = LoggerFactory.getLogger(Table.class);
    

    @Override
    public String toString() {
        var tableBuilder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
            tableBuilder.append(entry.getKey() + ": " + entry.getValue() + newLine);
        }
        return tableBuilder.toString();
    }

    public Table(Collection<String> textCollection) {
        logger.atInfo().log("New Table was created from a text collection.");
        addSymbolFrequency(textCollection);
    }

    public Table(String textUnit) {
        logger.atInfo().log("New Table was created from a text unit.");
        addSymbolFrequency(textUnit);
    }

    public void addSymbolFrequency(Collection<String> textCollection) {
        for (String textUnit : textCollection) {
            addSymbolFrequency(textUnit);
        }
    }

    public void addSymbolFrequency(String textUnit) {
        String[] words = textUnit.split("\\s+");
        addIfSymbol(words);
    }

    private void addIfSymbol(String[] words) {
        if (words != null && words.length > 0) {
            addFrequency(words);
        } else {
            logger.atWarn().log("File will be deleted in LinesReader");
            throw new IllegalArgumentException("Text has no symbols and is blank!");
        }
    }

    private void addFrequency(String[] symbolWords) {
        for (String symbolWord : symbolWords) {
            addFrequency(symbolWord.toCharArray());
        }
    }

    private void addFrequency(char[] symbols) {
        for (char symbol : symbols) {
            addFrequency(symbol);
        }
    }

    private static final int ONE = 1; // 1 (integer) looks too much like l (variable)

    private void addFrequency(char symbol) {
        if (frequencyTable.containsKey(symbol)) {
            frequencyTable.put(symbol, frequencyTable.get(symbol) + ONE);
        } else {
            frequencyTable.put(symbol, ONE);
        }
    }

}
