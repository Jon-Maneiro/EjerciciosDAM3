import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaEnemigos {

    ArrayList<Enemigo> enemigos = new ArrayList<>();

    public ListaEnemigos() {
        llenarListaEnemigos();
    }

    /**
     * Leer los datos de la lista de enemigos.dat.
     * Si el archivo de Enemigos.dat no existe, se creará en base al fichero excel proporcionado en la carpeta
     */
    public void llenarListaEnemigos(){
        //Primero hay que leer el excel

    }

    /**
     * Posibilidad e insertar un enemigo nuevo en enemigos.dat
     */
    public void insertarNuevoEnemigo(){

    }

}
