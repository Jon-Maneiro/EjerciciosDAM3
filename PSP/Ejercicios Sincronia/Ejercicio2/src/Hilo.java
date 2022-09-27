public class Hilo extends Thread{
    Thread hilo;
    static Contador contador = new Contador();

    Hilo(String nombre){
        hilo = new Thread(this,nombre);
    }

    @Override
    public void run(){
        for(int i= 0; i<10;i++){
            contador.incrementar();
        }

    }
}
