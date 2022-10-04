public class Banco {

    static int dinero = 20;

    public  synchronized void gastarDinero() throws InterruptedException {

            if (dinero > 0) {
                dinero += 10 * -1;
                System.out.println(dinero);

               // if(dinero < 250){
                    notifyAll();
              //  }
                Thread.sleep((long) Math.floor(Math.random() * 1000));
            } else {
                System.out.println("No queda dinero");
                wait();
            }

    }

    public synchronized void meterDinero() throws InterruptedException {

            if (dinero < 250) {
                dinero -= 10 * -1;
                System.out.println(dinero);

                //if(dinero > 20){
                    notifyAll();
                //}
                Thread.sleep((long) Math.floor(Math.random() * 1000));
            } else {
                System.out.println("Hay demasiado dinero, boof");
                wait();
            }

    }

}
