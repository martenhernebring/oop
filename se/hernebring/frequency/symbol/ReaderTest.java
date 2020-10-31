package se.hernebring.frequency.symbol;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReaderTest {
    
    Map<Character,Integer> frequencyTable;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    //private final PrintStream originalErr = System.err;
    
    @BeforeAll
    void init() {
        frequencyTable = new HashMap<>();
        frequencyTable.put('A', Integer.MAX_VALUE);
        frequencyTable.put('好',10); //Chinese character for good
        System.setOut(new PrintStream(outContent));
        //System.setErr(new PrintStream(errContent));
    }
    
    @Test
    public void out() {
        System.out.print(frequencyTable);
        //assertEquals("hello", outContent.toString());
    }

    /*@Test
    public void err() {
        System.err.print("hello again");
        assertEquals("hello again", errContent.toString());
    }*/
    
    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
        //System.setErr(originalErr);
    }
}
