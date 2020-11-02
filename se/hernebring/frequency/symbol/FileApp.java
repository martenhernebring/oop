package se.hernebring.frequency.symbol;

public class FileApp {
    public static void main(String[] args) {
        if(args.length > 0){
            processFilesAndPrintResult(args);
        } else{
            System.err.println("Usage FileApp file1 ...");
        }
    }

    private static void processFilesAndPrintResult(String[] args) {
        var textFileSymbolFreqency = new FileParser(args);
        try{
            System.out.println(textFileSymbolFreqency);
        } catch (NullPointerException npe){
            System.err.println(npe.getMessage());
        }
    }
}
