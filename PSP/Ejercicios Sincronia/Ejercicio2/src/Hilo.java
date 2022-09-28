public class Hilo extends Thread{
    Thread hilo;
    static Contador contador = new Contador();

    Hilo(String nombre){
        hilo = new Thread(this,nombre);
    }

    @Override
    public void run(){
        if(hilo.getName() == "resta"){
            for (int i = 0; i < 10; i++) {
                contador.disminuir();
            }
        }else {
            for (int i = 0; i < 10; i++) {
                contador.incrementar();
            }
        }
    }
}
