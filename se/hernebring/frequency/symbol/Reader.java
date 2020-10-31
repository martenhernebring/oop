package se.hernebring.frequency.symbol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Reader {

    private Table symbolFrequency = null;

    @Override
    public String toString() {
        if (symbolFrequency != null) {
            return symbolFrequency.toString();
        } else {
            return "There was no text-file containing symbols.";
        }
    }

    public Reader(String[] fileNames){
        for (String fileName : fileNames) {
            countSymbolFrequencyFromFile(fileName);
        }
    }

    public void countSymbolFrequencyFromFile(String fileName) {
        Path filePath = Paths.get(fileName);
            try {
                countSymbolFrequencyIfText(filePath);
            } catch (IllegalArgumentException iae) {
                System.err.printf("%s: %s. File will be deleted.%n",filePath , iae.getMessage());
                deleteIllegalFile(filePath); 
            } catch (IOException ioe) {
                if (!Files.exists(filePath)) {
                    fileDoesNotExist(ioe);
                } else {
                    System.err.printf("File %s is not a text-file.%n", filePath.getFileName());
                }
            } 
    }

    private void countSymbolFrequencyIfText(Path filePath) throws IOException {
        List<String> fileLines = Files.readAllLines(filePath);
        if (symbolFrequency == null) {
            symbolFrequency = new Table(fileLines);
        } else {
            symbolFrequency.countSymbolFrequency(fileLines);
        }
    }

    private void deleteIllegalFile(Path filePath) {
        try{ 
            Files.delete(filePath); 
        } catch(IOException ioe) {
            fileDoesNotExist(ioe);
        }     
    }

    private void fileDoesNotExist(IOException ioe) {
        System.err.printf("File %s does not exist.%n", ioe.getMessage());
	}

    
}


