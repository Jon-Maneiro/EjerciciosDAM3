import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("empleados.dat");
        RandomAccessFile fichero = new RandomAccessFile(file, "rw");

        // Identificador, entero de 4 bytes
        //• Apellido, cadena de 10 caracteres, 20 bytes (2 por cada, al ser caracteres UNICODE)
        //• Departamento, entero de 4 bytes
        //• Salario, doble de 8 bytes

        ListaEmpleados listado = new ListaEmpleados();
        Empleado empAct;
        char[] apellido = new char[10];
        long longitud = fichero.length();
        fichero.seek(0);
        while (fichero.getFilePointer() < longitud) {

            int id = fichero.readInt();
            for (int x = 0; x < 10; x++) {
                apellido[x] = fichero.readChar();
            }
            String s = new String(apellido);
            String ape = s.trim();

            int dep = fichero.readInt();

            double salario = fichero.readDouble();
            empAct = new Empleado(id, ape, dep, salario);
            listado.add(empAct);

        }
        try{
            XStream xstream = new XStream();

            xstream.alias("Empleados" , ListaEmpleados.class);
            xstream.alias("empleado" , Empleado.class);

            xstream.addImplicitCollection(ListaEmpleados.class , "lista");

            xstream.toXML(listado, new FileOutputStream("Empleados.xml"));
            System.out.println("Creado el fichero xml");


        }catch(Exception e){
            e.printStackTrace();
        }

        fichero.close();
    }
}