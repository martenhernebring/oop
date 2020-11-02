package se.hernebring.frequency.symbol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileParser {

    private Table textSymbolFrequency = null;
    private final static Logger logger = LoggerFactory.getLogger(FileParser.class);

    public FileParser(String[] filePaths) {
        for (String filePath : filePaths) {
            open(Paths.get(filePath));
        }
    }
    
    public void open(Path textFile) {
        try {
            read(textFile);
        } catch (IllegalArgumentException iae) {
            delete(textFile, iae);
        } catch (IOException ioe) {
            if (!Files.exists(textFile)) {
                doesNotExist(textFile, ioe);
            } else {
                isNot(textFile,ioe);
            }
        }
    }

    private void read(Path textFile) throws IOException {
        logger.atInfo().log("File " + textFile.getFileName() + " was opened.");
        List<String> extractedLines = Files.readAllLines(textFile);
        if (textSymbolFrequency == null) {
            textSymbolFrequency = new Table(extractedLines);
        } else {
            textSymbolFrequency.add(extractedLines);
        }
    }
    
    private void delete(Path textFile, IllegalArgumentException iae) {
        System.err.printf("%s: %s. File will be deleted.%n", textFile, iae.getMessage());
        try {
            Files.delete(textFile);
        } catch (IOException ioe) {
            doesNotExist(textFile, ioe);
        }
    }
    
    private void doesNotExist(Path textFile, IOException ioe) {
        logger.atWarn().log("File " + textFile.getFileName() + " didnt't exist!");
        System.err.printf("File %s does not exist.%n", ioe.getMessage());
    }
    
    private void isNot(Path textFile, IOException ioe) {
        logger.atInfo().log("File " + textFile.getFileName() + " was not a text-file.");
        System.err.printf("File %s is not a text-file.%n", textFile.getFileName());   
    }
    
    @Override
    public String toString() {
        if (textSymbolFrequency != null) {
            return textSymbolFrequency.toString();
        } else {
            logger.atError().log("Class implementation is useless.");
            throw new NullPointerException("There was no text-file containing symbols.");
        }
    }

    public String toCaseInsensitive() {
        if (textSymbolFrequency != null) {
            return textSymbolFrequency.getCaseInsensitive();
        } else {
            logger.atError().log("Class implementation is useless.");
            throw new NullPointerException("There was no text-file containing symbols.");
        }
    }

}
