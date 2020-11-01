package se.hernebring.frequency.symbol;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableTest {

    Table symbolFrequency;

    @Test
    void add3NewLines() {
        String newLinesText = "\n\n\n";
        try {
            symbolFrequency = new Table(newLinesText);
            fail("Unexpected counting non-symbol character");
        } catch (IllegalArgumentException ex) {
            System.out.println("This is ok: " + ex.getMessage());
        }
        assertThrows(NullPointerException.class, () -> symbolFrequency.toString());
    }

    @Test
    void addExclamationMark() {

        String exclamationMark = "!";
        try {
            symbolFrequency = new Table(exclamationMark);
        } catch (IllegalArgumentException ex) {
            fail("Unexpected exception thrown");
            System.out.println(ex.getMessage());
        }
        String newLine = System.getProperty("line.separator");
        assertEquals("!: 1" + newLine, symbolFrequency.toString());
    }

}
