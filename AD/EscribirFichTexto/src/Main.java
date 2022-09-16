
import java.io.*;

public class Main {
    public static void main(String[] args) {

        File f = new File("Text.txt");
        String text = "Esto es un texto que se va a introducir en un archivo";
        char[] cadena = text.toCharArray();
        try {
            FileWriter fr = new FileWriter(f);
            fr.write(cadena);
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
