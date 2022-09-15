import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File f = new File("Text.txt");

        try {
            FileReader fich = new FileReader(f);
            int i;

            while((i = fich.read() ) != -1){
                System.out.println((char) i);
            }
            fich.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}