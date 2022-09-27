public class Main {
    public static void main(String[] args) {

        Hilo h1 = new Hilo("Hilo1");
        Hilo h2 = new Hilo("hilo2");
        Hilo h3 = new Hilo("hilo3");
        Hilo h4 = new Hilo("hilo4");

        h1.start();
        h2.start();
        h3.start();
        h4.start();

    }
}