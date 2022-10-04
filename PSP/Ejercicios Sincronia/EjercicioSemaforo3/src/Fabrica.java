import java.util.concurrent.Semaphore;

public class Fabrica {

    static Semaphore CajaMangas = new Semaphore(20);
    static Semaphore CajaCuerpos = new Semaphore(8);

    static int cantidadMangas = 0;

    static int cantidadCuerpos = 0 ;

    public Semaphore getCajaMangas() {
        return CajaMangas;
    }

    public Semaphore getCajaCuerpos() {
        return CajaCuerpos;
    }


    public static int getCantidadMangas() {
        return cantidadMangas;
    }

    public static void setCantidadMangas(int cantidadMangas) {
        Fabrica.cantidadMangas += cantidadMangas;
    }

    public static int getCantidadCuerpos() {
        return cantidadCuerpos;
    }

    public static void setCantidadCuerpos(int cantidadCuerpos) {
        Fabrica.cantidadCuerpos +=cantidadCuerpos;
    }
}
