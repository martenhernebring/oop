package se.hernebring.io;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFileWithBuffer {
    public static void main(String[] args) throws IOException{
        final String usage = "Usage Ovning6 file copy";
        if(args == null){
            System.out.println(usage);
            System.exit(-1);
        }
        if (args.length != 2) {
            System.out.println(usage);
            System.exit(-1);
        }
        
        Path theFile = FileSystems.getDefault().getPath(args[0]);
        if (!Files.exists(theFile)) {
            System.out.println("Filen finns inte.");
            System.exit(-1);
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[0]));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(args[1]))) {
            long pre = System.currentTimeMillis();
            while (true) {
                byte[] data = new byte[65536];
                int size = (byte) bis.read(data);
                if(size == -1){
                    break;
                }
                
                bos.write(data,0,size);
            }
            long after = System.currentTimeMillis();
            System.out.println(after-pre+" millisekunder tog metoden.");
        }
    }

}
