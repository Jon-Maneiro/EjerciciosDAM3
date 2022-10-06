import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados {

    private List<Empleado> lista = new ArrayList<Empleado>();

    public ListaEmpleados(){};

    public void add(Empleado emp){
        lista.add(emp);
    }

    public List<Empleado> getListaEmpleados(){
        return lista;
    }

}
