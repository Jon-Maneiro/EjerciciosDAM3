public class Main {
    public static void main(String[] args) {
        Camello camello1 = new Camello("Camello1");
        Camello camello2 = new Camello("Camello2");
        Camello camello3 = new Camello("Camello3");
        Camello camello4 = new Camello("Camello4");
        Camello camello5 = new Camello("Camello5");
        Camello camello6 = new Camello("Camello6");
        Camello camello7 = new Camello("Camello7");
        Camello camello8 = new Camello("Camello8");
        Camello camello9 = new Camello("Camello9");
        Camello camello10 = new Camello("Camello10");

        System.out.println("Empieza la carrera");

        //Si quisieramos que uno ganara siempre, le subiriamos la prioridad para que este más tiempo activo;

        camello1.start();
        camello2.start();
        camello3.start();
        camello4.start();
        camello5.start();
        camello6.start();
        camello7.start();
        camello8.start();
        camello9.start();
        camello10.start();
        try {
            camello1.join();
            camello2.join();
            camello3.join();
            camello4.join();
            camello5.join();
            camello6.join();
            camello7.join();
            camello8.join();
            camello9.join();
            camello10.join();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("La carrera ha terminado");
    }
}