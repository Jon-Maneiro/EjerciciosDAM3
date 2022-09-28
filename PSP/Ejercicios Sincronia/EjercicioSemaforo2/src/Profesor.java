public class Profesor extends Thread{
    static Caja caja = new Caja();

    Profesor(){}

    @Override
    public void run(){
        boolean eee = true;
        while(eee){

                try {
                    caja.getSemaforo().acquire(5);
                    caja.llenarJuguetes();
                    System.out.println("Se ha llenado la caja");
                    eee = false;
                    caja.getSemaforo().release(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

    }
}
