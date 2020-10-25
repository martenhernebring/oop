package se.hernebring.io;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class IsFileClassType {
    public static void main(String[] args) throws IOException {
        final String usage = "Usage Ovning7 file";
        if (args == null || args.length != 1) {
            System.out.println(usage);
            System.exit(-1);
        }

        Path theFile = FileSystems.getDefault().getPath(args[0]);
        if (!Files.exists(theFile)) {
            System.out.println("Filen finns inte.");
            System.exit(-1);
        }

        if(args[0].endsWith(".class")){ 
            System.out.println("Filen är en klass-fil");
            System.exit(0);
        }

        byte[] data = new byte[4];
        byte[] cFile = { (byte) -54, (byte) -2, (byte) -70, (byte) -66 };
        int firstFour;
        try (FileInputStream fis = new FileInputStream(args[0])) {
            firstFour= fis.read(data);
        }

        if (firstFour != 4) {
            System.out.println("The file is too small to be a class file!");
            System.exit(-1);
            }

        if (data[0] == cFile[0] && data[1] == cFile[1] && data[2] == cFile[2] && data[3] == cFile[3]) {
            System.out.println("Filen är en klass-fil");
            System.exit(0);
        } else{
            System.out.println("Filen är inte en klass-fil");
            System.exit(0);
        }
    }

}
