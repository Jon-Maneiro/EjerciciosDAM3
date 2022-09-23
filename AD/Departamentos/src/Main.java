import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Departamentos dep;
// declara el fichero
//        File fichero = new File("Departamentos.dat");
//        FileOutputStream fileout = new FileOutputStream(fichero);
// conecta el flujo de bytes al flujo de datos
//        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
//        String nombres[] = { "INFORMÁTICA", "MÁRKETING", "CONTABILIDAD", "VENTAS",
//                "COMPRAS", "PERSONAL", "RECURSOS", "ADMINISTRACIÓN", "ECONOMÍA" };
//        int num[] = { 10, 15, 20, 25, 30, 35, 40, 45, 50 };
//        String loc[] = { "MADRID", "SEVILLA", "LEÓN", "TOLEDO", "GUADALAJARA",
 //               "CUENCA", "OVIEDO", "BILBAO", "VALENCIA" };
 //       for (int i = 0; i < num.length; i++) { // recorro los arrays
//            dep = new Departamentos(nombres[i], num[i], loc[i]);
//            dataOS.writeObject(dep); // escribo el departamento en el fichero
//        }
//        dataOS.close(); // cerrar stream de salida
 //   }//fin main()
        Departamentos dep;
// declara el fichero
        File fichero = new File("Departamentos.dat");
        FileInputStream filein = new FileInputStream(fichero);
// conecta el flujo de bytes al flujo de datos
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        System.out.println("departamentos:");
        try {
            while (true) { // lectura del fichero
                dep = (Departamentos) dataIS.readObject();
                System.out.println("Departamento: "+dep.getDep()+ ", Nombre: " + dep.getNombre() + ", Localidad:" +
                        dep.getLoc());
            }
        } catch (Exception e) {
//Se produce EOFException al finalizar la lectura
            if(e.toString()== "java.io.EOFException")
                System.err.println("Se acabo");
            else System.err.println("Error al leer fichero: "+e.toString());
        }

        dataIS.close(); // cerrar stream de entrada
}
}