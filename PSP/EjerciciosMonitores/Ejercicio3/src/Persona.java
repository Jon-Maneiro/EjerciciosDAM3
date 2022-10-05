public class Persona extends Thread{

    static SistemaControl sc = new SistemaControl();

    @Override
    public void run(){
        System.out.println("VAMOS AL MUSEO");
        try {
            Thread.sleep(5000);
            sc.entrar();
            Thread.sleep(10000);
            sc.salir();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
