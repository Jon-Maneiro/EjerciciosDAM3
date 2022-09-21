public class Main {
    public static void main(String[] args) {
        final Global global = new Global();

        Hilo hilo1 = new Hilo("hilo1", global);
        Hilo hilo2 = new Hilo("hilo2", global);
        Hilo hilo3 = new Hilo("hilo3", global);
        Hilo hilo4 = new Hilo("hilo4", global);

        System.out.println("Comienza el contador, se lanzan los hilos");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();






    }
}