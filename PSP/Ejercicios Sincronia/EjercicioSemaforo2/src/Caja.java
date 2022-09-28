import java.util.concurrent.Semaphore;

public class Caja {

    static Semaphore semaforo = new Semaphore(5);
    static int juguetes = 5;

    static int xd = 100;

    public void sacarJuguete() throws InterruptedException {
        Thread.sleep(500);
        if(juguetes > 0) {
            juguetes--;
            xd--;
            System.out.println("Se ha sacado un juguete, quedan " + juguetes);
        }else{
            System.out.println("No quedan juguetes, sadge");
        }
    }

    public void llenarJuguetes() {
        Caja.juguetes = 10;
    }

    public Semaphore getSemaforo() throws InterruptedException {
        Thread.sleep(500);
        return semaforo;
    }

    public int getJuguetes() {
        return juguetes;
    }

    public int getXd() {
        return xd;
    }

}
