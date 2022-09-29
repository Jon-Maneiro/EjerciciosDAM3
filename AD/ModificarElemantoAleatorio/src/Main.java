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
        //• Salario, doble de 8 bytes.
        //review, despues de investigar, de nuevo, no se porque son 28 bytes, mi codigo va con 28Bytes por algun motivo

        Scanner sc = new Scanner(System.in);
        long longitud = fich.length();

        System.out.println("Introduce el identificador del empleado");
        int numEmp = Integer.parseInt(sc.nextLine());
        long posicionInicial = 28 * (numEmp - 1);
        long posicionSalario = posicionInicial + 4 + 12 + 4;
        if(numEmp > (longitud/28)+1){
            System.out.println("El empleado no existe");
        }else{
            System.out.println("Introduce el nuevo salario");
            double salarioNuevo = Double.parseDouble(sc.nextLine());
            fich.seek(posicionSalario);
            double salarioAntiguo = fich.readDouble();
            fich.seek(posicionSalario);
            fich.writeDouble(salarioNuevo);
            fich.seek(posicionInicial);
            System.out.println("============");

            System.out.println("ID" + fich.readInt() + " ");

            System.out.println("Apellido" + fich.readUTF());

            System.out.println("Departamento " + fich.readInt() + " ");

            System.out.println("Salario Nuevo" + fich.readDouble() + " ");
            System.out.println("Salario viejo "+ salarioAntiguo);



        }




    }
}