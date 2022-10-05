public class Vehiculo extends Thread{

    static Puente puente = new Puente();
    private int peso;

    public Vehiculo(int peso) {
        this.peso = peso;
    }

    @Override
    public void run(){
        try {
            Thread.sleep((long) ((Math.random() * (3000 - 1000)) + 1000));
            System.out.println("Me acerco al puente con " + peso + " kilos");
            puente.entrarPuente(peso);
            Thread.sleep(5000);
            puente.salirPuente(peso);
            System.out.println("He salido del puente con " + peso  + "kilos");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
