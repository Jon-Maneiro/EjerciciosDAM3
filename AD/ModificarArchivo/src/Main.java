import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Departamento dep;
        File fichero = new File("Departamentos.dat");
        FileInputStream fileIN = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(fileIN);

        File ficheroAUX = new File("DepartamentosAUX.dat");
        FileOutputStream fileOUT = new FileOutputStream(ficheroAUX);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileOUT);

        Scanner sc = new Scanner(System.in);
        System.out.println("Numero departamentos");
        String numerodep = sc.nextLine();
        System.out.println("Nuevo Nombre");
        String nombrenuevo = sc.nextLine();
        System.out.println("Localizacion Nueva");
        String locnueva = sc.nextLine();

        int depmodif = Integer.parseInt(numerodep);
        int departamentoexiste = 0;
        try {
            while (true) { // lectura del fichero
                dep = (Departamento) dataIS.readObject();
                if (dep.getDep() == depmodif) {
                    System.out.println("Datos ANTIGUOS DEL DEPARTAMENTO " + depmodif);
                    System.out.println("Nombre: " + dep.getNombre() + ", Localidad : " +
                            dep.getLoc());
                    dep.setNombre(nombrenuevo);
                    dep.setLoc(locnueva);
                    departamentoexiste = 1;
                }
                Departamento dep2 = new Departamento(dep.getNombre()
                        , dep.getLoc(), dep.getDep());
                dataOS.writeObject(dep2); // inserto en fichero auxiliar
            }
        } catch (Exception e) {
// Se produce EOFException al finalizar la lectura

        }
        dataIS.close();
        dataOS.close();
        if (departamentoexiste > 0) {
            CrearNuevoDep();
            ListadoNuevo();
        }
        else
        {
            System.out.println("El departamento no existe");
        }

    }

    private static void ListadoNuevo() {
    }

    private static void CrearNuevoDep() throws IOException {
        Departamento dep;


        File fichero = new File("DepartamentosAux.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);


        File ficheroaux = new File("Departamentos.dat");
        FileOutputStream fileout = new FileOutputStream(ficheroaux);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
        try {
            while (true) { // lectura del fichero
                dep = (Departamento) dataIS.readObject();


                Departamento dep2 = new Departamento(dep.getNombre(),
                        dep.getLoc() ,dep.getDep());


                dataOS.writeObject(dep2);
            }
        }
        catch (Exception e) {}

        dataIS.close(); // cerrar stream de entrada
        dataOS.close(); // cerrar stream de SALIDA
    }
}
