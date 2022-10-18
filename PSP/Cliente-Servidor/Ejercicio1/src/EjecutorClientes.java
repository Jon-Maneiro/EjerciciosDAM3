public class EjecutorClientes {

    public static void main(String[] args) {
        Thread cl1 = new Cliente();
        Thread cl2 = new Cliente();
        Thread cl3 = new Cliente();
        Thread cl4 = new Cliente();
        Thread cl5 = new Cliente();


        cl1.start();
        cl2.start();
        cl3.start();
        cl4.start();
        cl5.start();
    }
}
