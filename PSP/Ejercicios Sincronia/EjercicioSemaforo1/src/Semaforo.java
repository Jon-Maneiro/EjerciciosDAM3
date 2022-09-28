import java.util.concurrent.Semaphore;

public class Semaforo {
    public static Semaphore semaforo = new Semaphore(10);

    public Semaphore getSemaforo() throws InterruptedException {
        Thread.sleep(500);
        return semaforo;
    }
}
