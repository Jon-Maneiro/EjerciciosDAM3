public class Main {
    public static void main(String[] args) {

        Hilo hilo1 = new Hilo("1",150);
        Hilo hilo2 = new Hilo("2",200);
        Hilo hilo3 = new Hilo("3",250);
        Hilo hilo4 = new Hilo("4",300);
        Hilo hilo5 = new Hilo("5",350);
        Hilo hilo6 = new Hilo("6",400);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();
            hilo6.join();
            System.out.println("Terminada la ejecucion");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}