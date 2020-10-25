package se.hernebring.io;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteStringToFileAndOverwrite {
    public static void main(String[] args) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("hello.txt"))){
            bw.write("Hello World\n");
        }
    }
}