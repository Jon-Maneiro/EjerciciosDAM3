import java.io.*;
import java.nio.channels.Channels;

public class Main {
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

    public static void main(String[] args) throws IOException {

        File file = new File("empleados.dat");
        RandomAccessFile fichero = new RandomAccessFile(file, "rw");

        // Identificador, entero de 4 bytes
        //• Apellido, cadena de 10 caracteres, 20 bytes (2 por cada, al ser caracteres UNICODE)
        //• Departamento, entero de 4 bytes
        //• Salario, doble de 8 bytes

        //Calculamos la longitud del fichero, y ponemos el puntero a 0
        long longitud = fichero.length();
        //el elemento a leer
        int elementoALeer = 3;
        //La posicion de lectura es 32*(id-1);
        long posicionLectura =28 * (elementoALeer - 1);
        InputStream is = Channels.newInputStream(fichero.getChannel());
        byte[] buffer = new byte[20];

        //Comprobamos que sea posible la posicion
        if (posicionLectura > longitud) {
            System.out.println("El empleado no existe");
        } else {
            fichero.seek(posicionLectura);
            System.out.println("============");
            System.out.println("------" + fichero.getFilePointer());
            System.out.println(fichero.readInt() + " ");
            System.out.println("------" + fichero.getFilePointer());
            System.out.println(fichero.readUTF());
            System.out.println("------" + fichero.getFilePointer());
            System.out.println(fichero.readInt() + " ");
            System.out.println("------" + fichero.getFilePointer());
            System.out.println(fichero.readDouble() + " ");
            System.out.println("------" + fichero.getFilePointer());
        }


        fichero.close();
    }
}

//        int[] ids = {1, 2, 3, 4, 5};
//        String[] apellidos = {"Maneiro", "Lopez", "Vehiculo", "Edificio", "Pedro"};
//        int[] departamentos = {10, 20, 30, 40, 50};
//        double[] salario = {1200, 3000, 4000, 2000, 500};
//
//        for (int x = 0; x < 5; x++) {
//            fichero.writeInt(ids[x]);
//            fichero.writeUTF(obtenerStringCompleto(apellidos[x]));
//            fichero.writeInt(departamentos[x]);
//            fichero.writeDouble(salario[x]);
//        }
//
//        fichero.close();

//    long longitud = fichero.length();
//        fichero.seek(0);
//                while(fichero.getFilePointer() < longitud){
//        System.out.println("============ \n");
//        System.out.println(fichero.readInt() + " ");
//        System.out.println(fichero.readUTF() + " ");
//        System.out.println(fichero.readInt() + " ");
//        System.out.println(fichero.readDouble() + " ");
//
//        }