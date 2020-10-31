package se.hernebring.frequency.symbol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class Reader {

    public static void main(String[] args) {

        final Table symbolFrequency = readFiles(args);

        if (symbolFrequency != null) {
            System.out.println(symbolFrequency);
        } else {
            System.err.println("There was no text-file containing symbols.");
        }
    }

    private static Table readFiles(String[] fileNames) {
        Table table = null;
        Collection<String> fileLines = new ArrayList<>();
        for (String fileName : fileNames) {
            Path filePath = Paths.get(fileName);
            try {
                fileLines = Files.readAllLines(filePath);
                if (table == null) {
                    table = new Table(fileLines);
                } else {
                    table.countSymbolFrequency(fileLines);
                }
            } catch (IllegalArgumentException iae) {
                System.err.printf("%s: %s. File will be deleted.%n",filePath, iae.getMessage());
                deleteIllegalFile(filePath); 
            } catch (IOException ioe) {
                if (!Files.exists(filePath)) {
                    fileDoesNotExist(ioe);
                } else {
                    System.err.printf("File %s is not a text-file.%n", ioe.getMessage());
                }
            } 
        }
        return table;
    }

    private static void deleteIllegalFile(Path filePath) {
        try{ 
            Files.delete(filePath); 
        } catch(IOException ioe) {
            fileDoesNotExist(ioe);
        }     
    }

    private static void fileDoesNotExist(IOException ioe) {
        System.err.printf("File %s does not exist.%n", ioe.getMessage());
	}
}


