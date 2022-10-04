public class CreadorDeCuerpos extends Thread{
    static Fabrica fabrica = new Fabrica();

    CreadorDeCuerpos(){}

    @Override
    public void run(){
        while(true){
            try {
                if(fabrica.getCantidadCuerpos() < 8) {
                    fabrica.getCajaCuerpos().acquire();
                    fabrica.setCantidadCuerpos(1);
                    System.out.println("Meto un cuerpo...");
                    Thread.sleep(1500);
                }
                else{
                    System.out.println("No queda espacio, me voy a por un cafe");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
