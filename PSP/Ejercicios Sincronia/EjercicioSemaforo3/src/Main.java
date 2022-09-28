public class Main {
    public static void main(String[] args) {

        CreadorDeMangas antonio = new CreadorDeMangas();
        CreadorDeCuerpos pepe = new CreadorDeCuerpos();
        EnsambladorDeJerseis jose = new EnsambladorDeJerseis();

        System.out.println("A TRABAJAR");

        antonio.start();
        pepe.start();
        jose.start();
    }
}