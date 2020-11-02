package se.hernebring.frequency.symbol;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileParserTest {
    FileParser textSymbolFrequency;
    String[] textFilePaths = {"paavo.txt", "spraken.txt"};
    String[] worthlessFilePath = {"worthless.text"};
    String[] notTextFile = {"FileParserText.java"};
    
    @Test
    void notATextFile() {
        try {
            textSymbolFrequency = new FileParser(notTextFile);
            fail("Unexpected addition of non text-file");
        } catch (IllegalArgumentException iae) {
            System.out.println("This is ok: " + iae.getMessage());
        }
    }
    
    /*@Test
    void deleteWorthlessFile() {
        try {
            textSymbolFrequency = new FileParser(worthlessFilePath);
            fail("Unexpected addition of blank file");
        } catch (IllegalArgumentException iae) {
            System.out.println("This is ok: " + iae.getMessage());
        }
    }*/
    
    /*@Test
    void readPaavoAndSpraken(){
        textSymbolFrequency = new FileParser(textFilePaths);
        assertNotNull(textSymbolFrequency);
        System.out.println(textSymbolFrequency);
    }*/
    
    
}
