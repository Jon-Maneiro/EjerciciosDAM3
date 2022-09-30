import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("empleados.dat");
        RandomAccessFile fich = new RandomAccessFile(file, "rw");

        // Identificador, entero de 4 bytes
        //• Apellido, cadena de 10 caracteres, 20 bytes (2 por cada, al ser caracteres UNICODE)
        //• Departamento, entero de 4 bytes
        //• Salario, doble de 8 bytes


        fich.seek(fich.length());
        Scanner sc = new Scanner(System.in);
        int id = calcularIdEmpleado(fich);

        System.out.println("Introduce el apellido del empleado(MAX 10 caracteres)");
        String apellido = sc.nextLine();
        apellido = obtenerStringCompleto(apellido);

        System.out.println("Introduce el numero de departamento en el que está(MAX 4 numeros)");
        int departamento = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce el salario del empleado");
        double salario = Double.parseDouble(sc.nextLine());


        //Introducimos los datos
        fich.writeInt(id);
        fich.writeChars(apellido);
        fich.writeInt(departamento);
        fich.writeDouble(salario);

        //Y ahora lo leemos

        fich.seek(0);
        while(fich.getFilePointer() < fich.length()){
            System.out.println("============ \n");
            System.out.println(fich.readInt() + " ");
            System.out.println(fich.readUTF() + " ");
            System.out.println(fich.readInt() + " ");
            System.out.println(fich.readDouble() + " ");
        }

    }
    static String obtenerStringCompleto(String apellido) {
        String modif = apellido;
        if (modif.length() < 10) {
            while (modif.length() < 10) {
                modif = modif + " ";
            }
        } else if (modif.length() > 10) {
            modif = modif.substring(0, 9);
        }

        return modif;
    }

    static int calcularIdEmpleado(RandomAccessFile fich) throws IOException {
        long longitud = fich.length();
        //Si no me equivoco la longitud de cada linea es 28 porque, después de sumar todos
        //los bytes, da 26, pero los ints necesitan un Byte extra para saber si son
        //negativos o positivos.
        int nuevoId = (int)(( longitud / 36 ) + 1);
        return nuevoId;
    }
}