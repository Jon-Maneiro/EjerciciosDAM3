import org.exist.xmldb.XQueryService;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,  InstantiationException, IllegalAccessException {
        String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
        Class cl = Class.forName(driver); //Carga del driver
        Database database = null;
        try {
            database = (Database) cl.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
//Instancia de la BD
        try {
            DatabaseManager.registerDatabase(database); //Registro
        } catch (XMLDBException e) {
            throw new RuntimeException(e);
        }
        // del driver


        String URI = "xmldb:exist://localhost:8083/exist/xmlrpc/db/ColeccionPruebas"; //Colección
        String usu = "admin"; //Usuario
        String usuPwd = "12345Abcde"; //Contraseña
        Collection col = null;
        try {
            col = DatabaseManager.getCollection(URI, usu, usuPwd);


        XQueryService servicio = (XQueryService) col.getService("XPathQueryService", "1.0");
        ResourceSet result = servicio.query("for $em in /EMPLEADOS/EMP_ROW return $em");

        ResourceIterator i; //se utiliza para recorrer un set de recursos
        i = result.getIterator();
        if (!i.hasMoreResources()){
            System.out.println("La consulta no devuelve nada"); }
        while (i.hasMoreResources()){
            Resource r = i.nextResource();
            System.out.println((String) r.getContent()); }
        } catch (XMLDBException e) {
            throw new RuntimeException(e);
        }
    }
}