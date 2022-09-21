import java.time.Duration;
import java.time.Instant;

public class Hilo extends Thread{
    private String nombre;
    private String cliente;
    private int productos;
    public Hilo(String nombre, String cliente, int productos) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.productos = productos;
    }

    public void run(){
        Instant start = Instant.now();

        long timeElapsed;
        for(int x = 0; x <= productos;x++){
            timeElapsed = Duration.between(start, Instant.now()).toMillis();
            System.out.println("El " + nombre + " ha procesado el producto " + x + " del "
            + cliente + "ha tardado " + timeElapsed + "milisegundos");

        }
    }
}
