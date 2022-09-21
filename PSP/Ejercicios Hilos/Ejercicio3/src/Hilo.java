public class Hilo extends Thread{
    private String numHilo;
    private int dormir;
    public Hilo(String numHilo, int dormir) {
        this.numHilo = numHilo;
        this.dormir = dormir;
    }

    public void run(){
        try {
            Thread.sleep(dormir);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hola desde el hilo" + numHilo);
    }
}
