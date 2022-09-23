import java.io.Serializable;

public class Departamento implements Serializable {
    private String nombre;
    private String loc;
    private int dep;

    public Departamento(String nombre, String loc, int dep) {
        this.nombre = nombre;
        this.loc = loc;
        this.dep = dep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }
}
