public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();

        Persona p1 = new Persona(true);
        Persona p2 = new Persona(false);

        p1.start();
        p2.start();


        //Ahorrador ah1 = new Ahorrador();
        //Ahorrador ah2 = new Ahorrador();

        //Gastador ga1 = new Gastador();
        //Gastador ga2 = new Gastador();

        //ah1.start();
        //ah2.start();

        //ga1.start();
        //ga2.start();


    }
}