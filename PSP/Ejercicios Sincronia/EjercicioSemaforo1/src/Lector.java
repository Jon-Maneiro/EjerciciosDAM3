public class Lector extends Thread{
    static Semaforo semaforo = new Semaforo();

    Lector(){}

    @Override
    public void run(){
        boolean eee = true;
        while(eee){
            try {
                semaforo.getSemaforo().acquire(1);
                eee = false;
                semaforo.getSemaforo().release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(eee){
                System.out.println("Esperando a poder leer..." + Thread.currentThread().getName());
            }else{
                System.out.println("He leido! " + Thread.currentThread().getName());
            }
        }
    }
}
