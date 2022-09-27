public class Main {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};

        Hilo h1 = new Hilo("hilo1",a);
        Hilo h2 = new Hilo("hilo2",a);

        h1.start();
        h2.start();

    }
}