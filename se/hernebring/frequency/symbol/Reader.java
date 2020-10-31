package se.hernebring.frequency.symbol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Reader {

    public static void main(String[] args) throws IOException {

        final Collection<String> textFileLines = readFiles(args);

        final var symbolCounter = new Table(textFileLines);

        System.out.println(symbolCounter);
    }

    static void printFrequencyTable(Map<Character, Integer> table) {
        for (Map.Entry<Character, Integer> entry : table.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static Collection<String> readFiles(String[] fileNames) throws IOException {
        Collection<String> allLines = new ArrayList<>();
        for (String fileName : fileNames) {
            List<String> fileLines = Files.readAllLines(Paths.get(fileName));
            allLines.addAll(fileLines);
        }
        return allLines;
    }
}
