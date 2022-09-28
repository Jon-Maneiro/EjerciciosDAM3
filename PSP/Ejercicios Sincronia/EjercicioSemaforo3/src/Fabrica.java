import java.util.concurrent.Semaphore;

public class Fabrica {

    static Semaphore CajaMangas = new Semaphore(4);
    static Semaphore CajaCuerpos = new Semaphore(3);

    public Semaphore getCajaMangas() {
        return CajaMangas;
    }

    public Semaphore getCajaCuerpos() {
        return CajaCuerpos;
    }
}
