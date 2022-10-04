public class Gastador extends Thread{
    static Banco banco = new Banco();

    @Override
    public void run(){
        try {
            while(true) {
                banco.gastarDinero();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
