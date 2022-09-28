import java.util.concurrent.Semaphore;

public class Caja {

    static Semaphore semaforo = new Semaphore(1);
    static int juguetes = 5;
    static int kekw = 0;
    static int xd = 100;

    public void sacarJuguete() throws InterruptedException {
        Thread.sleep(500);
        if(juguetes > 0) {
            juguetes--;
            xd--;
            System.out.println("Se ha sacado un juguete");
        }else{
            System.out.println("No quedan juguetes, sadge");
            semaforo.release(5);
        }
    }

    public void llenarJuguetes() {
        Caja.juguetes = 5;
        kekw = kekw + 5;
        System.out.println("Muy bien mis niños, ya hay " + kekw + "juguetes en la pira, la ofrenda crece por momentos!!!");
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
