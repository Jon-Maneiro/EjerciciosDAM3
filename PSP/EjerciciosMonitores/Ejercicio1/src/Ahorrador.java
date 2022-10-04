public class Ahorrador extends Thread{

    static Banco banco = new Banco();

    @Override
    public void run(){
        try {
            while(true) {
                banco.meterDinero();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
