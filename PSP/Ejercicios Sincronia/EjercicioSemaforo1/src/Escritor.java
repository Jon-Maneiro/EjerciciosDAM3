public class Escritor extends Thread{
    static Semaforo semaforo = new Semaforo();

    Escritor(){}

    @Override
    public void run(){
        boolean eee = true;
        while(eee){
            try {
                semaforo.getSemaforo().acquire(10);
                eee = false;
                semaforo.getSemaforo().release(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(eee){
                System.out.println("Esperando a tener prioridad..." + Thread.currentThread().getName());
            }else{
                System.out.println("He escrito! " + Thread.currentThread().getName());
            }
        }
    }
}
