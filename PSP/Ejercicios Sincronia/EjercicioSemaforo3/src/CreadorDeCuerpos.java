public class CreadorDeCuerpos extends Thread{
    static Fabrica fabrica = new Fabrica();

    CreadorDeCuerpos(){}

    @Override
    public void run(){
        while(true){
            try {
                fabrica.getCajaCuerpos().acquire();
                System.out.println("Meto un cuerpo...");
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
