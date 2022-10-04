public class CreadorDeMangas extends Thread{

    static Fabrica fabrica = new Fabrica();

    CreadorDeMangas(){}

    @Override
    public void run(){
        while(true){
            try {
                if(fabrica.getCantidadMangas() < 20) {
                    fabrica.getCajaMangas().acquire(2);
                    fabrica.setCantidadMangas(2);
                    System.out.println("Meto dos mangas...");
                    Thread.sleep(1000);
                }
                else{
                    System.out.println("No hay espacio, me voy a fumar");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
