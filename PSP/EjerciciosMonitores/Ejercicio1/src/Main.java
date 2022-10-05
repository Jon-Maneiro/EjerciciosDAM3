public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();

        Persona p1 = new Persona(true);
        Persona p2 = new Persona(false);
        Persona p3 = new Persona(true);
        Persona p4 = new Persona(false);

        p1.start();
        p2.start();
        p3.start();
        p4.start();



    }
}