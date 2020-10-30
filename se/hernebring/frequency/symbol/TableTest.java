package se.hernebring.frequency.symbol;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class TableTest {

    Table symbolFrequencyTable;

    @Test
    void addNewLine() {
        String newLinesText = "\n\n\n";
        try {
            symbolFrequencyTable = new Table(newLinesText);
            fail("Unexpected counting non-symbol character");
        } catch (IllegalArgumentException ex) {
            System.out.println("This is ok: " + ex.getMessage());
        }
        assertThrows(NullPointerException.class, () -> symbolFrequencyTable.toString());
    }

    @Test
    void addExclamationMark() {

        String exclamationMark = "!";
        try {
            symbolFrequencyTable = new Table(exclamationMark);
        } catch (IllegalArgumentException ex) {
            fail("Unexpected exception thrown");
            System.out.println(ex.getMessage());
        }
        String newLine = System.getProperty("line.separator");
        assertEquals("!: 1" + newLine, symbolFrequencyTable.toString());
    }

    final static String book1 = "Språken - Esaias Tegnér\n" + "\n" + "Grekiskan.\n"
            + "Sångmön älskar dig högst, ty modersmålet är kärast.\n"
            + "All den olympiska ätt, gracerna talte som du.\n"
            + "Troget, som klädningen fäst uppå den badande flickan,\n"
            + "Låter du känslorna ses, röjer du tankarnas växt.\n" + "\n" + "Latinet.\n"
            + "Ren är din stämma och skarp som rasslet av härdade klingor,\n"
            + "Hårt, som erövraren hövs, ljuder ditt härskareord.\n"
            + "Stolt, oböjlig och arm; men ur graven behärskar du ännu\n"
            + "Halva Europa. Därpå känner man romarn igen.\n" + "\n" + "Italienskan.\n"
            + "Nöjets och trånadens språk, du är blott en stämma ur flöjten,\n"
            + "Hela ditt väsen är sång, varje ditt ord en sonnett.\n"
            + "Älskade duva, bliv kvar och kuttra om längtan och njutning:\n"
            + "Skada ändå, i ditt land sjunga kastraterna bäst.\n" + "\n" + "Spanskan.\n"
            + "Skön skall du vara och stolt. Jag känner dig icke, men mången,\n"
            + "Vilken ej känner dig mer, prisar dig högt i vår Nord.\n" + "\n" + "Franskan.\n"
            + "Jollrande hoppar du fram och ljuger och komplimenterar,\n"
            + "Dock är din artighet täck, dock är ditt läspande sött.\n"
            + "Hylla vi längre dig ej som drottning för systrarna alla,\n"
            + "Ännu som sällskapsdam lyssna vi gärna till dig.\n"
            + "Skona oss blott för din sång; den är som en dans av de döve:\n"
            + "Fötterna röra de väl, takten förnimma de ej.\n" + "\n" + "Engelskan.\n"
            + "Språk för de stammande gjort, vart ord är ett embryon hos dig,\n"
            + "En hälft stöter du fram, en hälft sväljer du ner.\n"
            + "Allt i ditt fädernesland med ångmaskiner bedrives;\n"
            + "Käraste, skaffa dig snart en för din tunga också!\n" + "\n" + "Tyskan.\n"
            + "Frisk, starklemmad och grov, en jungfru fostrad i skogen,\n"
            + "Smidig därjämte och skön; endast är munnen för bred.\n"
            + "Litet raskare ock! Lägg av ditt flegma, att icke\n"
            + "Meningens början är glömd, innan man hinner dess slut.\n" + "\n" + "Danskan.\n"
            + "Mig behagar du ej. För veklig för nordiska styrkan,\n"
            + "Även för söderns behag mycket för nordisk ännu.\n" + "\n" + "Svenskan.\n"
            + "Ärans och hjältarnas språk! Hur ädelt och manligt du rör dig!\n"
            + "Ren är din klang, säker som solens din gång.\n"
            + "Vistas på höjdernas du, där åskan och stormarna tala,\n"
            + "Dalarnas lägre behag äro ej gjorda för dig.\n"
            + "Spegla ditt anlet i sjön, och friskt från de manliga dragen\n"
            + "Tvätta det främmande smink, kanske det snart är för sent.";
    final static String book2 = "Högt bland Saarijärvis moar bodde\n" + "bonden Paavo på ett frostigt hemman,\n"
            + "skötande dess jord med trägna armar;\n" + "men av Herren väntade han växten.\n"
            + "Och han bodde där med barn och maka,\n" + "åt i svett sitt knappa bröd med dessa,\n"
            + "grävde diken, plöjde opp och sådde.\n" + "Våren kom, och drivan smalt av tegen,\n"
            + "och med den flöt hälften bort av brodden;\n" + "sommarn kom, och fram bröt hagelskuren,\n"
            + "och av den slogs hälften ned av axen;\n" + "hösten kom, och kölden tog vad övrigt.\n"
            + "Paavos maka slet sitt hår och sade:\n" + "»Paavo, Paavo, olycksfödde gubbe,\n"
            + "tagom staven! Gud har oss förskjutit;\n" + "svårt är tigga, men att svälta värre.»\n"
            + "Paavo tog sin hustrus hand och sade:\n" + "»Herren prövar blott, han ej förskjuter.\n"
            + "Blanda du till hälften bark i brödet,\n" + "jag skall gräva dubbelt flera diken,\n"
            + "men av Herren vill jag vänta växten.»\n" + "Hustrun lade hälften bark i brödet,\n"
            + "gubben grävde dubbelt flera diken,\n" + "sålde fåren, köpte råg och sådde.\n"
            + "Våren kom, och drivan smalt av tegen,\n" + "men med den flöt intet bort av brodden;\n"
            + "sommarn kom, och fram bröt hagelskuren,\n" + "men av den slogs hälften ned av axen;\n"
            + "hösten kom, och kölden tog vad övrigt.\n" + "Paavos maka slog sitt bröst och sade:\n"
            + "»Paavo, Paavo, olycksfödde gubbe,\n" + "låt oss dö, ty Gud har oss förskjutit!\n"
            + "Svår är döden, men att leva värre.»\n" + "Paavo tog sin hustrus hand och sade:\n"
            + "»Herren prövar blott, han ej förskjuter.\n" + "Blanda du till dubbelt bark i brödet,\n"
            + "jag vill gräva dubbelt större diken,\n" + "men av Herren vill jag vänta växten.»\n"
            + "Hustrun lade dubbelt bark i brödet,\n" + "gubben grävde dubbelt större diken,\n"
            + "sålde korna, köpte råg och sådde.\n" + "Våren kom, och drivan smalt av tegen,\n"
            + "men med den flöt intet bort av brodden;\n" + "sommarn kom, och fram bröt hagelskuren,\n"
            + "men av den slogs intet ned av axen;\n" + "hösten kom, och kölden, långt från åkern,\n"
            + "lät den stå i guld och vänta skördarn.\n" + "Då föll Paavo på sitt knä och sade:\n"
            + "»Herren prövar blott, han ej förskjuter.»\n" + "Och hans maka föll på knä och sade:\n"
            + "»Herren prövar blott, han ej förskjuter.»\n" + "Men med glädje sade hon till gubben:\n"
            + "»Paavo, Paavo, tag med fröjd till skäran!\n" + "Nu är tid att leva glada dagar,\n"
            + "nu är tid att kasta barken undan\n" + "och att baka bröd av råg allena.»\n"
            + "Paavo tog sin hustrus hand och sade:\n" + "»Kvinna, kvinna, den blott tål att prövas,\n"
            + "som en nödställd nästa ej förskjuter.\n" + "Blanda du till hälften bark i brödet,\n"
            + "ty förfrusen står vår grannes åker!»\n" + "\n" + "- Johan Ludvig Runeberg";

    private void addBooks() {
        List<String> bookCollection = new ArrayList<>();
        bookCollection.add(book1);
        bookCollection.add(book2);
        symbolFrequencyTable = new Table(bookCollection);
    }

    @Test
    void checkIfDotsAre47() {
        addBooks();
        // assertEquals(symbolCounter.getReadOnlyTable().get('.'),47);
        // TODO
    }

    @Test
    void checkIfEis4() {
        addBooks();
        // assertEquals(symbolCounter.getReadOnlyTable().get('E'),4);
        // TODO
    }

}
