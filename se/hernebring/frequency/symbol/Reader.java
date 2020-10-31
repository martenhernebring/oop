package se.hernebring.frequency.symbol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Reader {

    public static void main(String[] args) {

        Collection<String> onlyText = readFiles(args);

        final Table symbolCounter = new Table(onlyText);

        System.out.println(symbolCounter);
    }

    private static Collection<String> readFiles(String[] fileNames) {
        Collection<String> allLines = new ArrayList<>();
        for (String fileName : fileNames) {
            try {
                List<String> fileLines = Files.readAllLines(Paths.get(fileName));
                allLines.addAll(fileLines);
            } catch (IOException ioe) {
                System.err.printf("File %s does not exist.", ioe.getMessage());
            }
        }
        return allLines;
    }
}
