package se.hernebring.frequency.symbol;

import java.util.Arrays;

public class FileApp {
    public static void main(String[] args) {
        if (args.length > 0) {
            processFilesAndPrintResult(args);
        } else {
            System.err.println("Usage FileApp file1 ...");
        }
    }

    private static void processFilesAndPrintResult(String[] args) {
        boolean caseMatters = true;
        if (args[0].trim().equals("-i")) {
            args = Arrays.copyOfRange(args, 1, args.length);
            caseMatters = false;
        }
        var textFileSymbolFreqency = new FileParser(args);
        try {
            if (caseMatters) {
                System.out.println(textFileSymbolFreqency);
            } else {
                System.out.println(textFileSymbolFreqency.getCaseInsensitive());
            }
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
        }
    }
}
