import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Introduce el nombre del fichero");
        String nombreFichero = myObj.nextLine();  // Read user input
        File f = new File(nombreFichero);
        if(f.exists()){
            System.out.println("Nombre del fichero : "+f.getName());
            System.out.println("Ruta : "+f.getPath());
            System.out.println("Ruta absoluta : "+f.getAbsolutePath());
            System.out.println("Se puede escribir : "+f.canRead());
            System.out.println("Se puede leer : "+f.canWrite());
            System.out.println("Tamaño : "+f.length());
            System.out.println("Es un directorio : "+f.isDirectory());
            System.out.println("Es un fichero : "+f.isFile());
        }

    }
}