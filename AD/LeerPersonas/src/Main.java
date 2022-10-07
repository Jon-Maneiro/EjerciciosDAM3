import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        XStream xstream = new XStream();

        xstream.addPermission(AnyTypePermission.ANY);
        //xstream .addPermission(NoTypePermission.NONE); //forbid everything
        //xstream .addPermission(NullPermission.NULL);   // allow "null"
        //xstream .addPermission(PrimitiveTypePermission.PRIMITIVES); // allow primitive types

        xstream.alias("Empleados", ListaEmpleados.class);
        xstream.alias("empleado", Empleado.class);
        xstream.addImplicitCollection(ListaEmpleados.class, "lista");

        FileInputStream fichero = new FileInputStream("Empleados.xml");

        ListaEmpleados listadoTodos = (ListaEmpleados) xstream.fromXML(fichero);

        System.out.println("Numero de empleados: " + listadoTodos.getListaEmpleados().size());

        List<Empleado> listaEmpleados;
        listaEmpleados = listadoTodos.getListaEmpleados();

        Iterator iterador = listaEmpleados.listIterator();

        while(iterador.hasNext()){
            Empleado e = (Empleado)iterador.next();
            System.out.printf("Apellido: %s, departamento: %d %n",e.getApellido(), e.getDepartamento());

        }
        System.out.println("Fin del listado");

    }
}