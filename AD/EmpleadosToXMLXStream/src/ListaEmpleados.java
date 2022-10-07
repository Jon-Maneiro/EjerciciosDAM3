import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados implements Serializable {

    private List<Empleado> lista = new ArrayList<>();

    public ListaEmpleados(){};

    public void add(Empleado emp){
        lista.add(emp);
    }

    public List<Empleado> getListaEmpleados(){
        return lista;
    }

}
