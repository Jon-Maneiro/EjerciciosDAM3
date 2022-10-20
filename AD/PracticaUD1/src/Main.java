import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        /**
         * Posibilidades de hacer:
         * Generador de Encuentros
         * Guardado Rapido de "Personajes" - Solo de referencia vaya
         */

        ListaRecompensas recompensas = new ListaRecompensas(true);
        ListaEnemigos enemigos = new ListaEnemigos(true);



    }


    public static void escribirEncuentroAXML(Encuentro encuentro){
        ListaEncuentros encuentros = new ListaEncuentros();
        encuentros.add(encuentro);
        try {
            XStream xstream = new XStream();
            xstream.addPermission(AnyTypePermission.ANY);
            xstream.alias("Encuentros", ListaEncuentros.class);
            xstream.alias("encuentro" , Encuentro.class);
            xstream.alias("Enemigos",ListaEnemigos.class);
            xstream.alias("enemigo",Enemigo.class);
            xstream.alias("Recompensas",ListaRecompensas.class);
            xstream.alias("recompensa",Recompensa.class);

            xstream.addImplicitCollection(ListaEncuentros.class, "lista");

            xstream.toXML(encuentros, new FileOutputStream("Encuentros.xml"));

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static ListaEncuentros leerEncuentrosDeXML() throws FileNotFoundException {
        ListaEncuentros encuentros;

        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("Encuentros", ListaEncuentros.class);
        xstream.alias("encuentro" , Encuentro.class);
        xstream.alias("Enemigos",ListaEnemigos.class);
        xstream.alias("enemigo",Enemigo.class);
        xstream.alias("Recompensas",ListaRecompensas.class);
        xstream.alias("recompensa",Recompensa.class);
        xstream.addImplicitCollection(ListaEncuentros.class, "lista");

        FileInputStream fichero = new FileInputStream("Encuentros.xml");
        encuentros = (ListaEncuentros) xstream.fromXML(fichero);

        //Leer esto con un Iterator
        return encuentros;
    }

    /**
     * TODO generarXML de Personajes
     */

}