public class Main {
    public static void main(String[] args) {

        Hilo hilo1 = new Hilo("Empleado1","Cliente1",5);
        Hilo hilo2 = new Hilo("Empleado2","Cliente2",5);

        System.out.println("El Empleado1 comienza a atender al Cliente1");
        hilo1.start();

        System.out.println("El Empleado2 comienza a atender al Cliente2");
        hilo2.start();


        try {
            hilo1.join();
            hilo2.join();
            System.out.println("Se ha terminado de atender a ambos clientes");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}