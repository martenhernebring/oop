package se.hernebring.frequency.symbol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReaderTest {
    
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    //private final PrintStream originalErr = System.err;
    
    @BeforeAll
    static void init() { 
        System.setOut(new PrintStream(outContent));
        //System.setErr(new PrintStream(errContent));
        
    }
    
    @Test
    public void out() {
        String[] args = {"A", "好"};
        try {
            Reader.main(args);
        } catch (IOException e) {
            fail("Unexpected exception thrown");
            e.printStackTrace();
        }
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
