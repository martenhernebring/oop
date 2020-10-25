package se.hernebring.io;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileWithBufferAndPrint {
    public static void main(String[] args) throws IOException{

        Path theFile = FileSystems.getDefault().getPath("hello.txt");
        if(!Files.exists(theFile)) {
            System.out.println("Filen hello.txt finns inte.");
            System.exit(-1);
        }

        try(BufferedReader br = new BufferedReader(new FileReader("hello.txt"))){
            String str;
            while (true){
            str = br.readLine();
            if(str == null){
                break;
            }
            System.out.println(str);
            }
        } catch (FileNotFoundException ex){
            System.out.println("Filen hello.txt finns inte.");
            System.exit(-1);
        }
    }
}
