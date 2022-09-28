public class Hilo extends Thread{
    //Variable del Jardin
    static Jardin jardin = new Jardin();

    Hilo(){

    }

    @Override
    public void run(){
        int temp = (Math.random() <= Math.random()) ? 1 : 2;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(temp == 1){//entrar
            try {

                jardin.entrar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{//salir
            try {
                jardin.salir();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
