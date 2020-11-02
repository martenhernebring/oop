package se.hernebring.frequency.symbol;

import java.util.Arrays;

public class FileApp {
    private static boolean caseMatters = true;
    private static String[] fileNames;
    
    public static void main(String[] args) {
        if (args.length > 0) {
            fileNames = args;
            readFlags();
            var textSymbolFrequency = new FileParser(fileNames);
            printResult(textSymbolFrequency);
        } else {
            printUsage();
        }
    }
    
    private static void readFlags() {
        if (fileNames[0].trim().equals("-i")) {
            if(fileNames.length == 1) {
                printUsage();
            }
            fileNames = Arrays.copyOfRange(fileNames, 1, fileNames.length);
            caseMatters = false;
        }
    }
    

    private static void printUsage() {
        System.err.println("Usage FileApp file1 ... or FileApp -i file1 ...");
        System.exit(-1);
    }

    private static void printResult(FileParser textSymbolFrequency) {
        try {
            if (caseMatters) {
                System.out.println(textSymbolFrequency);
            } else {
                System.out.println(textSymbolFrequency.toCaseInsensitive());
            }
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
        }
    }
}
