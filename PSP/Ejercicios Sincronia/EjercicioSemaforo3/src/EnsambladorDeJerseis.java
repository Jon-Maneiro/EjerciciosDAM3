public class EnsambladorDeJerseis extends Thread{

    static Fabrica fabrica = new Fabrica();

    EnsambladorDeJerseis(){}

    @Override
    public void run(){
        while(true){
            try {
                fabrica.getCajaCuerpos().release();
                System.out.println("Cojo un cuerpo y...");
                fabrica.getCajaMangas().release(2);
                System.out.println("...saco dos mangas y...");
                Thread.sleep(2000);
                System.out.println("...CREO UN JERSEI!!!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

