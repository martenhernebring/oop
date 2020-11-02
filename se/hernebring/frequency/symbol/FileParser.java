package se.hernebring.frequency.symbol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileParser {

    private Table textFileSymbolFrequency = null;
    private final static Logger logger = LoggerFactory.getLogger(FileParser.class);

    @Override
    public String toString() {
        if (textFileSymbolFrequency != null) {
            return textFileSymbolFrequency.toString();
        } else {
            logger.atError().log("Class implementation is useless.");
            throw new NullPointerException("There was no text-file containing symbols.");
        }
    }

    public FileParser(String[] textFilePaths){
        for (String textFilePath : textFilePaths) {
            countSymbolFrequencyFrom(textFilePath);
        }
    }

    public void countSymbolFrequencyFrom(String filePath) {
        Path file = Paths.get(filePath);
            try {
                logger.atInfo().log("File "+file.getFileName()+" was opened.");
                countSymbolFrequencyIfText(file);
            } catch (IllegalArgumentException iae) {
                System.err.printf("%s: %s. File will be deleted.%n",filePath , iae.getMessage());
                deleteIllegal(file); 
            } catch (IOException ioe) {
                if (!Files.exists(file)) {
                    logger.atWarn().log("File "+file.getFileName()+" didnt't exist!");
                    fileDoesNotExist(ioe);
                } else {
                    logger.atInfo().log("File "+file.getFileName()+" was not a text-file.");
                    System.err.printf("File %s is not a text-file.%n", file.getFileName());
                }
            } 
    }

    private void countSymbolFrequencyIfText(Path file) throws IOException {
        List<String> extractedLines = Files.readAllLines(file);
        if (textFileSymbolFrequency == null) {
            textFileSymbolFrequency = new Table(extractedLines);
        } else {
            textFileSymbolFrequency.addSymbolFrequency(extractedLines);
        }
    }

    private void deleteIllegal(Path file) {
        try{ 
            Files.delete(file); 
        } catch(IOException ioe) {
            fileDoesNotExist(ioe);
        }     
    }

    private void fileDoesNotExist(IOException ioe) {
        System.err.printf("File %s does not exist.%n", ioe.getMessage());
	}

    
}


