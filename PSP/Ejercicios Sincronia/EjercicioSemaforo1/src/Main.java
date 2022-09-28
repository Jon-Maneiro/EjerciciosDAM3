public class Main {
    public static void main(String[] args) throws InterruptedException {

        Lector lector1 = new Lector();
        Lector lector2 = new Lector();
        Lector lector3 = new Lector();
        Lector lector4 = new Lector();
        Lector lector5 = new Lector();
        Lector lector6 = new Lector();
        Lector lector7 = new Lector();
        Lector lector8 = new Lector();
        Lector lector9 = new Lector();
        Lector lector10 = new Lector();

        Escritor escritor1 = new Escritor();
        Escritor escritor2 = new Escritor();
        Escritor escritor3 = new Escritor();

        System.out.println("Se abre el programa...");

        lector1.start();
        lector2.start();
        lector3.start();
        lector4.start();
        lector5.start();
        lector6.start();
        lector7.start();
        lector8.start();
        lector9.start();
        lector10.start();

        escritor1.start();
        escritor2.start();
        escritor3.start();

        lector1.join();
        lector2.join();
        lector3.join();
        lector4.join();
        lector5.join();
        lector6.join();
        lector7.join();
        lector8.join();
        lector9.join();
        lector10.join();
        escritor1.join();
        escritor2.join();
        escritor3.join();

        System.out.println("se cierra el programa");

    }
}