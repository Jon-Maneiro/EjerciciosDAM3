import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {


        ProcessBuilder proceso= new ProcessBuilder("CMD" , "/C" , "DIR");
        proceso.redirectOutput(new  File("salida.txt"));
        try {
            proceso.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Process p = Runtime.getRuntime().exec("CMD /C DIR");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}