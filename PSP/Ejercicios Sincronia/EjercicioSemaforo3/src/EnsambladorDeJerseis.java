public class EnsambladorDeJerseis extends Thread{

    static Fabrica fabrica = new Fabrica();

    EnsambladorDeJerseis(){}

    @Override
    public void run(){
        while(true){
            try {
                if(fabrica.getCantidadMangas() >= 2 && fabrica.getCantidadCuerpos() >=1) {
                    fabrica.getCajaCuerpos().release();
                    fabrica.setCantidadCuerpos(-1);
                    System.out.println("Cojo un cuerpo y...");
                    fabrica.getCajaMangas().release(2);
                    fabrica.setCantidadMangas(-2);
                    System.out.println("...saco dos mangas y...");
                    Thread.sleep(2000);
                    System.out.println("...CREO UN JERSEI!!!");
                }
                else{
                    System.out.println("No hay suficientes piezas para hacer un jersey");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

