import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        XStream xstream = new XStream();

        xstream.alias("ListaEmpleados", ListaEmpleados.class);
        xstream.alias("DatosEmpleado", Empleado.class);
        xstream.addImplicitCollection(ListaEmpleados.class, "lista");

        FileInputStream fichero = new FileInputStream("empleados.dat");

        ListaEmpleados listadoEmpleados = (ListaEmpleados) xstream.fromXML(fichero);
    }
}