import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

            File d = new File("NuevoDir");
            d.mkdir();
            File f = new File(d, "fichero1.txt");
            f.createNewFile();
            System.out.println("Se han creado los ficheros");

            f.delete();
            System.out.println("Se ha borrado el .txt");
            d.delete();
            System.out.println("Se ha borrado el directorio");


    }
}