import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    static String obtenerStringCompleto(String apellido) {
        String modif = apellido;
        if (modif.length() < 10) {
            while (modif.length() < 10) {
                modif = modif + " ";
            }
        } else if (modif.length() > 10) {
                modif = modif.substring(0,9);
        }

        return modif;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("empleados.dat");
        RandomAccessFile fichero = new RandomAccessFile(file, "rw");

        // Identificador, entero de 4 bytes
        //• Apellido, cadena de 10 caracteres, 20 bytes (2 por cada, al ser caracteres UNICODE)
        //• Departamento, entero de 4 bytes
        //• Salario, doble de 8 bytes

        int[] ids = {1, 2, 3, 4, 5};
        String[] apellidos = {"Maneiro", "Lopez", "Vehiculo", "Edificio", "Pedro"};
        int[] departamentos = {10, 20, 30, 40, 50};
        double[] salario = {1200, 3000, 4000, 2000, 500};

        for (int x = 0; x < 5; x++) {
            fichero.writeInt(ids[x]);
            fichero.writeChars(obtenerStringCompleto(apellidos[x]));
            fichero.writeInt(departamentos[x]);
            fichero.writeDouble(salario[x]);
        }

        fichero.close();

    }
}