public class Jardin {

    static int genteDentro = 20;
    static int genteFuera = 10;

    synchronized void entrar() throws InterruptedException {
        Thread.sleep(1000);
        if(genteFuera > 0) {
            genteFuera--;
            genteDentro++;
            System.out.println("Ha entrado alguien! Numero de visitantes: " + genteDentro);
        }else{
            System.out.println("No queda nadie fuera para entrar");
        }
    }

    synchronized void salir() throws InterruptedException {
        Thread.sleep(1000);
        if(genteDentro > 0) {
            genteDentro--;
            System.out.println("Ha salido alguien! Numero de visitantes: " + genteDentro);
        }else{
            System.out.println("No queda nadie dentro, asi que nadie puede salir");
        }
    }

}
