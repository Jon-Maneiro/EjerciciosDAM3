public class CreadorDeMangas extends Thread{

    static Fabrica fabrica = new Fabrica();

    CreadorDeMangas(){}

    @Override
    public void run(){
        while(true){
            try {
                fabrica.getCajaMangas().acquire(2);
                System.out.println("Meto dos mangas...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
